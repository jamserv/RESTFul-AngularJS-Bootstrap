var urlBase_login = "/login/rest/services/auth";
angular.module("loginModule", ['ngCookies'])

        .controller("ControllerLogin", ["$cookies", "$scope", "$rootScope", "authFactory", "$window", function ($cookies, $scope, $rootScope, authFactory, $window) {

                $("#divDataEmpty").hide();
                $scope.login = function (credentials) {

                    var result = authFactory.login(credentials);
                    result.success(function (data, status, headers, config) {
                        if (status === 200) {
                            $cookies.put("user", data);
                            $("#divDataEmpty").hide();
                        } else if (status === 204) {
                            $("#divDataEmpty").show();
                            $scope.errorMessage = 'Usuario o clave invalida';
                            document.getElementById("username").value = "";
                            document.getElementById("password").value = "";                                                                                    
                        }
                    });
                    result.error(function (data, status, headers, config) {
                        $scope.errorMessage = 'Ocurrio un error al iniciar session.!';
                        $("#divDataEmpty").show();
                    });
                };
            }])

        .controller("ControllerApplication", ["$cookies", "$scope", "$rootScope", function ($cookies, $scope, $rootScope) {

//                authId
                console.log('user : ' + $cookies.get("user"));
                $("#divDataEmpty").hide();
                $rootScope.currentUser = $cookies.get("user");

                $scope.logout = function () {
                    console.log('logout user : ' + $cookies.get("user"));
                    $cookies.remove("user", $cookies.get("user"));
                };
            }])

        .factory("authFactory", ['$http', function ($http) {
                var authFactory = {};
                authFactory.login = function (credentials) {
                    return $http.post(urlBase_login + '/login', credentials);
                };
                return authFactory;
            }]);


