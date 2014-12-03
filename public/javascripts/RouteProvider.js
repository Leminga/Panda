angular.module('RouteProvider', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'assets/views/index.html'
            })
            .when('/forgottenPassword', {
                templateUrl: 'assets/views/forgottenPassword.html'

            })
            .otherwise({
                redirectTo: '/'
            })
    }]);
