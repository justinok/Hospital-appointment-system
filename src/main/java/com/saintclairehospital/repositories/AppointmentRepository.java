package com.saintclairehospital.repositories;

import com.saintclairehospital.models.AppointmentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentModel, Integer> {
    public abstract ArrayList<AppointmentModel> findByDate(String date);
}
