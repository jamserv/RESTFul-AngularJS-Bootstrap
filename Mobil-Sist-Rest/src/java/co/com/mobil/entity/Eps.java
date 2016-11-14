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
public class Eps implements Serializable{
    private int nu_eps;
    private String nb_eps;

    public Eps() {
    }

    public Eps(String nb_eps) {
        this.nb_eps = nb_eps;
    }        

    public Eps(int nu_eps, String nb_eps) {
        this.nu_eps = nu_eps;
        this.nb_eps = nb_eps;
    }

    public int getNu_eps() {
        return nu_eps;
    }

    public void setNu_eps(int nu_eps) {
        this.nu_eps = nu_eps;
    }

    public String getNb_eps() {
        return nb_eps;
    }

    public void setNb_eps(String nb_eps) {
        this.nb_eps = nb_eps;
    }
    
    
    
}
