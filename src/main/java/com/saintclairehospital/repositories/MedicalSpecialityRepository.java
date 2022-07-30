package com.saintclairehospital.repositories;

import com.saintclairehospital.models.MedicalSpecialityModel;
import com.saintclairehospital.models.PhysicianModel;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MedicalSpecialityRepository extends CrudRepository<MedicalSpecialityModel, Integer> {
    public abstract ArrayList<MedicalSpecialityModel> findByName(String name);
}
