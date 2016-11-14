package co.com.mobil.rest;

import co.com.mobil.beans.config.Inicializador;
import co.com.mobil.entity.Conductor;
import co.com.mobil.entity.Eps;
import co.com.mobil.entity.Fondo_Pension;
import co.com.mobil.entity.Riesgos_Profesionales;
import co.com.mobil.query.QueryConsultant;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author janez
 */
@Path(value = "/conductor")
public class RestConductor {

    @EJB
    private Inicializador inicializador;

    private static final Logger LOG = Logger.getLogger(RestConductor.class.getName());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(value = "/new")
    public Response agregar_conductor_http_post(Conductor conductor) {
        if (conductor != null) {
            LOG.log(Level.INFO, "eps : {0}", conductor.getEps().getNu_eps());
            LOG.log(Level.INFO, "fondo pensio : {0}", conductor.getFondo_Pension().getNu_fondo_pension());
            LOG.log(Level.INFO, "riesgo laboral : {0}", conductor.getRiesgos_Profesionales().getNu_riesgos_profesionales());
            return Response.ok(inicializador.JdbcTemplateDataSource().update(QueryConsultant._INSERT_NEW_CONDUCTOR, new Object[]{
                conductor.getNu_identificacion(), conductor.getStatus(), conductor.getTipo_identificacion(),
                conductor.getIdentificacion_expedida_en(), conductor.getPrimer_apellido(), conductor.getSegundo_apellido(),
                conductor.getPrimer_nombre(), conductor.getSegundo_nombre(), conductor.getDireccion(), conductor.getNu_telefono(),
                conductor.getFecha_contratacion(), conductor.getGrupo_sanguineo_rh(), conductor.getPasado_judicial(),
                conductor.getVenc_pasado_judicial(), conductor.getTxt_observacion(), conductor.getEps().getNu_eps(),
                conductor.getFondo_Pension().getNu_fondo_pension(), conductor.getRiesgos_Profesionales().getNu_riesgos_profesionales(),
                conductor.getLicencia_conduccion(), conductor.getExpedida_en(), conductor.getCategoria_licencia(),
                conductor.getVenc_lic_conduccion()
            }), MediaType.APPLICATION_JSON).build();
        } else {
            return Response.noContent().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/all")
    public List<Conductor> listar_conductores_http_get() {
        return inicializador.JdbcTemplateDataSource().query(QueryConsultant._GET_ALL_CONDUCTORES, (ResultSet resultSet, int i)
                -> new Conductor(resultSet.getInt("nu_conductor"), resultSet.getString("licencia_conduccion"),
                        resultSet.getString("expedida_en"), resultSet.getString("categoria_licencia"),
                        resultSet.getDate("venc_lic_conduccion"), resultSet.getString("nu_identificacion"),
                        resultSet.getString("status"), resultSet.getString("tipo_identificacion"),
                        resultSet.getString("identificacion_expedida_en"), resultSet.getString("primer_apellido"),
                        resultSet.getString("segundo_apellido"), resultSet.getString("primer_nombre"),
                        resultSet.getString("segundo_nombre"), resultSet.getString("direccion"),
                        resultSet.getString("nu_telefono"), resultSet.getDate("fecha_contratacion"),
                        resultSet.getString("grupo_sanguineo_rh"), resultSet.getString("pasado_judicial"),
                        resultSet.getDate("venc_pasado_judicial"), resultSet.getString("txt_observacion"),
                        new Eps(resultSet.getString("nb_eps")),
                        new Fondo_Pension(resultSet.getString("nb_fondo_pension")),
                        new Riesgos_Profesionales(resultSet.getString("nb_riesgos_profesionales"))));
    }
}
