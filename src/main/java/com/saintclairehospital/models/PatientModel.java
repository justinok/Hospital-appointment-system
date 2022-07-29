package com.saintclairehospital.models;

import javax.persistence.*;

/**
 *  Esta clase sirve como el controlador de todo el proyecto, desde aqui
 *  mapeamos los servicios que hemos creado en el proecto para poder darles
 *  una ruta
 *  ex :
 *  Funcion borrar
 *  @delete maping en:
 *  localhost:8080/delete
 *
 * @author Justin Alejandro Diaz Jimenez -- jusadiazjim@unal.edu.co
 *
 * @since 1.00.00
 *
 * @version 1
 *
 */

@Entity
@Table(name = "patient")
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String name;
    private String numb_of_appoints; //cuadrar esto

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumb_of_appoints() {
        return numb_of_appoints;
    }

    public void setNumb_of_appoints(String numb_of_appoints) {
        this.numb_of_appoints = numb_of_appoints;
    }
}
