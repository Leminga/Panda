angular.module('Panda')
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'assets/views/login.html',
                controller: 'LoginFormCtrl as loginCtrl'
            })
            .when('/forgottenPassword', {
                templateUrl: 'assets/views/forgottenPassword.html',
                controller: 'ForgottenPasswordCtrl as forgottenPassword'
            })
            .when('/register', {
                templateUrl: 'assets/views/register.html',
                controller: 'RegisterFormCtrl as registerCtrl'
            })
            .when('/overview', {

                templateUrl: 'assets/views/overview.html',
                controller: 'OverviewFormCtrl as overviewCtrl'
            })
            .otherwise({
                redirectTo: '/'
            })
    }]);
