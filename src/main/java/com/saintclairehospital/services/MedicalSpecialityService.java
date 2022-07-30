package com.saintclairehospital.services;
import com.saintclairehospital.models.MedicalSpecialityModel;
import com.saintclairehospital.repositories.MedicalSpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Clase usada para los servicios de CRUD necesarios, desde aqui podemos
 * borrar, guardad, eliminar. editar
 */
@Service
public class MedicalSpecialityService {
    @Autowired
    MedicalSpecialityRepository medicalspecialityRepository;
    public ArrayList<MedicalSpecialityModel> obtainMedicalSpecialities(){
        return (ArrayList<MedicalSpecialityModel>) medicalspecialityRepository.findAll();
    }


    public MedicalSpecialityModel saveMedicalSpeciality(MedicalSpecialityModel medicalspeciality){
        return medicalspecialityRepository.save(medicalspeciality);
    }

    public Optional<MedicalSpecialityModel> obtainById(Integer id){
        return medicalspecialityRepository.findById(id);
    }

    public ArrayList<MedicalSpecialityModel> obtainByName(String name){
        return medicalspecialityRepository.findByName(name);
    }

    public boolean deleteMedicalSpeciality(Integer id){
        try{
            medicalspecialityRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}