/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.login;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 *
 * @author janez
 */
public class AuthSecurityInterceptor implements ContainerRequestFilter {

    private static final Response ACCESS_UNAUTHORIZED = 
            Response.status(Response.Status.UNAUTHORIZED).entity("Not authorized.").build();
    
    @EJB
    AuthService authService;
    @Context
    private ResourceInfo resourceInfo;
    @Context
    private HttpServletRequest request;
    private static final Logger LOG = Logger.getLogger(AuthSecurityInterceptor.class.getName());
    
    
    
    /**
     * 
     * @param requestContext
     * @throws IOException 
     */
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        
    LOG.info("inserceptaaaaaaaaa");
         // Get AuthId and AuthToken from HTTP-Header.
        String authId = requestContext.getHeaderString(AuthAccessElement.PARAM_AUTH_ID);
        String authToken = requestContext.getHeaderString(AuthAccessElement.PARAM_AUTH_TOKEN);
 
        // Get method invoked.
        Method methodInvoked = resourceInfo.getResourceMethod();
 
        if (methodInvoked.isAnnotationPresent(RolesAllowed.class)) {
            RolesAllowed rolesAllowedAnnotation = methodInvoked.getAnnotation(RolesAllowed.class);
            Set<String> rolesAllowed = new HashSet<>(Arrays.asList(rolesAllowedAnnotation.value()));
 
            if (!authService.isAuthorized(authId, authToken, rolesAllowed)) {
                requestContext.abortWith(ACCESS_UNAUTHORIZED);
            }
        }
    }

}
