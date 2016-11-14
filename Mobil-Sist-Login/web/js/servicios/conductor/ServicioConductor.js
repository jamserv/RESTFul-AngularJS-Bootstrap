
var urlBase_conductor = "/mobil-sis-rest/rest/service/conductor";

/**
 * 
 * @param {type} param1
 * @param {type} param2
 */
app_mobsis.factory("ServicioConductor", ["$http", function ($http) {
        var dataFactory = {};


        dataFactory.agregarConductorFactory = function (conductor) {
            var content = {
                nb_status: conductor.nb_status === undefined ? 'INACTIVO' : 'ACTIVO',
                nu_identificacion: conductor.nu_identificacion,
                tipo_identificacion: conductor.tipo_identificacion,
                identificacion_expedida_en: conductor.identificacion_expedida_en,
                primer_apellido: conductor.primer_apellido,
                segundo_apellido: conductor.segundo_apellido,
                primer_nombre: conductor.primer_nombre,
                segundo_nombre: conductor.segundo_nombre,
                direccion: conductor.direccion,
                nu_telefono: conductor.nu_telefono,
                fecha_contratacion: conductor.fecha_contratacion,
                grupo_sanguineo_rh: conductor.grupo_sanguineo_rh,
                pasado_judicial: conductor.pasado_judicial,
                venc_pasado_judicial: conductor.venc_pasado_judicial,
                txt_observacion: conductor.txt_observacion,
                eps: new Object{
                    nu_eps : conductor.eps.nu_eps
                },
                fondo_Pension: conductor.fondo_Pension.nu_fondo_pension,
                riesgos_Profesionales: conductor.riesgos_Profesionales.nu_riesgos_profesionales,
//                eps : epsObject,                
//                fondo_Pension: fondo_PensionObject,
//                riesgos_Profesionales: riesgos_ProfesionalesObject,                             
                licencia_conduccion: conductor.licencia_conduccion,
                expedida_en: conductor.expedida_en,
                categoria_licencia: conductor.categoria_licencia,
                venc_lic_conduccion: conductor.venc_lic_conduccion
            };
            return $http.post(urlBase_conductor + '/new', content);
        };

        dataFactory.getAllConductorFactory = function () {
            return $http.get(urlBase_conductor + '/all');
        };

        dataFactory.getVehiculoIdFactory = function (nu_vehiculo) {
            return $http.get(urlBase_conductor + '/id/' + nu_vehiculo);
        };

        return dataFactory;
    }]);

