angular.module('RouteProvider', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/forgottenPassword', {
                templateUrl: '/forgottenPassword.html',
                controller: 'ForgottenPasswordCtrl'
            })
            .otherwise({
                redirectTo:'/'
            })
    }]);
