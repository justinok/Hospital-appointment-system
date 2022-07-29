package com.saintclairehospital.repositories;

import com.saintclairehospital.models.PatientModel;
import com.saintclairehospital.models.PhysicianModel;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PhysicianRepository extends CrudRepository<PhysicianModel, Integer> {
    public abstract ArrayList<PhysicianModel> findByName(String name);
}
