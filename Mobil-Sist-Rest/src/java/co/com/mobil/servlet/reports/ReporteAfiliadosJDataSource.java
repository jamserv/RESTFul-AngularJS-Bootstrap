package co.com.mobil.servlet.reports;

import co.com.mobil.beans.config.Inicializador;
import co.com.mobil.entity.Servicio;
import co.com.mobil.query.QueryConsultant;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author janez
 */
public class ReporteAfiliadosJDataSource implements JRDataSource {

    private static final Logger LOG = Logger.getLogger(ReporteAfiliadosJDataSource.class.getName());
    private List<Servicio> listServicios;
    private int INDEX_CURRENT_CICLE = -1;

    /**
     *
     * @param initDataSource
     * @param desde
     * @param hasta
     */
    public ReporteAfiliadosJDataSource(Inicializador initDataSource, Date desde, Date hasta) {
        listServicios = initDataSource.JdbcTemplateDataSource().query(QueryConsultant._GET_SERVICE_BY_DATE_RANGUE,
                (ResultSet resultSet, int i)
                -> new Servicio(resultSet.getInt("nu_servicio"), resultSet.getInt("cedula_cliente"),
                        resultSet.getDate("fe_servicio"), resultSet.getString("dir_origen"),
                        resultSet.getString("dir_destino"), resultSet.getDate("hr_reporte"),
                        resultSet.getString("txt_observacion")), new Object[]{
                    desde, hasta
                });
        LOG.log(Level.INFO, "CANT : {0}", listServicios.size());
    }

    @Override
    public boolean next() throws JRException {
        return ++INDEX_CURRENT_CICLE < listServicios.size();
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        if (null != field.getName()) {
            switch (field.getName()) {
                case "nu_servicio":
                    return listServicios.get(INDEX_CURRENT_CICLE).getNu_servicio();
                case "cedula_cliente":
                    return listServicios.get(INDEX_CURRENT_CICLE).getCedula_cliente();
                case "fe_servicio":
                    return listServicios.get(INDEX_CURRENT_CICLE).getFe_servicio();
                case "dir_origen":
                    return listServicios.get(INDEX_CURRENT_CICLE).getDir_origen();
                case "dir_destino":
                    return listServicios.get(INDEX_CURRENT_CICLE).getDir_destino();
                case "hr_reporte":
                    return listServicios.get(INDEX_CURRENT_CICLE).getHr_reporte();
                case "txt_observacion":
                    return listServicios.get(INDEX_CURRENT_CICLE).getTxt_observacion();
                default:
                    return null;
            }
        }
        return null;
    }

    public int getNumeroPaginas() {
        return listServicios.size();
    }

}
