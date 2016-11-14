package co.com.mobil.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author janez
 */
public class Vehiculo implements Serializable {

    private int nu_vehiculo;
    private String nb_status;
    private String nu_placa;
    private String matriculado_en;
    private String clase_vehiculo;
    private String tipo;
    private Date fecha_vinculacion;
    private String marca;
    private String modelo;
    private String nu_serial_chasis;
    private String color;
    private String serial_motor;
    private String tarjetaPropiedad;
    private Date fecha_expedicion;
    private String nu_soat;
    private String cia_soat_seg;
    private Date fecha_vencimiento_soat;
    private String nu_tarjeta_operacion;
    private Date fecha_vencimiento_tarjeta_operacion;
    private String nu_tecnomecanica;
    private Date fecha_vencimiento_tecnomecanica;
    private String propietario;
    private String conductor;

    public Vehiculo() {
    }

    /**
     *
     * @param nu_vehiculo
     * @param nb_status
     * @param nu_placa
     * @param matriculado_en
     * @param clase_vehiculo
     * @param tipo
     * @param fecha_vinculacion
     * @param marca
     * @param modelo
     * @param nu_serial_chasis
     * @param color
     * @param serial_motor
     * @param tarjetaPropiedad
     * @param fecha_expedicion
     * @param nu_soat
     * @param cia_soat_seg
     * @param fecha_vencimiento_soat
     * @param nu_tarjeta_operacion
     * @param fecha_vencimiento_tarjeta_operacion
     * @param nu_tecnomecanica
     * @param fecha_vencimiento_tecnomecanica
     * @param propietario
     * @param conductor
     */
    public Vehiculo(int nu_vehiculo, String nb_status, String nu_placa, String matriculado_en, String clase_vehiculo, String tipo, Date fecha_vinculacion, String marca, String modelo, String nu_serial_chasis, String color, String serial_motor, String tarjetaPropiedad, Date fecha_expedicion, String nu_soat, String cia_soat_seg, Date fecha_vencimiento_soat, String nu_tarjeta_operacion, Date fecha_vencimiento_tarjeta_operacion, String nu_tecnomecanica, Date fecha_vencimiento_tecnomecanica, String propietario, String conductor) {
        this.nu_vehiculo = nu_vehiculo;
        this.nb_status = nb_status;
        this.nu_placa = nu_placa;
        this.matriculado_en = matriculado_en;
        this.clase_vehiculo = clase_vehiculo;
        this.tipo = tipo;
        this.fecha_vinculacion = fecha_vinculacion;
        this.marca = marca;
        this.modelo = modelo;
        this.nu_serial_chasis = nu_serial_chasis;
        this.color = color;
        this.serial_motor = serial_motor;
        this.tarjetaPropiedad = tarjetaPropiedad;
        this.fecha_expedicion = fecha_expedicion;
        this.nu_soat = nu_soat;
        this.cia_soat_seg = cia_soat_seg;
        this.fecha_vencimiento_soat = fecha_vencimiento_soat;
        this.nu_tarjeta_operacion = nu_tarjeta_operacion;
        this.fecha_vencimiento_tarjeta_operacion = fecha_vencimiento_tarjeta_operacion;
        this.nu_tecnomecanica = nu_tecnomecanica;
        this.fecha_vencimiento_tecnomecanica = fecha_vencimiento_tecnomecanica;
        this.propietario = propietario;
        this.conductor = conductor;
    }

    public int getNu_vehiculo() {
        return nu_vehiculo;
    }

    public void setNu_vehiculo(int nu_vehiculo) {
        this.nu_vehiculo = nu_vehiculo;
    }

    public String getNb_status() {
        return nb_status;
    }

    public void setNb_status(String nb_status) {
        this.nb_status = nb_status;
    }

    public String getNu_placa() {
        return nu_placa;
    }

    public void setNu_placa(String nu_placa) {
        this.nu_placa = nu_placa;
    }

    public String getMatriculado_en() {
        return matriculado_en;
    }

    public void setMatriculado_en(String matriculado_en) {
        this.matriculado_en = matriculado_en;
    }

    public String getClase_vehiculo() {
        return clase_vehiculo;
    }

    public void setClase_vehiculo(String clase_vehiculo) {
        this.clase_vehiculo = clase_vehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha_vinculacion() {
        return fecha_vinculacion;
    }

    public void setFecha_vinculacion(Date fecha_vinculacion) {
        this.fecha_vinculacion = fecha_vinculacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNu_serial_chasis() {
        return nu_serial_chasis;
    }

    public void setNu_serial_chasis(String nu_serial_chasis) {
        this.nu_serial_chasis = nu_serial_chasis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSerial_motor() {
        return serial_motor;
    }

    public void setSerial_motor(String serial_motor) {
        this.serial_motor = serial_motor;
    }

    public String getTarjetaPropiedad() {
        return tarjetaPropiedad;
    }

    public void setTarjetaPropiedad(String tarjetaPropiedad) {
        this.tarjetaPropiedad = tarjetaPropiedad;
    }

    public Date getFecha_expedicion() {
        return fecha_expedicion;
    }

    public void setFecha_expedicion(Date fecha_expedicion) {
        this.fecha_expedicion = fecha_expedicion;
    }

    public String getNu_soat() {
        return nu_soat;
    }

    public void setNu_soat(String nu_soat) {
        this.nu_soat = nu_soat;
    }

    public String getCia_soat_seg() {
        return cia_soat_seg;
    }

    public void setCia_soat_seg(String cia_soat_seg) {
        this.cia_soat_seg = cia_soat_seg;
    }

    public Date getFecha_vencimiento_soat() {
        return fecha_vencimiento_soat;
    }

    public void setFecha_vencimiento_soat(Date fecha_vencimiento_soat) {
        this.fecha_vencimiento_soat = fecha_vencimiento_soat;
    }

    public String getNu_tarjeta_operacion() {
        return nu_tarjeta_operacion;
    }

    public void setNu_tarjeta_operacion(String nu_tarjeta_operacion) {
        this.nu_tarjeta_operacion = nu_tarjeta_operacion;
    }

    public Date getFecha_vencimiento_tarjeta_operacion() {
        return fecha_vencimiento_tarjeta_operacion;
    }

    public void setFecha_vencimiento_tarjeta_operacion(Date fecha_vencimiento_tarjeta_operacion) {
        this.fecha_vencimiento_tarjeta_operacion = fecha_vencimiento_tarjeta_operacion;
    }

    public String getNu_tecnomecanica() {
        return nu_tecnomecanica;
    }

    public void setNu_tecnomecanica(String nu_tecnomecanica) {
        this.nu_tecnomecanica = nu_tecnomecanica;
    }

    public Date getFecha_vencimiento_tecnomecanica() {
        return fecha_vencimiento_tecnomecanica;
    }

    public void setFecha_vencimiento_tecnomecanica(Date fecha_vencimiento_tecnomecanica) {
        this.fecha_vencimiento_tecnomecanica = fecha_vencimiento_tecnomecanica;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

}
