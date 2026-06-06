package com.airtribe.meditrack.entity;

public class Appointment implements Cloneable {

    private Doctor doctor;
    private Patient patient;
    private AppointmentStatus status;

    public Appointment(Doctor doctor,
                       Patient patient){

        this.doctor=doctor;
        this.patient=patient;
        this.status=AppointmentStatus.CONFIRMED;
    }

    public void setStatus(
            AppointmentStatus status){

        this.status=status;
    }

    public AppointmentStatus getStatus(){
        return status;
    }

    @Override
    public Appointment clone(){

        return new Appointment(
                doctor,
                patient.clone()
        );
    }

    @Override
    public String toString(){

        return "Appointment{" +
                "doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                ", status=" + status +
                '}';
    }
}