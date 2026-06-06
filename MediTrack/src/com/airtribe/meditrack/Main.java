package com.airtribe.meditrack;

import com.airtribe.meditrack.analytics.DoctorAnalytics;
import com.airtribe.meditrack.billing.BillingStrategy;
import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.Bill;
import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.factory.BillFactory;
import com.airtribe.meditrack.observer.ConsoleNotifier;
import com.airtribe.meditrack.service.AppointmentService;
import com.airtribe.meditrack.service.DoctorService;
import com.airtribe.meditrack.service.PatientService;
import com.airtribe.meditrack.util.AppConfig;
import com.airtribe.meditrack.util.CSVUtil;
import com.airtribe.meditrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AppConfig.getInstance().showConfig();

        Scanner sc = new Scanner(System.in);

        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();
        AppointmentService appointmentService = new AppointmentService();

        boolean running = true;

        while(running){

            System.out.println("\n===== MEDITRACK =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Create Appointment");
            System.out.println("4. View Doctors");
            System.out.println("5. View Patients");
            System.out.println("6. Generate Bill");
            System.out.println("7. Search Doctor");
            System.out.println("8. Search Patient");
            System.out.println("9. View Appointments");
            System.out.println("10. Cancel Appointment");
            System.out.println("11. Average Doctor Fee");
            System.out.println("12. Filter Doctors");
            System.out.println("13. Save Doctors CSV");
            System.out.println("14. Load Doctors CSV");
            System.out.println("15. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:

                    int did = IdGenerator.getInstance().nextId();

                    System.out.println("Generated ID: " + did);

                    System.out.print("Name: ");
                    String dname = sc.nextLine();

                    System.out.print("Age: ");
                    int dage = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Specialization: ");
                    String spec = sc.nextLine();

                    System.out.print("Fee: ");
                    double fee = sc.nextDouble();

                    doctorService.addDoctor(
                        new Doctor(did,dname,dage,spec,fee)
                    );

                    break;

                case 2:

                    int pid = IdGenerator.getInstance().nextId();

                    System.out.println("Generated ID: " + pid);

                    System.out.print("Name: ");
                    String pname = sc.nextLine();

                    System.out.print("Age: ");
                    int page = sc.nextInt();

                    patientService.addPatient(
                        new Patient(pid,pname,page)
                    );

                    break;

                case 3:

                    System.out.print("Enter patient ID: ");
                    int patientId = sc.nextInt();

                    Patient patient =
                        patientService.searchPatient(patientId);

                    if(patient == null){
                        System.out.println("Patient not found");
                        break;
                    }

                    List<Doctor> doctors =
                        doctorService.getDoctors();

                    for(int i=0;i<doctors.size();i++){
                        System.out.println(
                            (i+1) + ". " + doctors.get(i)
                        );
                    }

                    System.out.print("Choose doctor: ");
                    int docChoice = sc.nextInt();

                    Appointment appointment =
                        appointmentService.createAppointment(
                            doctors.get(docChoice-1),
                            patient
                        );

                    System.out.println(appointment);

                    ConsoleNotifier notifier =
                        new ConsoleNotifier();

                    notifier.update(
                        "Appointment booked for " +
                        patient.getName()
                    );

                    break;

                case 4:
                    doctorService.getDoctors()
                        .forEach(System.out::println);
                    break;

                case 5:
                    patientService.getPatients()
                        .forEach(System.out::println);
                    break;

                case 6:

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    System.out.println("1. Normal");
                    System.out.println("2. Insurance");

                    int type = sc.nextInt();

                    BillingStrategy strategy =
                        BillFactory.getStrategy(type);

                    Bill bill = new Bill(amount,strategy);

                    System.out.println(
                        "Final Bill: " +
                        bill.generateBill()
                    );

                    break;

                case 7:

                    System.out.print("Doctor name: ");
                    String doctorSearch = sc.nextLine();

                    doctorService.searchDoctorByName(
                        doctorSearch
                    ).forEach(System.out::println);

                    break;

                case 8:

                    System.out.print("Patient name: ");
                    String patientSearch = sc.nextLine();

                    patientService.searchPatientByName(
                        patientSearch
                    ).forEach(System.out::println);

                    break;

                case 9:

                    appointmentService.getAppointments()
                        .forEach(System.out::println);

                    break;

                case 10:

                    System.out.print("Index: ");
                    int index = sc.nextInt();

                    boolean cancelled =
                        appointmentService.cancelAppointment(index);

                    System.out.println(
                        cancelled ?
                        "Cancelled" :
                        "Invalid"
                    );

                    break;

                case 11:

                    double avg =
                        DoctorAnalytics.averageFee(
                            doctorService.getDoctors()
                        );

                    System.out.println(
                        "Average Fee: " + avg
                    );

                    break;

                case 12:

                    System.out.print("Specialization: ");
                    String specialization = sc.nextLine();

                    DoctorAnalytics.filterBySpecialization(
                        doctorService.getDoctors(),
                        specialization
                    ).forEach(System.out::println);

                    break;

                case 13:

                    List<String> data = new ArrayList<>();

                    for(Doctor d :
                        doctorService.getDoctors()){

                        data.add(
                            d.getId() + "," +
                            d.getName() + "," +
                            d.getSpecialization()
                        );
                    }

                    CSVUtil.saveData("doctors.csv",data);

                    System.out.println("Saved!");

                    break;

                case 14:

                    List<String[]> rows =
                        CSVUtil.loadData("doctors.csv");

                    for(String[] row : rows){
                        System.out.println(
                            Arrays.toString(row)
                        );
                    }

                    break;

                case 15:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}