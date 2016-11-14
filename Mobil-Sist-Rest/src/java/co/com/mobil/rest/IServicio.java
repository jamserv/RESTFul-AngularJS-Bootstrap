/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mobil.rest;

import co.com.mobil.entity.Servicio;
import co.com.mobil.error.handler.ServicioException;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.core.Response;

/**
 *
 * @author janez
 */
@Local
public interface IServicio {

    /**
     * 
     * @param servicio
     * @param asynCallBack
     * @return
     * @throws ServicioException 
     */
    public Response SolicitarServicio(Servicio servicio, AsynCallBack<Integer> asynCallBack) 
            throws ServicioException;

    /**
     * 
     * @param nu_servicio
     * @param asynCallBack
     * @return
     * @throws ServicioException 
     */
    public Servicio ObtenerServicioId(int nu_servicio, AsynCallBack<Integer> asynCallBack)
            throws ServicioException;
    
    /**
     * 
     * @param asynCallBack
     * @return
     * @throws ServicioException 
     */
    public List<Servicio> ListarServicios(AsynCallBack<Integer> asynCallBack) 
            throws  ServicioException;
}
