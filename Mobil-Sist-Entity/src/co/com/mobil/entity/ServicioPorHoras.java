/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mobil.entity;

import java.util.Date;

/**
 *
 * @author janez
 */
public class ServicioPorHoras extends Servicio {

    private Date horInicio;
    private Date horFin;
    private int tiempoMinutos;

    public ServicioPorHoras() {
    }

    /**
     *
     * @param horInicio
     * @param horFin
     * @param tiempoMinutos
     */
    public ServicioPorHoras(Date horInicio, Date horFin, int tiempoMinutos) {
        this.horInicio = horInicio;
        this.horFin = horFin;
        this.tiempoMinutos = tiempoMinutos;
    }
    
    

}
