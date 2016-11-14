/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.login;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author janez
 */
@Startup
@Singleton
public class Inicializador {

    @Resource(lookup = "java:/PostgresDS")
    private DataSource ds;
    private JdbcTemplate jdbcTemplate;
    private static final Logger LOG = Logger.getLogger(Inicializador.class.getName());
    
    public JdbcTemplate JdbcTemplateGeneral() {
        return jdbcTemplate;
    }

    @PostConstruct
    public void inicializar() {
        try {
            jdbcTemplate = new JdbcTemplate(ds);
            LOG.log(Level.INFO, "Iniciado DS Correcto : {0}", jdbcTemplate.getDataSource());
        } catch (Exception e) {
            LOG.info("Error al inicializar sqlscript: " + e);
        }
    }

}
