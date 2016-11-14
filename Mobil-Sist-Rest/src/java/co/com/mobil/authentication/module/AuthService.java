/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mobil.authentication.module;

import java.util.Set;

/**
 *
 * @author janez
 */
public interface AuthService {
    
    /**
     * 
     * @param authLoginElement
     * @return 
     */
    public AuthAccessElement login(AuthLoginElement authLoginElement);
    
    /**
     * 
     * @param authId
     * @param authToken
     * @param rolesAllowed
     * @return 
     */
    public boolean isAuthorized(String authId, String authToken, Set<String> rolesAllowed);
}
