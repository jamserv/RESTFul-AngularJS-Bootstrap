package co.com.mobil.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author janez
 */
public class Conductor extends Personal implements Serializable {

    private int nu_conductor;
    private String licencia_conduccion;
    private String expedida_en;
    private String categoria_licencia;
    private Date venc_lic_conduccion;

    /**
     * <strong>construc to insert</strong>
     *
     * @param licencia_conduccion
     * @param expedida_en
     * @param categoria_licencia
     * @param venc_lic_conduccion
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
    public Conductor(String licencia_conduccion, String expedida_en, String categoria_licencia, Date venc_lic_conduccion, String nu_identificacion, String status, String tipo_identificacion, String identificacion_expedida_en, String primer_apellido, String segundo_apellido, String primer_nombre, String segundo_nombre, String direccion, String nu_telefono, Date fecha_contratacion, String grupo_sanguineo_rh, String pasado_judicial, Date venc_pasado_judicial, String txt_observacion, Eps eps, Fondo_Pension fondo_Pension, Riesgos_Profesionales riesgos_Profesionales) {
        super(nu_identificacion, status, tipo_identificacion, identificacion_expedida_en, primer_apellido, segundo_apellido, primer_nombre, segundo_nombre, direccion, nu_telefono, fecha_contratacion, grupo_sanguineo_rh, pasado_judicial, venc_pasado_judicial, txt_observacion, eps, fondo_Pension, riesgos_Profesionales);
        this.licencia_conduccion = licencia_conduccion;
        this.expedida_en = expedida_en;
        this.categoria_licencia = categoria_licencia;
        this.venc_lic_conduccion = venc_lic_conduccion;
    }

    /**
     * <strong>construc to get</strong>
     *
     * @param nu_conductor
     * @param licencia_conduccion
     * @param expedida_en
     * @param categoria_licencia
     * @param venc_lic_conduccion
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
    public Conductor(int nu_conductor, String licencia_conduccion, String expedida_en, String categoria_licencia, Date venc_lic_conduccion, String nu_identificacion, String status, String tipo_identificacion, String identificacion_expedida_en, String primer_apellido, String segundo_apellido, String primer_nombre, String segundo_nombre, String direccion, String nu_telefono, Date fecha_contratacion, String grupo_sanguineo_rh, String pasado_judicial, Date venc_pasado_judicial, String txt_observacion, Eps eps, Fondo_Pension fondo_Pension, Riesgos_Profesionales riesgos_Profesionales) {
        super(nu_identificacion, status, tipo_identificacion, identificacion_expedida_en, primer_apellido, segundo_apellido, primer_nombre, segundo_nombre, direccion, nu_telefono, fecha_contratacion, grupo_sanguineo_rh, pasado_judicial, venc_pasado_judicial, txt_observacion, eps, fondo_Pension, riesgos_Profesionales);
        this.nu_conductor = nu_conductor;
        this.licencia_conduccion = licencia_conduccion;
        this.expedida_en = expedida_en;
        this.categoria_licencia = categoria_licencia;
        this.venc_lic_conduccion = venc_lic_conduccion;
    }

    public int getNu_conductor() {
        return nu_conductor;
    }

    public void setNu_conductor(int nu_conductor) {
        this.nu_conductor = nu_conductor;
    }

    public String getLicencia_conduccion() {
        return licencia_conduccion;
    }

    public void setLicencia_conduccion(String licencia_conduccion) {
        this.licencia_conduccion = licencia_conduccion;
    }

    public String getExpedida_en() {
        return expedida_en;
    }

    public void setExpedida_en(String expedida_en) {
        this.expedida_en = expedida_en;
    }

    public String getCategoria_licencia() {
        return categoria_licencia;
    }

    public void setCategoria_licencia(String categoria_licencia) {
        this.categoria_licencia = categoria_licencia;
    }

    public Date getVenc_lic_conduccion() {
        return venc_lic_conduccion;
    }

    public void setVenc_lic_conduccion(Date venc_lic_conduccion) {
        this.venc_lic_conduccion = venc_lic_conduccion;
    }

}
