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
public class ManejadorInstancias extends AbstractMobilRequest{

    public ManejadorInstancias() {
        idServicio = getInstanciaPedidos();
    }
    
    /**
     * 
     * @return 
     */
    private IServicio getInstanciaPedidos() {
        return (idServicio == null ? new ManejadorServicioImpl() : null); 
    }
    
}
