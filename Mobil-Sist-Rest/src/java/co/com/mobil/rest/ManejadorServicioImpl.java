/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mobil.rest;

import co.com.mobil.beans.config.Inicializador;
import co.com.mobil.entity.Servicio;
import co.com.mobil.error.handler.ServicioException;
import co.com.mobil.messages.ErrorMessage;
import co.com.mobil.query.QueryConsultant;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 *
 * @author janez
 */
@Stateless(name = "IServicio")
public class ManejadorServicioImpl implements IServicio {

    private List<Servicio> Servicios = new ArrayList<>();
    private static final CacheManager cacheManager = new CacheManager();
    private static final Logger LOG = Logger.getLogger(ManejadorServicioImpl.class.getName());

    @EJB
    private Inicializador conf;

    private Ehcache getCache() {
        return cacheManager.getEhcache("services_cached");
    }

    /**
     *
     * @param servicio
     * @param asynCallBack
     * @return
     * @throws ServicioException
     */
    @Override
    public Response SolicitarServicio(Servicio servicio, AsynCallBack<Integer> asynCallBack) throws ServicioException {
        if (servicio.getNu_servicio() == -1) {
            asynCallBack.failed(new ServicioException(ErrorMessage._ERROR_PROCESS_SERVICE));
        }
        if (servicio != null) {
            asynCallBack.completed(Response.ok(Servicios.add(servicio), MediaType.APPLICATION_JSON).build().getStatus());
            return Response.ok(servicio, MediaType.APPLICATION_JSON).build();
        }
        return null;
    }

    /**
     *
     * @param nu_servicio
     * @param asynCallBack
     * @return
     * @throws ServicioException
     */
    @Override
    public Servicio ObtenerServicioId(int nu_servicio, AsynCallBack<Integer> asynCallBack) throws ServicioException {
        Element element = getCache().get(nu_servicio);
        if (element == null) {
            LOG.info("NO EXISTE EN CACHE");
            Servicio servicio = Servicios.get(nu_servicio);
            if (servicio == null) {
                asynCallBack.failed(new ServicioException("Ocurrio un error al procesar la solicitud.!"));
                return null;
            } else {
                getCache().put(new Element(nu_servicio, servicio));
                asynCallBack.completed(Response.ok(Servicios.get(nu_servicio), MediaType.APPLICATION_JSON).build().getStatus());
                return Servicios.get(nu_servicio);
            }
        } else {
            LOG.info("EXISTE EN CACHE");
            asynCallBack.completed(Response.ok((Servicio) element.getValue(), MediaType.APPLICATION_JSON).build().getStatus());
            return (Servicio) element.getValue();
        }
    }

    /**
     *
     * @param asynCallBack
     * @return
     */
    @Override
    public List<Servicio> ListarServicios(AsynCallBack<Integer> asynCallBack) {
        List<Servicio> request = conf.JdbcTemplateDataSource().query(QueryConsultant._ALL_SERVICES,
                (ResultSet resultSet, int i)
                -> new Servicio(resultSet.getInt("nu_servicio"), resultSet.getInt("cedula_cliente"),
                        resultSet.getDate("fe_servicio"), resultSet.getString("dir_origen"),
                        resultSet.getString("dir_destino"), resultSet.getDate("hr_reporte"),
                        resultSet.getString("txt_observacion")));
        
        return null;

    }

}
