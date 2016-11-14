package co.com.mobil.authentication.module;

import co.com.mobil.beans.config.Inicializador;
import co.com.mobil.query.QueryConsultant;
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
        AuthAccessElement user = inicializador.JdbcTemplateDataSource().queryForObject("", new RowMapper<AuthAccessElement>() {

            @Override
            public AuthAccessElement mapRow(ResultSet resultSet, int i) throws SQLException {
//                return new AuthAccessElement(resultSet.getString("username"), resultSet.getString("rol"));
                return null;
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
        try {
            AuthLoginElement loginElement = inicializador.JdbcTemplateDataSource().queryForObject(QueryConsultant._LOGIN_ACCESS_REQUEST,
                    (ResultSet resultSet, int i)
                    -> new AuthLoginElement(resultSet.getString("username"),
                            resultSet.getString("rol")), new Object[]{
                        authLoginElement.getUsername(), authLoginElement.getPassword()
                    });
            if (loginElement != null) {
                String uuId = UUID.randomUUID().toString();
//                Date now = new Date();
//                String updateToken = "UPDATE \"mobil-sis-db-schema\".users SET last_seen = '?' WHERE username = ? AND password = ?";
//                inicializador.JdbcTemplateDataSource().update(updateToken, new Object[]{
//                    now, loginElement.getUsername(), loginElement.getPassword()
//                });
                /**
                 * Sprint : actualizar ultima fecha de ingreso del usuario
                 */
                return new AuthAccessElement(loginElement.getUsername(), uuId, loginElement.getRol());
            }
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            /**
             * Sprint : bloquear a usuario con 3 intentos de acceso.!
             */
            LOG.log(Level.INFO, "usuario incorrecto : {0}", emptyResultDataAccessException.getMessage());
            return null;
        }
        return null;
    }

}
