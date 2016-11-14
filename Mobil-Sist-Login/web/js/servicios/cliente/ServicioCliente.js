
var urlBase_client = "/mobil-sis-rest/rest/service/client/";               

/**
 * 
 * @param {type} param1
 * @param {type} param2
 */
app_mobsis.factory("ServicioCliente", ["$http", function ($http) {
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
            return $http.post(urlBase_client + 'service/new', content);
        };

        dataFactory.getAllClientsFactory = function () {
            return $http.get(urlBase_client + 'all');
        };
        
        dataFactory.getServiceIdFactory = function (nu_servicio) {
            return $http.get(urlBase_client + 'service/id/' + nu_servicio);
        };

        return dataFactory;
    }]);

