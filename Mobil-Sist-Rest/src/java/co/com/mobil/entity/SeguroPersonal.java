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
public class SeguroPersonal implements Serializable {

    private int nu_seguro;
    private String eps;
    private String fondo_pension;
    private String riesgo_profesionales;

    /**
     *
     * @param eps
     * @param fondo_pension
     * @param riesgo_profesionales
     */
    public SeguroPersonal(String eps, String fondo_pension, String riesgo_profesionales) {
        this.eps = eps;
        this.fondo_pension = fondo_pension;
        this.riesgo_profesionales = riesgo_profesionales;
    }

    public SeguroPersonal() {
    }

    /**
     *
     * @param nu_seguro
     * @param eps
     * @param fondo_pension
     * @param riesgo_profesionales
     */
    public SeguroPersonal(int nu_seguro, String eps, String fondo_pension, String riesgo_profesionales) {
        this.nu_seguro = nu_seguro;
        this.eps = eps;
        this.fondo_pension = fondo_pension;
        this.riesgo_profesionales = riesgo_profesionales;
    }

    public int getNu_seguro() {
        return nu_seguro;
    }

    public void setNu_seguro(int nu_seguro) {
        this.nu_seguro = nu_seguro;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getFondo_pension() {
        return fondo_pension;
    }

    public void setFondo_pension(String fondo_pension) {
        this.fondo_pension = fondo_pension;
    }

    public String getRiesgo_profesionales() {
        return riesgo_profesionales;
    }

    public void setRiesgo_profesionales(String riesgo_profesionales) {
        this.riesgo_profesionales = riesgo_profesionales;
    }

}
