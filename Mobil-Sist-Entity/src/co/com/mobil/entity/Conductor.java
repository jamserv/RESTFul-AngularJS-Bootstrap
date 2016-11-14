/*
 * Copyright (C) 2016 janez
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package co.com.mobil.entity;

import java.io.Serializable;

/**
 *
 * @author janez
 */
public class Conductor implements Serializable{
    private int cedula;
    private String nombre_completo;
    private String direccion;
    private String telefono;
    private String nu_licencia_conduccion;
    private String arl;
    private String eps;
    private String tipo_sangre;

    public Conductor() {
    }

    /**
     * 
     * @param cedula
     * @param nombre_completo
     * @param direccion
     * @param telefono
     * @param nu_licencia_conduccion
     * @param arl
     * @param eps
     * @param tipo_sangre 
     */
    public Conductor(int cedula, String nombre_completo, String direccion, String telefono, String nu_licencia_conduccion, String arl, String eps, String tipo_sangre) {
        this.cedula = cedula;
        this.nombre_completo = nombre_completo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nu_licencia_conduccion = nu_licencia_conduccion;
        this.arl = arl;
        this.eps = eps;
        this.tipo_sangre = tipo_sangre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNu_licencia_conduccion() {
        return nu_licencia_conduccion;
    }

    public void setNu_licencia_conduccion(String nu_licencia_conduccion) {
        this.nu_licencia_conduccion = nu_licencia_conduccion;
    }

    public String getArl() {
        return arl;
    }

    public void setArl(String arl) {
        this.arl = arl;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }
    
    
    
    
}
