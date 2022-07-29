package com.saintclairehospital.services;

import com.saintclairehospital.models.PatientModel;
import com.saintclairehospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Clase usada para los servicios de CRUD necesarios, desde aqui podemos
 * borrar, guardad, eliminar. editar
 */
@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public ArrayList<PatientModel> obtainPatients(){
       return (ArrayList<PatientModel>) patientRepository.findAll();
    }


    public PatientModel savePatient(PatientModel patient){
        return patientRepository.save(patient);
    }

    public Optional<PatientModel> obtainById(Integer id){
        return patientRepository.findById(id);
    }

    public ArrayList<PatientModel> obtainByName(String name){
        return patientRepository.findByName(name);
    }

    public boolean deletePatient(Integer id){
        try{
            patientRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
