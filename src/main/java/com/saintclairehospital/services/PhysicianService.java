package com.saintclairehospital.services;

import com.saintclairehospital.models.PhysicianModel;
import com.saintclairehospital.repositories.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Clase usada para los servicios de CRUD necesarios, desde aqui podemos
 * borrar, guardad, eliminar. editar
 */
@Service
public class PhysicianService {
    @Autowired
    PhysicianRepository physicianRepository;
    public ArrayList<PhysicianModel> obtainPhysicians(){
        return (ArrayList<PhysicianModel>) physicianRepository.findAll();
    }


    public PhysicianModel savePhysician(PhysicianModel physician){
        return physicianRepository.save(physician);
    }

    public Optional<PhysicianModel> obtainById(Integer id){
        return physicianRepository.findById(id);
    }

    public ArrayList<PhysicianModel> obtainByName(String name){
        return physicianRepository.findByName(name);
    }

    public boolean deletePhysician(Integer id){
        try{
            physicianRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
