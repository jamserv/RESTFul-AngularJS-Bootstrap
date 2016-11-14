
var nu_servicio = -1;

/**
 * 
 * @param {type} param1
 * @param {type} param2
 * 
 */
app_mobsis.controller("ServicioController", ["$scope", '$route', "$rootScope", "fabricaServicios", "$window", function ($scope, $route, $rootScope, fabricaServicios, $window) {

        /**
         * 
         * @param {type} servicio
         * @returns {undefined}
         */
        $scope.GenerarServicio = function (servicio) {
            $rootScope.servicio = servicio;
            $('.ajax-loading').show();
            var result = fabricaServicios.generarServicioFactory($rootScope.servicio);
            result.success(function (data, status, headers, config) {
                $('.ajax-loading').hide();
                $window.location.href = '/mobil-sist-user/#/SuccessProcess';
            });
            result.error(function (data, status, headers, config) {
                $('.ajax-loading').hide();
                $window.location.href = '/mobil-sist-user/#/FailureForm';
            });
        };

        /**
         * 
         * @param {type} servicio
         * @returns {undefined}
         */
        $scope.getReporte = function (servicio) {
            if (servicio !== null) {
                var serv_desde = servicio.fe_servicio;
                var serv_hasta = servicio.hr_reporte;
                $window.location.href = '/mobil-sis-rest/Reporter?tipo_reporte=servicios&desde=' + serv_desde + '&hasta=' + serv_hasta;
            } else {
                $window.location.href = '/mobil-sist-user/#/FailureForm';
            }
        };

        /**
         * 
         * @returns {undefined}
         */
        $scope.getServiceId = function () {
            $('.ajax-loading').show();
            var result = fabricaServicios.getServiceIdFactory(nu_servicio);
            result.success(function (data, status, headers, config) {
                $scope.service = data;
                $('.ajax-loading').hide();
            });
            result.error(function (data, status, headers, config) {
                $('.ajax-loading').hide();
                $window.location.href = '/mobil-sist-user/#/FailureForm';
            });
        };

        /**
         * 
         * @returns {undefined}
         */
        $scope.getAllServices = function () {
            $('.ajax-loading').show();
            var result = fabricaServicios.getAllServicesFactory();
            result.success(function (data, status, headers, config) {
                for (var index in data) {
                    data[index].dir_destino = data[index].dir_origen + ' > ' + data[index].dir_destino;
                }
                var tablaAllservice = $('#tablaAllservice').DataTable({
                    data: data,
                    columns: [
                        {data: 'nu_servicio'},
                        {data: 'fe_servicio',
                            render: function (fe_servicio) {
                                return $.format.date(new Date(fe_servicio), "dd/MM/yyyy");
                            }},
                        {data: 'dir_destino'},
                        {data: 'nu_servicio',
                            render: function (nu_servicio) {
                                return '<a href="#/DetailService"><span class="glyphicon glyphicon-align-center glyphicon-search" aria-hidden="true"></span> Ver ..</a>';
                            }}
                    ],
                    "pageLength": 10,
                    paging: true,
                    bInfo: false,
                    bLengthChange: false,
                    oLanguage: {
                        "sSearch": " Buscar:",
                        "sZeroRecords": "No hay datos que mostrar",
                        "oPaginate": {
                            "sNext": "Siguiente",
                            "sPrevious": "Anterior"
                        }
                    }
                });
                $('#tablaAllservice tbody').on('click', 'tr', function () {
                    $(this).toggleClass('selected');
                    var data = tablaAllservice.row($(this)).data();
                    nu_servicio = data.nu_servicio;
//                            $rootScope.nombreProyecto = data.proyecto.nombre;                                                        
                });
                $('.ajax-loading').hide();
            });
            result.error(function (data, status, headers, config) {
                $('.ajax-loading').hide();
                $window.location.href = '/mobil-sist-user/#/FailureForm';
            });
        };

    }]);
