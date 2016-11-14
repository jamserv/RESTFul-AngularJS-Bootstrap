var urlBase_login = "/mobil-sis-rest/rest/service/auth";
angular.module("loginModule", ['ngCookies'])

        .controller("ControllerLogin", ["$cookies", "$scope", "$rootScope", "authFactory", "$window", function ($cookies, $scope, $rootScope, authFactory, $window) {

                $("#divDataEmpty").hide();
                $scope.login = function (credentials) {

                    var result = authFactory.login(credentials);
                    result.success(function (data, status, headers, config) {
                        if (status === 200) {
                            $cookies.put("user", data);
                            $cookies.put("authId", data.authId);
                            $cookies.put("authPermission", data.authPermission);                            
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
                $("#divDataEmpty").hide();
                $rootScope.currentUser = $cookies.get("user");
                $scope.currentUsername = $cookies.get("authId");
                $rootScope.currentUsernameRol = $cookies.get("authPermission");                                                
                
                $scope.logout = function () {                    
                    $cookies.remove("user", $cookies.get("user"));
                    $cookies.remove("authId", $cookies.get("authId"));                    
                    $cookies.remove("authPermission", $cookies.get("authPermission"));  
                };
            }])

        .factory("authFactory", ['$http', function ($http) {
                var authFactory = {};
                authFactory.login = function (credentials) {
                    return $http.post(urlBase_login + '/login', credentials);
                };
                return authFactory;
            }]);


