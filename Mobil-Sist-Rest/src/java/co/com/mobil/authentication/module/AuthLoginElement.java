package co.com.mobil.authentication.module;

import java.io.Serializable;

/**
 *
 * @author janez
 */
public class AuthLoginElement implements Serializable {

    private String username;
    private String password;
    private String rol;

    public AuthLoginElement() {
    }

    /**
     * 
     * @param username
     * @param rol 
     */
    public AuthLoginElement(String username, String rol) {
        this.username = username;        
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
