angular.module('Panda')
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'assets/views/login.html',
                controller: 'LoginFormCtrl as loginCtrl'
            })
            .when('/forgottenPassword', {
                templateUrl: 'assets/views/forgottenPassword.html',
                controller:'RegisterFormCtrl as registerCtrl'
            })
            .otherwise({
                redirectTo: '/'
            })
    }]);
