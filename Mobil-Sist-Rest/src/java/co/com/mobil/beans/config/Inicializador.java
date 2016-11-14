package co.com.mobil.beans.config;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author janez
 */
@Startup
@Singleton
public class Inicializador {

    @Resource(lookup = "java:/PostgresDS")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private static CacheManager cacheManager;
    private static final Logger LOG = Logger.getLogger(Inicializador.class.getName());

    @PostConstruct
    public void inicializar() {
        try {
            if (cacheManager == null) {
                cacheManager = new CacheManager();
            } else {
                cacheManager = getCacheManager();
            }
            try {
                if (jdbcTemplate == null) {
                    jdbcTemplate = new JdbcTemplate(dataSource);
                } else {
                    jdbcTemplate = JdbcTemplateDataSource();
                }
            } catch (Exception exception) {
                LOG.log(Level.INFO, "OCURRIO UN ERROR DEBIDO A : {0}", exception.getLocalizedMessage());
            }
        } catch (Exception exception) {
            LOG.log(Level.INFO, "OCURRIO UN ERROR DEBIDO A : {0}", exception.getLocalizedMessage());
        }
    }

    public static CacheManager getCacheManager() {
        return cacheManager;
    }

    /**
     *
     * @return
     */
    public Ehcache getCacheServicios() {
        return cacheManager.getEhcache("services_cached");
    }

    /**
     *
     * @return
     */
    public Ehcache getCacheVehiculos() {
        return cacheManager.getEhcache("vehiculos_cached");
    }

    @Lock(LockType.READ)
    public JdbcTemplate JdbcTemplateDataSource() {
        return jdbcTemplate;
    }
}
