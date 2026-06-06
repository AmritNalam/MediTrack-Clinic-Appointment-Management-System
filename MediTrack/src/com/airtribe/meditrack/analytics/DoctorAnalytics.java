package com.airtribe.meditrack.analytics;

import com.airtribe.meditrack.entity.Doctor;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorAnalytics {

    public static double averageFee(
            List<Doctor> doctors
    ){

        return doctors.stream()
                .mapToDouble(Doctor::getFee)
                .average()
                .orElse(0);
    }

    public static List<Doctor>
    filterBySpecialization(
            List<Doctor> doctors,
            String specialization
    ){

        return doctors.stream()
                .filter(d ->
                        d.getSpecialization()
                                .equalsIgnoreCase(
                                        specialization
                                ))
                .collect(Collectors.toList());
    }
}