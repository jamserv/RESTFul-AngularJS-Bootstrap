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
public class Fondo_Pension implements Serializable {

    private int nu_fondo_pension;
    private String nb_fondo_pension;

    public Fondo_Pension() {
    }

    public Fondo_Pension(String nb_fondo_pension) {
        this.nb_fondo_pension = nb_fondo_pension;
    }

    /**
     * *
     *
     * @param nu_fondo_pension
     * @param nb_fondo_pension
     */
    public Fondo_Pension(int nu_fondo_pension, String nb_fondo_pension) {
        this.nu_fondo_pension = nu_fondo_pension;
        this.nb_fondo_pension = nb_fondo_pension;
    }

    public int getNu_fondo_pension() {
        return nu_fondo_pension;
    }

    public void setNu_fondo_pension(int nu_fondo_pension) {
        this.nu_fondo_pension = nu_fondo_pension;
    }

    public String getNb_fondo_pension() {
        return nb_fondo_pension;
    }

    public void setNb_fondo_pension(String nb_fondo_pension) {
        this.nb_fondo_pension = nb_fondo_pension;
    }

}
