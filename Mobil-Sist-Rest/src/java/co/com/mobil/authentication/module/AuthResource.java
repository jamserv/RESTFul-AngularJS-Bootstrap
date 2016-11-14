
package co.com.mobil.authentication.module;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author janez
 */
@Path(value = "/auth")
public class AuthResource {

    @EJB
    AuthService authService;
    private static final Logger LOG = Logger.getLogger(AuthResource.class.getName());        
    
    

    /**
     * 
     * 1223vw sebastian prra miercoles 05:00 a.m
     * 
     * 
     * @param request
     * @param authLoginElement
     * @return 
     */
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    @Path(value = "/login")
    @PermitAll    
    public AuthAccessElement login(@Context HttpServletRequest request, AuthLoginElement authLoginElement) {        
        AuthAccessElement accessElement = authService.login(authLoginElement);
        LOG.log(Level.INFO, "access username {0} success.!", authLoginElement.getUsername());       
        HttpSession httpSession = request.getSession(false);             
        if (accessElement != null) {                                    
            httpSession = request.getSession(true);
            httpSession.setAttribute("authId", accessElement.getAuthId());
            request.getSession().setAttribute(AuthAccessElement.PARAM_AUTH_ID, accessElement.getAuthId());
            request.getSession().setAttribute(AuthAccessElement.PARAM_AUTH_TOKEN, accessElement.getAuthToken());
        }
        return accessElement;
    }

}
