///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.com.sampler;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.JasperRunManager;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//
///**
// *
// * @author janez
// */
//@WebServlet(name = "caiman", urlPatterns = {"/caiman"})
//public class ReportOpenWith extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//
//            Map parameters = new HashMap();                        
//
////            int tamano = Integer.valueOf(request.getParameter("tam"));
//
//            String path = this.getServletContext().getRealPath("/WEB-INF/");
//
//            JasperDesign jasperDesign = JRXmlLoader.load(path + "/reportes/Invoice.jrxml");
//            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//
//            byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, parameters, new ReporteAfiliadosJDataSource(10, this.getServletContext()));
//            OutputStream outStream = response.getOutputStream();
//            response.setHeader("Content-Disposition", "inline, filename=" + "janez@oil.com" + ".pdf");
//            response.setContentType("application/pdf");
//            response.setContentLength(byteStream.length);
//            outStream.write(byteStream, 0, byteStream.length);
//        } catch (JRException ex) {
//            Logger.getLogger(ReportOpenWith.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException exception) {
//            Logger.getLogger(ReportOpenWith.class.getName()).log(Level.SEVERE, null, exception);
//        } catch (Exception exception) {
//            Logger.getLogger(ReportOpenWith.class.getName()).log(Level.SEVERE, null, exception);
//        }
//    }
//
//}
