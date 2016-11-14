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
public class Cliente implements Serializable{
    private int nu_cedula;
    private String nb_cliente;    
    private int nu_direccion;

    /**
     * 
     * @param nu_cedula
     * @param nb_cliente
     * @param nu_direccion 
     */
    public Cliente(int nu_cedula, String nb_cliente, int nu_direccion) {
        this.nu_cedula = nu_cedula;
        this.nb_cliente = nb_cliente;
        this.nu_direccion = nu_direccion;
    }

    public int getNu_cedula() {
        return nu_cedula;
    }

    public void setNu_cedula(int nu_cedula) {
        this.nu_cedula = nu_cedula;
    }

    public String getNb_cliente() {
        return nb_cliente;
    }

    public void setNb_cliente(String nb_cliente) {
        this.nb_cliente = nb_cliente;
    }

    public int getNu_direccion() {
        return nu_direccion;
    }

    public void setNu_direccion(int nu_direccion) {
        this.nu_direccion = nu_direccion;
    }
    
    
    
    
}
