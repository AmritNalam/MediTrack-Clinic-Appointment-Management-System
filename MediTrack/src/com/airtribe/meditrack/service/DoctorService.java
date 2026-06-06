package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {

    private List<Doctor> doctors =
            new ArrayList<>();

    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
    }

    public List<Doctor> getDoctors(){
        return doctors;
    }

    public Doctor searchDoctorById(int id){

        for(Doctor doctor : doctors){

            if(doctor.getId()==id){
                return doctor;
            }
        }

        return null;
    }

    public List<Doctor> searchDoctorByName(
            String name){

        List<Doctor> result =
                new ArrayList<>();

        for(Doctor doctor : doctors){

            if(doctor.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())){

                result.add(doctor);
            }
        }

        return result;
    }

    public boolean deleteDoctor(int id){

        Doctor doctor = searchDoctorById(id);

        if(doctor != null){

            doctors.remove(doctor);
            return true;
        }

        return false;
    }
}