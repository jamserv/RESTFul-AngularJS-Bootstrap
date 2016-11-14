
app_mobsis.controller("ClienteController", ["$scope", '$route', "$rootScope", "ServicioCliente", "$window", function ($scope, $route, $rootScope, ServicioCliente, $window) {
        /**
         * 
         * @returns {undefined}
         */
        $scope.getAllClients = function () {
            $('.ajax-loading').show();
            var result = ServicioCliente.getAllClientsFactory();
            result.success(function (data, status, headers, config) {
                $scope.cliente = data;
                $('.ajax-loading').hide();
            });
            result.error(function (data, status, headers, config) {
                $('.ajax-loading').hide();
                $window.location.href = '/mobil-sist-user/#/FailureForm';
            });
        };
    }]);


