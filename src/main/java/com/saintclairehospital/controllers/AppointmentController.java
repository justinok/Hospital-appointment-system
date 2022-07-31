package com.saintclairehospital.controllers;

import com.saintclairehospital.models.AppointmentModel;
import com.saintclairehospital.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


/**
 * La clase controlles es usada para mapear todas las funciones que usaremos
 * en nuestor CRUD como borrar, crear, modificar y buscar
 *
 * ********* Volver a poner las foreign keys luego de acabar los llamados desde
 * el front *****************************
 */
@RestController
@RequestMapping("/appointment")
@CrossOrigin("*")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping()
    public ArrayList<AppointmentModel> obtainAppointments(){
        return appointmentService.obtainAppointments();
    }

    @PostMapping()
    public AppointmentModel saveAppointment(
            @RequestBody AppointmentModel appointment){
        return this.appointmentService.saveAppointment(appointment);
    }

    @GetMapping(path = "/{id}")
    public Optional<AppointmentModel> obtainAppointmentById(
            @PathVariable("id") Integer id){
        return this.appointmentService.obtainById(id);
    }


    @GetMapping("/query")
    public ArrayList<AppointmentModel> obtainAppointmentByDate(
            @RequestParam("date") String date){
        return this.appointmentService.obtainByDate(date);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = this.appointmentService.deleteAppointment(id);
        if(ok){
            return "Se elimino el appointment con Id" + id;
        }else{
            return "No se pudo eliminar el appointment con Id" + id;
        }
    }

}
