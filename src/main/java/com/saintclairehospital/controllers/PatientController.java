package com.saintclairehospital.controllers;

import com.saintclairehospital.models.PatientModel;
import com.saintclairehospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
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
    public Optional<PatientModel> obtainPatientById(@PathVariable("id") Integer id){
        return this.patientService.obtainById(id);
    }

    /**
     * aaaaaa
     * @param priority
     * @return
     */
    @GetMapping("/query")
    public ArrayList<PatientModel> obtainPatientByName(@RequestParam("name") String name){
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
