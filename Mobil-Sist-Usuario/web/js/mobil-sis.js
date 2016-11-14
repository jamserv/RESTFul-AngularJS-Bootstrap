
var app_mobsis = angular.module("mobilsis", ['loginModule', 'ngRoute', 'ui.bootstrap', 'ngTouch', 'angucomplete'])

        .config(function ($routeProvider) {
            $routeProvider
                    .when('/', {
                        templateUrl: 'views/FormularioBienvenida.html'
                    })
                    .when('/SuccessProcess', {
                        templateUrl: 'views/SuccessForm.html'
                    })
                    .when('/FailureForm', {
                        templateUrl: 'views/FormularioError.html'
                    })
                    //SERVICIOS
                    .when('/agregar-servicio', {
                        templateUrl: 'views/servicios/nuevo.html',
                        controller: 'ServicioController'
                    })
                    .when('/reporte-servicio', {
                        templateUrl: 'views/servicios/FormularioReporteServicios.html',
                        controller: 'ServicioController'
                    })
                    .when('/DetailService', {
                        templateUrl: 'views/servicios/FormularioDetalleServicio.html'
                    })
                    .when('/servicios', {
                        templateUrl: 'views/FormularioServicios.html',
                        controller: 'ServicioController'
                    })
                    //CONDUCTORES
                    .when('/conductores', {
                        templateUrl: 'views/conductor/FormularioConductores.html'
                    })
                    .when('/agregar-conductor', {
                        templateUrl: 'views/conductor/FormularioNuevoConductor.html'                        
                    })
                    .when('/ver-conductor', {
                        templateUrl: 'views/conductor/FormularioDetalleConductor.html'                       
                    })
                    .when('/reporte-conductor', {
                        templateUrl: 'views/conductor/FormularioReporteConductor.html'
                    })

                    //VEHICULOS
                    .when('/vehiculos', {
                        templateUrl: 'views/vehiculos/FormularioVehiculos.html'
                    }).
                    when('/agregar-vehiculo', {
                        templateUrl: 'views/vehiculos/FormularioNuevoVehiculo.html'
                    })
                    .when('/ver-vehiculo', {
                        templateUrl: 'views/vehiculos/FormularioDetalleVehiculo.html'
                    }).
                    when('/detalle-vehiculos', {
                        templateUrl: 'views/vehiculos/FormularioDetalleVehiculo.html'
                    }).
                    when('/reporte-vehiculos', {
                        templateUrl: 'views/vehiculos/FormularioReporteVehiculo.html'
                    });
        });

app_mobsis.controller('Datepicker', function ($scope) {
    $scope.dt = null;
    $scope.today = function () {
        $scope.dt = new Date();
    };
    $scope.today();
    $scope.clear = function () {
        $scope.dt = null;
    };
    // Disable weekend selection
//    $scope.disabled = function (date, mode) {
//        return (mode === 'day' && (date.getDay() === 0 || date.getDay() === 6));
//    };
    $scope.toggleMin = function () {
        $scope.minDate = $scope.minDate ? null : new Date();
    };
    $scope.toggleMin();
    $scope.open = function ($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.opened = true;
    };
    $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1
    };
    $scope.formats = ['dd/MM/yyyy', 'dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];
    var tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);
    var afterTomorrow = new Date();
    afterTomorrow.setDate(tomorrow.getDate() + 2);
    $scope.events =
            [
                {
                    date: tomorrow,
                    status: 'full'
                },
                {
                    date: afterTomorrow,
                    status: 'partially'
                }
            ];
    $scope.getDayClass = function (date, mode) {
        if (mode === 'day') {
            var dayToCheck = new Date(date).setHours(0, 0, 0, 0);
            for (var i = 0; i < $scope.events.length; i++) {
                var currentDay = new Date($scope.events[i].date).setHours(0, 0, 0, 0);
                if (dayToCheck === currentDay) {
                    return $scope.events[i].status;
                }
            }
        }

        return '';
    };
});