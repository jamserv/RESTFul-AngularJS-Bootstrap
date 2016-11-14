/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author janez
 */
@Stateless(name = "AuthService")
public class AuthServiceBean implements AuthService {

    private static final Logger LOG = Logger.getLogger(AuthServiceBean.class.getName());

    @EJB
    Inicializador inicializador;

    /**
     * 
     * @param authId
     * @param authToken
     * @param rolesAllowed
     * @return 
     */
    @Override
    public boolean isAuthorized(String authId, String authToken, Set<String> rolesAllowed) {
        String query = "SELECT username, rol FROM \"mobil-sis-db-schema\".users WHERE username = ? AND authtoken = ?";
        AuthAccessElement user = inicializador.JdbcTemplateGeneral().queryForObject("", new RowMapper<AuthAccessElement>() {

            @Override
            public AuthAccessElement mapRow(ResultSet resultSet, int i) throws SQLException {
                return new AuthAccessElement(resultSet.getString("username"), resultSet.getString("rol"));
            }
        }, new Object[]{
            authId, authToken
        });
        if (user != null) {
            LOG.log(Level.INFO, "isAuthorized authId : {0} authToken : {1}", new Object[]{user.getAuthId(), user.getAuthToken()});
            return rolesAllowed.contains(user.getAuthPermission());
        } else {
            return false;
        }
    }

    /**
     *
     * @param authLoginElement
     * @return
     */
    @Override
    public AuthAccessElement login(AuthLoginElement authLoginElement) {
        String query = "SELECT username, password "
                + "FROM \"mobil-sis-db-schema\".users "
                + "WHERE username = ? AND password = ?";
        AuthLoginElement loginElement = null;
        try {
            loginElement = inicializador.JdbcTemplateGeneral().queryForObject(query, (ResultSet resultSet, int i)
                    -> new AuthLoginElement(resultSet.getString("username"),
                            resultSet.getString("password")), new Object[]{
                        authLoginElement.getUsername(), authLoginElement.getPassword()
                    });
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            LOG.info("usuario incorrecto.!");
            return null;
        }

        if (loginElement != null) {
            String uuId = UUID.randomUUID().toString();
//            String updateToken = "UPDATE \"mobil-sis-db-schema\".users SET authtoken = ? WHERE username = ? AND password = ?";
//            inicializador.JdbcTemplateGeneral().update(updateToken, new Object[]{
//                uuId, loginElement.getUsername(), loginElement.getPassword()
//            });
            return new AuthAccessElement(loginElement.getUsername(), uuId, "ADMIN");
        }

        return null;
    }

}
