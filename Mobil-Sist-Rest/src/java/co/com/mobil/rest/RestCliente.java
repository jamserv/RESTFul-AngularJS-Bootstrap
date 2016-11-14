/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mobil.rest;

import co.com.mobil.beans.config.Inicializador;
import co.com.mobil.entity.Cliente;
import co.com.mobil.query.QueryConsultant;
import java.sql.ResultSet;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author janez
 */
@Path(value = "/client")
public class RestCliente {

    @EJB
    private Inicializador inicializador;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/all")
    public List<Cliente> getAllClients_http_get() {
        return inicializador.JdbcTemplateDataSource().query(QueryConsultant._GET_ALL_CLIENTS,
                (ResultSet resultSet, int i) -> new Cliente(resultSet.getInt("nu_cedula"),
                        resultSet.getString("nb_cliente"), resultSet.getInt("nu_direccion")));
    }
}
