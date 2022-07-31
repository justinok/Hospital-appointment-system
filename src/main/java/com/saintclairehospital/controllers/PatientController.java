package com.saintclairehospital.controllers;

import com.saintclairehospital.models.PatientModel;
import com.saintclairehospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
/**
 * La clase controller es usada para mapear todas las funciones que usaremos
 * en nuestor CRUD como borrar, crear, modificar y buscar
 *
 * ********* Volver a poner las foreign keys luego de acabar los llamados desde
 * el front *****************************
 */
@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping()
    public ArrayList<PatientModel> obtainPatients(){
        return patientService.obtainPatients();
    }

    @PostMapping()
    public PatientModel savePatient(@RequestBody PatientModel patient){
        return this.patientService.savePatient(patient);
    }

    @GetMapping(path = "/{id}")
    public Optional<PatientModel>
    obtainPatientById(@PathVariable("id") Integer id){
        return this.patientService.obtainById(id);
    }


    @GetMapping("/query")
    public ArrayList<PatientModel>
    obtainPatientByName(@RequestParam("name") String name){
        return this.patientService.obtainByName(name);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = this.patientService.deletePatient(id);
        if(ok){
            return "Se elimino el paciente con Id" + id;
        }else{
            return "No se pudo eliminar el paciente con Id" + id;
        }
    }

}
