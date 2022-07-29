package com.saintclairehospital.controllers;

import com.saintclairehospital.models.PhysicianModel;
import com.saintclairehospital.services.PhysicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/physician")
public class PhysicianController {
    @Autowired
    PhysicianService physicianService;

    @GetMapping()
    public ArrayList<PhysicianModel> obtainPhysicians(){
        return physicianService.obtainPhysicians();
    }

    @PostMapping()
    public PhysicianModel savePhysician(@RequestBody PhysicianModel physician){
        return this.physicianService.savePhysician(physician);
    }

    @GetMapping(path = "/{id}")
    public Optional<PhysicianModel> obtainPhysicianById(@PathVariable("id") Integer id){
        return this.physicianService.obtainById(id);
    }


    @GetMapping("/query")
    public ArrayList<PhysicianModel> obtainPhysicianByName(@RequestParam("name") String name){
        return this.physicianService.obtainByName(name);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = this.physicianService.deletePhysician(id);
        if(ok){
            return "Se despidio al doctor con Id" + id;
        }else{
            return "No se pudo despedir al doctor con Id" + id;
        }
    }

}
