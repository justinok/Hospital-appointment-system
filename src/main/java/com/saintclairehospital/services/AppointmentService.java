package com.saintclairehospital.services;

import com.saintclairehospital.models.AppointmentModel;
import com.saintclairehospital.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Clase usada para los servicios de CRUD necesarios, desde aqui podemos
 * borrar, guardad, eliminar. editar
 */
@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    public ArrayList<AppointmentModel> obtainAppointments(){
        return (ArrayList<AppointmentModel>) appointmentRepository.findAll();
    }


    public AppointmentModel saveAppointment(AppointmentModel appointment){
        return appointmentRepository.save(appointment);
    }

    public Optional<AppointmentModel> obtainById(Integer id){
        return appointmentRepository.findById(id);
    }

    public ArrayList<AppointmentModel> obtainByDate(String date){
        return appointmentRepository.findByDate(date);
    }

    public boolean deleteAppointment(Integer id){
        try{
            appointmentRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
