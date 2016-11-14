/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mobil.entity;

import java.io.Serializable;

/**
 *
 * @author janez
 */
public class Riesgos_Profesionales implements Serializable {

    private int nu_riesgos_profesionales;
    private String nb_riesgos_profesionales;

    public Riesgos_Profesionales() {
    }

    /**
     *
     * @param nb_riesgos_profesionales
     */
    public Riesgos_Profesionales(String nb_riesgos_profesionales) {
        this.nb_riesgos_profesionales = nb_riesgos_profesionales;
    }

    /**
     *
     * @param nu_riesgos_profesionales
     * @param nb_riesgos_profesionales
     */
    public Riesgos_Profesionales(int nu_riesgos_profesionales, String nb_riesgos_profesionales) {
        this.nu_riesgos_profesionales = nu_riesgos_profesionales;
        this.nb_riesgos_profesionales = nb_riesgos_profesionales;
    }

    public int getNu_riesgos_profesionales() {
        return nu_riesgos_profesionales;
    }

    public void setNu_riesgos_profesionales(int nu_riesgos_profesionales) {
        this.nu_riesgos_profesionales = nu_riesgos_profesionales;
    }

    public String getNb_riesgos_profesionales() {
        return nb_riesgos_profesionales;
    }

    public void setNb_riesgos_profesionales(String nb_riesgos_profesionales) {
        this.nb_riesgos_profesionales = nb_riesgos_profesionales;
    }

}
