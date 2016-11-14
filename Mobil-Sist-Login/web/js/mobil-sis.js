
var app_mobsis = angular.module("mobilsis", ['loginModule', 'ngRoute'])

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
                    });
        });

//app_mobsis.config(function ($httpProvider) {
//    $httpProvider.interceptors.push('authHttpRequestInterceptor');
//});