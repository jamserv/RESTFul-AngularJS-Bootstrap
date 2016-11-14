var nu_conductor = -1;
app_mobsis.controller("ControllerConductor", ["$scope", '$route', "$rootScope", "ServicioConductor", "$window", function ($scope, $route, $rootScope, ServicioConductor, $window) {


        $scope.agregarConductor = function (conductor) {
            $rootScope.conductor = conductor;
            $('.ajax-loading').show();
            var result = ServicioConductor.agregarConductorFactory($rootScope.conductor);
            result.success(function (data, status, headers, config) {
                $('.ajax-loading').hide();
                $window.location.href = '/mobil-sist-user/#/SuccessProcess';
            });
            result.error(function (data, status, headers, config) {
                $('.ajax-loading').hide();
                $window.location.href = '/mobil-sist-user/#/FailureForm';
            });
        };

        $scope.getAllConductores = function () {
            $('.ajax-loading').show();
            var result = ServicioConductor.getAllConductorFactory();
            result.success(function (data, status, headers, config) {
                for (var index in data) {
                    data[index].primer_apellido = data[index].primer_apellido + ' ' + data[index].primer_nombre;
                }
                var tablaAllConductor = $('#tablaAllConductor').DataTable({
                    data: data,
                    columns: [
                        {data: 'nu_conductor'},
                        {data: 'nu_identificacion'},
                        {data: 'primer_apellido'},
                        {data: 'status'},
                        {data: 'nu_telefono'},
                        {data: 'nu_identificacion', render: function () {
                                return '<a href="#/ver-conductor"><span class="glyphicon glyphicon-align-center glyphicon-search" aria-hidden="true"></span> Ver ..</a>';
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
                $('#tablaAllConductor tbody').on('click', 'tr', function () {
                    $(this).toggleClass('selected');
                    var data = tablaAllConductor.row($(this)).data();
                    nu_conductor = data.nu_conductor;
                });
                $('.ajax-loading').hide();
            });
            result.error(function (data, status, headers, config) {
                $('.ajax-loading').hide();
                $window.location.href = '/mobil-sist-user/#/FailureForm';
            });
        };
    }]);


