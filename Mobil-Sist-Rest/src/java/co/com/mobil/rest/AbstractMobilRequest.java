/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mobil.rest;

/**
 *
 * @author janez
 */
public abstract class AbstractMobilRequest {

    IServicio idServicio;

    public AbstractMobilRequest() {
    }

    public IServicio getIdServicio() {
        return idServicio;
    }

}
