package com.saintclairehospital.controllers;

import com.saintclairehospital.models.MedicalSpecialityModel;
import com.saintclairehospital.services.MedicalSpecialityService;
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
@RequestMapping("/medical_speciality")
@CrossOrigin("*")
public class MedicalSpecialityController {
    @Autowired
    MedicalSpecialityService medicalspecialityService;

    @GetMapping()
    public ArrayList<MedicalSpecialityModel> obtainMedicalSpecialities(){
        return medicalspecialityService.obtainMedicalSpecialities();
    }

    @PostMapping()
    public MedicalSpecialityModel saveMedicalSpeciality(
            @RequestBody MedicalSpecialityModel medicalspeciality){
        return this.medicalspecialityService.saveMedicalSpeciality(
                medicalspeciality);
    }

    @GetMapping(path = "/{id}")
    public Optional<MedicalSpecialityModel>
    obtainMedicalSpecialityById(@PathVariable("id") Integer id){
        return this.medicalspecialityService.obtainById(id);
    }


    @GetMapping("/query")
    public ArrayList<MedicalSpecialityModel>
    obtainMedicalSpecialityByName(@RequestParam("name") String name){
        return this.medicalspecialityService.obtainByName(name);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = this.medicalspecialityService.deleteMedicalSpeciality(id);
        if(ok){
            return "Se elimino el medicalspeciality con Id" + id;
        }else{
            return "No se pudo eliminar el medicalspeciality con Id" + id;
        }
    }

}

