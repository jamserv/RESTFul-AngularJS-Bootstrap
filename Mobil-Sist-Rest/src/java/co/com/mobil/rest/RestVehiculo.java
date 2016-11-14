/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mobil.rest;

import co.com.mobil.beans.config.Inicializador;
import co.com.mobil.entity.Vehiculo;
import co.com.mobil.query.QueryConsultant;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.sf.ehcache.Element;

/**
 *
 * @author janez
 */
@Path(value = "/mobil")
public class RestVehiculo {

    @EJB
    private Inicializador inicializador;
    private static final Logger LOG = Logger.getLogger(RestVehiculo.class.getName());

    /**
     * *
     *
     * @param content
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(value = "/new")
    public Response SolicitarServicio_http_get(Vehiculo content) {
        if (content != null) {
            return Response.ok(inicializador.JdbcTemplateDataSource().update(QueryConsultant._INSERT_NEW_VEHICULO, new Object[]{
                content.getNb_status(), content.getNu_placa(), content.getMatriculado_en(), content.getClase_vehiculo(),
                content.getTipo(), content.getFecha_vinculacion(), content.getMarca(), content.getModelo(), content.getNu_serial_chasis(),
                content.getColor(), content.getSerial_motor(), content.getTarjetaPropiedad(), content.getFecha_expedicion(),
                content.getNu_soat(), content.getCia_soat_seg(), content.getFecha_vencimiento_soat(), content.getNu_tarjeta_operacion(),
                content.getFecha_vencimiento_tarjeta_operacion(), content.getNu_tecnomecanica(), content.getFecha_vencimiento_tecnomecanica(),
                content.getPropietario(), content.getConductor()
            }), MediaType.APPLICATION_JSON).build();
        } else {
            return Response.noContent().build();
        }
    }

    /**
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/all")
    public List<Vehiculo> getAllVehiculos_http_get() {
        return inicializador.JdbcTemplateDataSource().query(QueryConsultant._GET_ALL_VEHICULOS,
                (ResultSet resultSet, int index)
                -> new Vehiculo(resultSet.getInt("nu_vehiculo"), resultSet.getString("nb_status"), resultSet.getString("nu_placa"),
                        resultSet.getString("matriculado_en"), resultSet.getString("clase_vehiculo"),
                        resultSet.getString("tipo"), resultSet.getDate("fecha_vinculacion"),
                        resultSet.getString("marca"), resultSet.getString("modelo"),
                        resultSet.getString("nu_serial_chasis"), resultSet.getString("color"),
                        resultSet.getString("serial_motor"), resultSet.getString("tarjeta_propiedad"),
                        resultSet.getDate("fecha_expedicion"), resultSet.getString("nu_soat"),
                        resultSet.getString("cia_soat_seg"), resultSet.getDate("fecha_vencimiento_soat"),
                        resultSet.getString("nu_tarjeta_operacion"), resultSet.getDate("fecha_vencimiento_tarjeta_operacion"),
                        resultSet.getString("nu_tecnomecanica"), resultSet.getDate("fecha_vencimiento_tecnomecanica"),
                        resultSet.getString("propietario"), resultSet.getString("conductor")));

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/id/{nu_vechiculo}")
    public Vehiculo getVehiculoId_http_get(@PathParam("nu_vechiculo") int nu_vehiculo) {
        Element element = inicializador.getCacheVehiculos().get(nu_vehiculo);
        if (element == null) {
            LOG.info("NO EXISTE EN CACHE");
            Vehiculo vehiculo = inicializador.JdbcTemplateDataSource().queryForObject(QueryConsultant._GET_VEHICULO_BY_N_PLACA,
                    (ResultSet resultSet, int i)
                    -> new Vehiculo(resultSet.getInt("nu_vehiculo"), resultSet.getString("nb_status"), resultSet.getString("nu_placa"),
                            resultSet.getString("matriculado_en"), resultSet.getString("clase_vehiculo"),
                            resultSet.getString("tipo"), resultSet.getDate("fecha_vinculacion"),
                            resultSet.getString("marca"), resultSet.getString("modelo"),
                            resultSet.getString("nu_serial_chasis"), resultSet.getString("color"),
                            resultSet.getString("serial_motor"), resultSet.getString("tarjeta_propiedad"),
                            resultSet.getDate("fecha_expedicion"), resultSet.getString("nu_soat"),
                            resultSet.getString("cia_soat_seg"), resultSet.getDate("fecha_vencimiento_soat"),
                            resultSet.getString("nu_tarjeta_operacion"), resultSet.getDate("fecha_vencimiento_tarjeta_operacion"),
                            resultSet.getString("nu_tecnomecanica"), resultSet.getDate("fecha_vencimiento_tecnomecanica"),
                            resultSet.getString("propietario"), resultSet.getString("conductor")), new Object[]{
                        nu_vehiculo
                    });
            if (vehiculo == null) {
                LOG.info("NO EXISTE EN BASE DE DATOS.!");
                return null;
            } else {
                inicializador.getCacheVehiculos().put(new Element(nu_vehiculo, vehiculo));
                return vehiculo;
            }
        } else {
            LOG.info("EXISTE EN CACHE");
            return (Vehiculo) element.getValue();
        }

    }
}
