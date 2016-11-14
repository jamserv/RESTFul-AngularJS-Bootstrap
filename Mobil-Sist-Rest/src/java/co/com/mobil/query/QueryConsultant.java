/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mobil.query;

/**
 *
 * @author janez
 */
public class QueryConsultant {

    /**
     * ********************** SERVICIOS **********************
     */
    /**
     * CONSULTA TODOS LOS SERVICIOS
     */
    public static final String _ALL_SERVICES = "SELECT nu_servicio, fe_servicio, cedula_cliente, dir_origen, dir_destino, txt_observacion, hr_reporte FROM \"mobil_sis_db_schema\".\"servicio\"";

    /**
     * GENERA UN NUEVO SERVICIO
     */
    public static final String _INSERT_NEW_SERVICE = "INSERT INTO \"mobil_sis_db_schema\".\"servicio\"(fe_servicio, cedula_cliente, dir_origen, dir_destino, hr_reporte, txt_observacion) VALUES (?, ?, ?, ?, ?, ?)";

    /**
     * ONTIENE UN SERVICIO INDICADO EL ID
     */
    public static final String _GET_SERVICE_AS_ID = "SELECT nu_servicio, fe_servicio, cedula_cliente, dir_origen, dir_destino,  hr_reporte, txt_observacion FROM \"mobil_sis_db_schema\".\"servicio\" WHERE nu_servicio = ?";

    /**
     * OBTIENE SERVICIO POR RANGO DE FECHAS - REPORTES
     */
    public static final String _GET_SERVICE_BY_DATE_RANGUE = "SELECT nu_servicio, fe_servicio, cedula_cliente, dir_origen, dir_destino, hr_reporte, txt_observacion "
            + "FROM \"mobil_sis_db_schema\".\"servicio\" "
            + "WHERE fe_servicio >= ? and fe_servicio <= ? ORDER BY fe_servicio ASC";

    /**
     * ********************** CLIENTES **********************
     */
    /**
     * CONSULTA TODOS LOS CLIENTES
     */
    public static final String _GET_ALL_CLIENTS = "SELECT nu_cedula, nb_cliente, nu_direccion FROM \"mobil_sis_db_schema\".\"cliente\"";

    /**
     * ********************** VEHICULOS **********************
     */
    /**
     * CONSULTA TODOS LOS VEHICULOS DISPONIBLES
     */
    public static final String _GET_ALL_VEHICULOS = "SELECT nu_vehiculo, nb_status, nu_placa, matriculado_en, clase_vehiculo, \n"
            + "       tipo, fecha_vinculacion, marca, modelo, nu_serial_chasis, color, \n"
            + "       serial_motor, tarjeta_propiedad, fecha_expedicion, nu_soat, \n"
            + "       cia_soat_seg, fecha_vencimiento_soat, nu_tarjeta_operacion, fecha_vencimiento_tarjeta_operacion, \n"
            + "       nu_tecnomecanica, fecha_vencimiento_tecnomecanica, propietario, \n"
            + "       conductor\n"
            + "  FROM \"mobil_sis_db_schema\".\"ViewVehiculos\";";

    /**
     * INSERTA NUEVO VEHICULO
     */
    public static final String _INSERT_NEW_VEHICULO = "INSERT INTO \"mobil_sis_db_schema\".\"vehiculo\"(nb_status, nu_placa, matriculado_en, clase_vehiculo, \n"
            + "            tipo, fecha_vinculacion, marca, modelo, nu_serial_chasis, color, \n"
            + "            serial_motor, tarjeta_propiedad, fecha_expedicion, nu_soat, \n"
            + "            cia_soat_seg, fecha_vencimiento_soat, nu_tarjeta_operacion, fecha_vencimiento_tarjeta_operacion, \n"
            + "            nu_tecnomecanica, fecha_vencimiento_tecnomecanica, propietario, \n"
            + "            conductor)\n"
            + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String _GET_VEHICULO_BY_N_PLACA = "SELECT nu_vehiculo, nb_status, nu_placa, matriculado_en, clase_vehiculo, "
            + "tipo, fecha_vinculacion, marca, modelo, nu_serial_chasis,  color, serial_motor, tarjeta_propiedad, fecha_expedicion, "
            + "nu_soat, cia_soat_seg, fecha_vencimiento_soat, nu_tarjeta_operacion, fecha_vencimiento_tarjeta_operacion, nu_tecnomecanica, "
            + "fecha_vencimiento_tecnomecanica, propietario,  conductor  "
            + "FROM \"mobil_sis_db_schema\".\"vehiculo\" "
            + "WHERE nu_vehiculo = ?";

    /**
     * ********************** CONDUCTORES **********************
     */
    /**
     * OBTIENE LA LISTA DE TODOS LOS CONDUCTORES
     */
    public static final String _GET_ALL_CONDUCTORES = "SELECT * FROM \"mobil_sis_db_schema\".\"ViewConductor\"";

    /**
     * OBTIENE CONDUCTOR DADO SU IDENTIFICACION PERSONAL
     */
    public static final String _GET_CONDUCTOR_BY_ID = "SELECT cond.nu_conductor,\n"
            + "	per.nu_identificacion,\n"
            + "	per.status,\n"
            + "	per.tipo_identificacion,\n"
            + "	per.identificacion_expedida_en,\n"
            + "	per.primer_apellido,\n"
            + "	per.segundo_apellido,\n"
            + "	per.primer_nombre,\n"
            + "	per.segundo_nombre,\n"
            + "	per.direccion,\n"
            + "	per.nu_telefono,\n"
            + "	per.grupo_sanguineo_rh,\n"
            + "	per.pasado_judicial,\n"
            + "	per.venc_pasado_judicial,\n"
            + "	per.txt_observacion,\n"
            + "	seg.eps,\n"
            + "	seg.fondo_pension,\n"
            + "	seg.riesgo_profesionales\n"
            + "	FROM \"mobil_sis_db_schema\".\"conductor\" AS cond, \"mobil_sis_db_schema\".\"personal\" AS per, \"mobil_sis_db_schema\".\"seguroPersonal\" AS seg\n"
            + "	WHERE cond.nu_identificacion = per.nu_identificacion AND per.nu_identificacion = ?";

    /**
     * INSERTA UN CONDUCTOR
     */
    public static final String _INSERT_NEW_CONDUCTOR = "INSERT INTO \"mobil_sis_db_schema\".\"conductor\"(\n"
            + "            nu_identificacion, status, tipo_identificacion, identificacion_expedida_en, \n"
            + "            primer_apellido, segundo_apellido, primer_nombre, segundo_nombre, \n"
            + "            direccion, nu_telefono, fecha_contratacion, grupo_sanguineo_rh, \n"
            + "            pasado_judicial, venc_pasado_judicial, txt_observacion, nu_eps, \n"
            + "            nu_fondo_pension, riesgo_laboral, licencia_conduccion, \n"
            + "            expedida_en, categoria_licencia, venc_lic_conduccion)\n"
            + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    /**
     * ********************** SESSION - LOGIN - USUARIO **********************
     */
    /**
     * INICIAR SESSION QUERY
     */
    public static final String _LOGIN_ACCESS_REQUEST = "SELECT username, rol FROM \"mobil_sis_db_schema\".\"users\" WHERE username = ? AND password = ?";
}
