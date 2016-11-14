package co.com.mobil.rest;

import co.com.mobil.beans.config.Inicializador;
import co.com.mobil.entity.Servicio;
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
@Path(value = "/service")
public class RestServicio {

    @EJB
    private Inicializador conf;

//    @Context
//    private UriInfo context;
//    @Resource
//    SessionContext sessionContext;
    private static final Logger LOG = Logger.getLogger(RestServicio.class.getName());

//    @AroundInvoke
//    public Object verfUsuarioAutenticado(InvocationContext invocationContext) throws Exception {
//        String nombreUsuario = getNombreUsuario();
//        if (nombreUsuario.equalsIgnoreCase("ANONYMOUS")) {            
//            throw new EJBAccessException("Se requiere autenticacion para el usuario: " + nombreUsuario);            
//        } else {
//            LOG.log(Level.INFO, "{0}: invocation proceed", nombreUsuario);
//            return invocationContext.proceed();
//        }
//    }
//    private String getNombreUsuario() {
//        String name = sessionContext.getCallerPrincipal().getName();
//        return name;
//    }
    /**
     * *
     *
     * @param servicio
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(value = "/new")
    public Response SolicitarServicio_http_get(Servicio servicio) {
        if (servicio != null) {
            return Response.ok(conf.JdbcTemplateDataSource().update(QueryConsultant._INSERT_NEW_SERVICE, new Object[]{
                servicio.getFe_servicio(),
                servicio.getCedula_cliente(),
                servicio.getDir_origen(),
                servicio.getDir_destino(),
                servicio.getHr_reporte(),
                servicio.getTxt_observacion()
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
    public List<Servicio> ListarServicios_http_get() {
        return conf.JdbcTemplateDataSource().query(QueryConsultant._ALL_SERVICES,
                (ResultSet resultSet, int i)
                -> new Servicio(resultSet.getInt("nu_servicio"), resultSet.getInt("cedula_cliente"),
                        resultSet.getDate("fe_servicio"), resultSet.getString("dir_origen"),
                        resultSet.getString("dir_destino"), resultSet.getDate("hr_reporte"),
                        resultSet.getString("txt_observacion")));

    }

    /**
     *
     * @param nu_servicio
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/id/{nu_servicio}")
    public Servicio getServiceId_http_get(@PathParam("nu_servicio") int nu_servicio) {
        Element element = conf.getCacheServicios().get(nu_servicio);
        if (element == null) {
            LOG.info("NO EXISTE EN CACHE");
            Servicio servicio = conf.JdbcTemplateDataSource().queryForObject(QueryConsultant._GET_SERVICE_AS_ID,
                    (ResultSet resultSet, int i)
                    -> new Servicio(resultSet.getInt("nu_servicio"), resultSet.getInt("cedula_cliente"),
                            resultSet.getDate("fe_servicio"), resultSet.getString("dir_origen"),
                            resultSet.getString("dir_destino"), resultSet.getDate("hr_reporte"),
                            resultSet.getString("txt_observacion")), new Object[]{
                        nu_servicio
                    });
            if (servicio == null) {
                LOG.info("NO EXISTE EN BASE DE DATOS.!");
                return null;
            } else {
                conf.getCacheServicios().put(new Element(nu_servicio, servicio));
                return servicio;
            }
        } else {
            LOG.info("EXISTE EN CACHE");
            return (Servicio) element.getValue();
        }

    }

}
