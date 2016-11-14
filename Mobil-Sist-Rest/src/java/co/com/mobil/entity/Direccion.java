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
public class Direccion implements Serializable {

    private int nu_direccion;
    private String nb_direccion;

    /**
     *
     * @param nu_direccion
     * @param nb_direccion
     */
    public Direccion(int nu_direccion, String nb_direccion) {
        this.nu_direccion = nu_direccion;
        this.nb_direccion = nb_direccion;
    }

    public int getNu_direccion() {
        return nu_direccion;
    }

    public void setNu_direccion(int nu_direccion) {
        this.nu_direccion = nu_direccion;
    }

    public String getNb_direccion() {
        return nb_direccion;
    }

    public void setNb_direccion(String nb_direccion) {
        this.nb_direccion = nb_direccion;
    }

}
