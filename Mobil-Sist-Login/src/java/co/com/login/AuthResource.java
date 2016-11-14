/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.login;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
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
        LOG.log(Level.INFO, "username : {0}", authLoginElement.getUsername());
        LOG.log(Level.INFO, "password : {0}", authLoginElement.getPassword());
        if (accessElement != null) {
            request.getSession().setAttribute(AuthAccessElement.PARAM_AUTH_ID, accessElement.getAuthId());
            request.getSession().setAttribute(AuthAccessElement.PARAM_AUTH_TOKEN, accessElement.getAuthToken());
        }
        return accessElement;
    }

}
