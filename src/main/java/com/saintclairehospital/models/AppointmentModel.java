package com.saintclairehospital.models;

import javax.persistence.*;

/**
 *  Esta clase sirve como el mapeador del paciente, desde aqui mapeamos la
 *  tabla de SQL de paciente y le ayudamos a spring boot a entender cada
 *  columna
 *
 *
 * @author Justin Alejandro Diaz Jimenez -- jusadiazjim@unal.edu.co
 *
 * @since 1.00.00
 *
 * @version 1
 *
 */

@Entity
@Table(name = "appointment")
public class AppointmentModel {
    /**
     * Mapeamos el Id, le explicamos a spring Boot que es es la identidad y
     * que son columnas
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String date;
    private String reason; //cuadrar esto

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
