
var urlBase_vehiculos = "/mobil-sis-rest/rest/service/mobil";

/**
 * 
 * @param {type} param1
 * @param {type} param2
 */
app_mobsis.factory("FabricaVehiculos", ["$http", function ($http) {
        var dataFactory = {};
        dataFactory.agregarVehiculoFactory = function (vehiculo) {
            var content = {
                nb_status: vehiculo.nb_status === undefined ? 'INACTIVO' : 'ACTIVO',
                nu_placa: vehiculo.nu_placa,
                matriculado_en: vehiculo.matriculado_en,
                clase_vehiculo: vehiculo.clase_vehiculo,                
                tipo: vehiculo.tipo,
                fecha_vinculacion: vehiculo.fecha_vinculacion,
                marca: vehiculo.marca,
                modelo: vehiculo.modelo,
                nu_serial_chasis: vehiculo.nu_serial_chasis,
                color: vehiculo.color,
                serial_motor: vehiculo.serial_motor,
                tarjetaPropiedad: vehiculo.tarjetaPropiedad,
                fecha_expedicion: vehiculo.fecha_expedicion,               
                nu_soat: vehiculo.nu_soat,
                cia_soat_seg: vehiculo.cia_soat_seg,
                fecha_vencimiento_soat: vehiculo.fecha_vencimiento_soat,
                nu_tarjeta_operacion: vehiculo.nu_tarjeta_operacion,
                fecha_vencimiento_tarjeta_operacion: vehiculo.fecha_vencimiento_tarjeta_operacion,                
                nu_tecnomecanica: vehiculo.nu_tecnomecanica,
                fecha_vencimiento_tecnomecanica: vehiculo.fecha_vencimiento_tecnomecanica,
                propietario: vehiculo.propietario,
                conductor: vehiculo.conductor
            };
            return $http.post(urlBase_vehiculos + '/new', content);
        };

        dataFactory.getAllVehiculosFactory = function () {
            return $http.get(urlBase_vehiculos + '/all');
        };
        
        dataFactory.getVehiculoIdFactory = function (nu_vehiculo) {
            return $http.get(urlBase_vehiculos + '/id/' + nu_vehiculo);
        };

        return dataFactory;
    }]);

