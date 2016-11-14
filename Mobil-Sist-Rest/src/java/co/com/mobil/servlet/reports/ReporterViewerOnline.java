/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mobil.servlet.reports;

import co.com.mobil.beans.config.Inicializador;
import co.com.mobil.entity.ParametroReportRangoFech;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;

/**
 *
 * @author janez
 */
@WebServlet(name = "Reporter", urlPatterns = {"/Reporter"})
public class ReporterViewerOnline extends HttpServlet {

    @EJB
    Inicializador conf;

    private byte[] jasperCompiled_AfiliadosReport;
    private File xmlFilePdfAfiliados;
    private static final Logger LOG = Logger.getLogger(ReporterViewerOnline.class.getName());
    private ParametroReportRangoFech parametroReportRangoFech;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        if (request.getParameter("tipo_reporte").equals("servicios")) {
            xmlFilePdfAfiliados = new File(servletContext.getRealPath("/WEB-INF/reportes/servicio/servicios.jrxml"));
            if (!xmlFilePdfAfiliados.exists()) {
                LOG.info("Imposible obtener los archivos del reporte : " + xmlFilePdfAfiliados.getAbsolutePath());
                return;
            }
            try {
                jasperCompiled_AfiliadosReport = cargar(xmlFilePdfAfiliados);
                if (jasperCompiled_AfiliadosReport == null) {
                    response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
                } else {
                    Date desde = new Date(request.getParameter("desde"));
                    Date hasta = new Date(request.getParameter("hasta"));
                    
                    LOG.log(Level.INFO, "fecha desde _: {0}", desde.toString());
                    LOG.log(Level.INFO, "fecha hasta _: {0}", hasta.toString());
                    
                    parametroReportRangoFech = new ParametroReportRangoFech(desde, hasta);
                    realizarReporteFichas(response, this.getServletContext());
                }
            } catch (Exception ex) {
                LOG.info("Ocurrio un error mientras se cargba el archivo .jrxml");
                jasperCompiled_AfiliadosReport = null;
            }
        }
    }

    /**
     *
     * @param xmlFile
     * @return
     * @throws JRException
     * @throws IOException
     */
    private byte[] cargar(File xmlFile) throws JRException, IOException {
        InputStream xmlStream = new FileInputStream(xmlFile);
        ByteArrayOutputStream jasperTmp = new ByteArrayOutputStream();
        JasperCompileManager.compileReportToStream(xmlStream, jasperTmp);
        xmlStream.close();
        jasperTmp.close();
        return jasperTmp.toByteArray();
    }

    /**
     *
     * @param res
     * @param ctx
     */
    private void realizarReporteFichas(HttpServletResponse res, ServletContext ctx) {
        try {
            OutputStream outputStreamCiclosInyectados = res.getOutputStream();;
            JasperPrint jasperPrintCicloInyectado = prepararReporte(ctx);

            res.setContentType("application/pdf");
            res.addHeader("Content-Disposition", "inline; filename=\"" + "afiliados_" + new Date() + ".pdf");

            JasperExportManager
                    .exportReportToPdfStream(jasperPrintCicloInyectado, outputStreamCiclosInyectados);

        } catch (JRException ex) {
            Logger.getLogger(ReporterViewerOnline.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReporterViewerOnline.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param ctx
     * @return
     * @throws Exception
     */
    private JasperPrint prepararReporte(ServletContext ctx)
            throws Exception {
        JasperPrint jasperPrint = null;
        try {
            InputStream jasperInputStream = null;
            jasperInputStream = new ByteArrayInputStream(jasperCompiled_AfiliadosReport);
            ReporteAfiliadosJDataSource reporteAfiliadosJDataSource = new ReporteAfiliadosJDataSource(conf, parametroReportRangoFech.getDesde(),
                    parametroReportRangoFech.getHasta());

            Image logo = new ImageIcon(ctx.getRealPath("/WEB-INF/img/logo.png")).getImage();

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("logo", logo);

            jasperPrint = JasperFillManager.fillReport(jasperInputStream, parameters, reporteAfiliadosJDataSource);
            jasperInputStream.close();
        } catch (JRException e1) {
            throw (e1);
        } catch (Exception e3) {
            throw (e3);
        }
        return jasperPrint;
    }

    private void desplegarReporteJasper(JasperPrint jp, OutputStream out) throws JRException {
        JExcelApiExporter xlsExporter = new JExcelApiExporter();
        xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
        xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
        xlsExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "latin1");
        xlsExporter.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
        xlsExporter.exportReport();
    }

}
