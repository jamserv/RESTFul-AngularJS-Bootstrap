var nu_vehiculo = -1;
app_mobsis.controller("ControllerVehiculos", ["$scope", '$route', "$rootScope", "FabricaVehiculos", "$window", function ($scope, $route, $rootScope, FabricaVehiculos, $window) {

        $scope.agregarVehiculo = function (vehiculo) {
            $rootScope.vehiculo = vehiculo;
            $('.ajax-loading').show();
            var result = FabricaVehiculos.agregarVehiculoFactory($rootScope.vehiculo);
            result.success(function (data, status, headers, config) {
                $('.ajax-loading').hide();
                $window.location.href = '/mobil-sist-user/#/SuccessProcess';
            });
            result.error(function (data, status, headers, config) {
                $('.ajax-loading').hide();
                $window.location.href = '/mobil-sist-user/#/FailureForm';
            });
        };

        $scope.getVehiculoId = function () {
            $('.ajax-loading').show();
            var result = FabricaVehiculos.getVehiculoIdFactory(nu_vehiculo);
            result.success(function (data, status, headers, config) {
                $scope.vehiculo = data;
                $('.ajax-loading').hide();
            });
            result.error(function (data, status, headers, config) {
                $('.ajax-loading').hide();
                $window.location.href = '/mobil-sist-user/#/FailureForm';
            });
        };

        $scope.getAllVehiculos = function () {
            $('.ajax-loading').show();
            var result = FabricaVehiculos.getAllVehiculosFactory();
            result.success(function (data, status, headers, config) {
                var tablaAllVehiculo = $('#tablaAllVehiculo').DataTable({
                    data: data,
                    columns: [
                        {data: 'nu_vehiculo'},
                        {data: 'nb_status'},
                        {data: 'nu_placa'},
                        {data: 'clase_vehiculo'},
                        {data: 'marca'},
                        {data: 'modelo'},
                        {data: 'nu_vehiculo', render: function () {
                                return '<a href="#/ver-vehiculo"><span class="glyphicon glyphicon-align-center glyphicon-search" aria-hidden="true"></span> Ver ..</a>';
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
                $('#tablaAllVehiculo tbody').on('click', 'tr', function () {
                    $(this).toggleClass('selected');
                    var data = tablaAllVehiculo.row($(this)).data();
                    nu_vehiculo = data.nu_vehiculo;
                });
                $('.ajax-loading').hide();
            });
            result.error(function (data, status, headers, config) {
                $('.ajax-loading').hide();
                $window.location.href = '/mobil-sist-user/#/FailureForm';
            });
        };
    }]);


