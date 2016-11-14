package co.com.mobil.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author janez
 */
public class Personal implements Serializable {

    private String nu_identificacion;
    private String status;
    private String tipo_identificacion;
    private String identificacion_expedida_en;
    private String primer_apellido;
    private String segundo_apellido;
    private String primer_nombre;
    private String segundo_nombre;
    private String direccion;
    private String nu_telefono;
    private Date fecha_contratacion;
    private String grupo_sanguineo_rh;
    private String pasado_judicial;
    private Date venc_pasado_judicial;
    private String txt_observacion;
    private Eps eps;
    private Fondo_Pension fondo_Pension;
    private Riesgos_Profesionales riesgos_Profesionales;

    public Personal() {
    }

    /**
     *
     * @param nu_identificacion
     * @param status
     * @param tipo_identificacion
     * @param identificacion_expedida_en
     * @param primer_apellido
     * @param segundo_apellido
     * @param primer_nombre
     * @param segundo_nombre
     * @param direccion
     * @param nu_telefono
     * @param fecha_contratacion
     * @param grupo_sanguineo_rh
     * @param pasado_judicial
     * @param venc_pasado_judicial
     * @param txt_observacion
     * @param eps
     * @param fondo_Pension
     * @param riesgos_Profesionales
     */
    public Personal(String nu_identificacion, String status, String tipo_identificacion, String identificacion_expedida_en, String primer_apellido, String segundo_apellido, String primer_nombre, String segundo_nombre, String direccion, String nu_telefono, Date fecha_contratacion, String grupo_sanguineo_rh, String pasado_judicial, Date venc_pasado_judicial, String txt_observacion, Eps eps, Fondo_Pension fondo_Pension, Riesgos_Profesionales riesgos_Profesionales) {
        this.nu_identificacion = nu_identificacion;
        this.status = status;
        this.tipo_identificacion = tipo_identificacion;
        this.identificacion_expedida_en = identificacion_expedida_en;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.direccion = direccion;
        this.nu_telefono = nu_telefono;
        this.fecha_contratacion = fecha_contratacion;
        this.grupo_sanguineo_rh = grupo_sanguineo_rh;
        this.pasado_judicial = pasado_judicial;
        this.venc_pasado_judicial = venc_pasado_judicial;
        this.txt_observacion = txt_observacion;
        this.eps = eps;
        this.fondo_Pension = fondo_Pension;
        this.riesgos_Profesionales = riesgos_Profesionales;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getNu_identificacion() {
        return nu_identificacion;
    }

    public void setNu_identificacion(String nu_identificacion) {
        this.nu_identificacion = nu_identificacion;
    }

    public String getIdentificacion_expedida_en() {
        return identificacion_expedida_en;
    }

    public void setIdentificacion_expedida_en(String identificacion_expedida_en) {
        this.identificacion_expedida_en = identificacion_expedida_en;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNu_telefono() {
        return nu_telefono;
    }

    public void setNu_telefono(String nu_telefono) {
        this.nu_telefono = nu_telefono;
    }

    public String getGrupo_sanguineo_rh() {
        return grupo_sanguineo_rh;
    }

    public void setGrupo_sanguineo_rh(String grupo_sanguineo_rh) {
        this.grupo_sanguineo_rh = grupo_sanguineo_rh;
    }

    public String getPasado_judicial() {
        return pasado_judicial;
    }

    public void setPasado_judicial(String pasado_judicial) {
        this.pasado_judicial = pasado_judicial;
    }

    public Date getVenc_pasado_judicial() {
        return venc_pasado_judicial;
    }

    public void setVenc_pasado_judicial(Date venc_pasado_judicial) {
        this.venc_pasado_judicial = venc_pasado_judicial;
    }

    public String getTxt_observacion() {
        return txt_observacion;
    }

    public void setTxt_observacion(String txt_observacion) {
        this.txt_observacion = txt_observacion;
    }

    public Eps getEps() {
        return eps;
    }

    public void setEps(Eps eps) {
        this.eps = eps;
    }

    public Fondo_Pension getFondo_Pension() {
        return fondo_Pension;
    }

    public void setFondo_Pension(Fondo_Pension fondo_Pension) {
        this.fondo_Pension = fondo_Pension;
    }

    public Riesgos_Profesionales getRiesgos_Profesionales() {
        return riesgos_Profesionales;
    }

    public void setRiesgos_Profesionales(Riesgos_Profesionales riesgos_Profesionales) {
        this.riesgos_Profesionales = riesgos_Profesionales;
    }

}
