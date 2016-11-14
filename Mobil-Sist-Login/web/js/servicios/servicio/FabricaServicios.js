
var urlBase_servicios = "/mobil-sis-rest/rest/service/service";

/**
 * 
 * @param {type} param1
 * @param {type} param2
 */
app_mobsis.factory("fabricaServicios", ["$http", function ($http) {
        var dataFactory = {};
        dataFactory.generarServicioFactory = function (servicio) {
            var content = {
                cedula_cliente: servicio.cedula_cliente,
                fe_servicio: servicio.fe_servicio,
                dir_origen: servicio.dir_origen,
                dir_destino: servicio.dir_destino,
                hr_reporte: servicio.hr_reporte,
                txt_observacion: servicio.txt_observacion
            };
            return $http.post(urlBase_servicios + '/new', content);
        };

        dataFactory.getAllServicesFactory = function () {
            return $http.get(urlBase_servicios + '/all');
        };
        
        dataFactory.getServiceIdFactory = function (nu_servicio) {
            return $http.get(urlBase_servicios + '/id/' + nu_servicio);
        };

        return dataFactory;
    }]);

