/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mobil.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author janez
 */
public class ParametroReportRangoFech implements Serializable {

    private Date desde;
    private Date hasta;

    public ParametroReportRangoFech() {
    }

    public ParametroReportRangoFech(Date desde, Date hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

}
