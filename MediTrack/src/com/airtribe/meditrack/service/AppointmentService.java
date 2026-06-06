package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.AppointmentStatus;
import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private List<Appointment> appointments =
            new ArrayList<>();

    public Appointment createAppointment(
            Doctor doctor,
            Patient patient){

        Appointment appointment =
                new Appointment(doctor,patient);

        appointments.add(appointment);

        return appointment;
    }

    public List<Appointment> getAppointments(){
        return appointments;
    }

    public boolean cancelAppointment(int index){

        if(index >= 0 &&
                index < appointments.size()){

            appointments.get(index)
                    .setStatus(
                            AppointmentStatus.CANCELLED
                    );

            return true;
        }

        return false;
    }
}