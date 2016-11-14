/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mobil.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author janez
 */
public class Servicio implements Serializable {

    private int nu_servicio;
    private int cedula_cliente;
    private Date fe_servicio;
    private String dir_origen;
    private String dir_destino;
    private Date hr_reporte;
    private String txt_observacion;

    public Servicio() {
    }

    public Servicio(int nu_servicio, int cedula_cliente, Date fe_servicio, String dir_origen, String dir_destino, Date hr_reporte, String txt_observacion) {
        this.nu_servicio = nu_servicio;
        this.cedula_cliente = cedula_cliente;
        this.fe_servicio = fe_servicio;
        this.dir_origen = dir_origen;
        this.dir_destino = dir_destino;
        this.hr_reporte = hr_reporte;
        this.txt_observacion = txt_observacion;
    }

    public int getNu_servicio() {
        return nu_servicio;
    }

    public void setNu_servicio(int nu_servicio) {
        this.nu_servicio = nu_servicio;
    }

    public Date getFe_servicio() {
        return fe_servicio;
    }

    public void setFe_servicio(Date fe_servicio) {
        this.fe_servicio = fe_servicio;
    }

    public int getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(int cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getDir_origen() {
        return dir_origen;
    }

    public void setDir_origen(String dir_origen) {
        this.dir_origen = dir_origen;
    }

    public String getDir_destino() {
        return dir_destino;
    }

    public void setDir_destino(String dir_destino) {
        this.dir_destino = dir_destino;
    }

    public String getTxt_observacion() {
        return txt_observacion;
    }

    public void setTxt_observacion(String txt_observacion) {
        this.txt_observacion = txt_observacion;
    }

    public Date getHr_reporte() {
        return hr_reporte;
    }

    public void setHr_reporte(Date hr_reporte) {
        this.hr_reporte = hr_reporte;
    }

}
