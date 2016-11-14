package co.com.mobil.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author janez
 */
public class Empleado extends Personal implements Serializable {

    private int nu_empleado;

    public Empleado() {
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
    public Empleado(String nu_identificacion, String status, String tipo_identificacion, String identificacion_expedida_en, String primer_apellido, String segundo_apellido, String primer_nombre, String segundo_nombre, String direccion, String nu_telefono, Date fecha_contratacion, String grupo_sanguineo_rh, String pasado_judicial, Date venc_pasado_judicial, String txt_observacion, Eps eps, Fondo_Pension fondo_Pension, Riesgos_Profesionales riesgos_Profesionales) {
        super(nu_identificacion, status, tipo_identificacion, identificacion_expedida_en, primer_apellido, segundo_apellido, primer_nombre, segundo_nombre, direccion, nu_telefono, fecha_contratacion, grupo_sanguineo_rh, pasado_judicial, venc_pasado_judicial, txt_observacion, eps, fondo_Pension, riesgos_Profesionales);
    }

    /**
     *
     * @param nu_empleado
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
    public Empleado(int nu_empleado, String nu_identificacion, String status, String tipo_identificacion, String identificacion_expedida_en, String primer_apellido, String segundo_apellido, String primer_nombre, String segundo_nombre, String direccion, String nu_telefono, Date fecha_contratacion, String grupo_sanguineo_rh, String pasado_judicial, Date venc_pasado_judicial, String txt_observacion, Eps eps, Fondo_Pension fondo_Pension, Riesgos_Profesionales riesgos_Profesionales) {
        super(nu_identificacion, status, tipo_identificacion, identificacion_expedida_en, primer_apellido, segundo_apellido, primer_nombre, segundo_nombre, direccion, nu_telefono, fecha_contratacion, grupo_sanguineo_rh, pasado_judicial, venc_pasado_judicial, txt_observacion, eps, fondo_Pension, riesgos_Profesionales);
        this.nu_empleado = nu_empleado;
    }

    public int getNu_empleado() {
        return nu_empleado;
    }

    public void setNu_empleado(int nu_empleado) {
        this.nu_empleado = nu_empleado;
    }

}
