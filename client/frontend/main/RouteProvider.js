// The RouteProvider module, adds hash-bangs (=anchors) to the webpage. This allows fast and convenient routing, without
// constant reloading of the webpage.
angular.module('Panda')
    .config(['$routeProvider', '$locationProvider', function ($routeProvider) {
        $routeProvider
            // This is the root route, which connects to the login.html
            .when('/', {
                templateUrl: 'assets/views/login.html',
                controller: 'LoginFormCtrl as loginCtrl'
            })

            // User Routes
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
            .when('/coreData', {
                templateUrl: 'assets/views/coreData.html',
                controller: 'CoreDataFormCtrl as coreDataCtrl'
            })
            .when('/eventSpecific', {
                templateUrl: 'assets/views/eventSpecific.html',
                controller: 'EventSpecificFormCtrl as eventSpecificCtrl'
            })
            .when('/qualifications', {
                templateUrl: 'assets/views/qualifications.html',
                controller: 'QualificationsFormCtrl as qualificationsCtrl'
            })


            //Admin Routes
            .when('/adminOverview', {
                templateUrl: 'assets/views/adminOverview.html',
                controller: 'AdminOverviewCtrl as adminCtrl'
            })

            .when('/adminCoreData', {
                templateUrl: 'assets/views/coreData.html',
                controller: 'CoreDataFormCtrl as coreDataCtrl'
            })

            .when('/adminQualifications', {
                templateUrl: 'assets/views/qualifications.html',
                controller: 'QualificationsFormCtrl as qualificationsCtrl'
            })

            .when('/adminEventSpecific', {
                templateUrl: 'assets/views/eventSpecific.html',
                controller: 'EventSpecificFormCtrl as eventSpecificCtrl'
            })



            // If none of the above routes fit to the link that has been inserted, the user is being automatically
            // rerouted to the login.html (route with '/')
            .otherwise({
                redirectTo: '/'
            });
    }])
;
