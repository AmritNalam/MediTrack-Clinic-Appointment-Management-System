package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientService {

    private List<Patient> patients =
            new ArrayList<>();

    public void addPatient(Patient patient){
        patients.add(patient);
    }

    public List<Patient> getPatients(){
        return patients;
    }

    public Patient searchPatient(int id){

        for(Patient patient : patients){

            if(patient.getId()==id){
                return patient;
            }
        }

        return null;
    }

    public List<Patient> searchPatientByName(
            String name){

        List<Patient> result =
                new ArrayList<>();

        for(Patient patient : patients){

            if(patient.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())){

                result.add(patient);
            }
        }

        return result;
    }

    public boolean deletePatient(int id){

        Patient patient = searchPatient(id);

        if(patient != null){

            patients.remove(patient);
            return true;
        }

        return false;
    }
}