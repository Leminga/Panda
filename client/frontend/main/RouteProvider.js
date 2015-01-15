// The RouteProvider module, adds hash-bangs (=anchors) to the webpage. This allows fast and convenient routing, without
// constant reloading of the webpage.
angular.module('Panda')
    .config(['$routeProvider', '$locationProvider', function ($routeProvider) {
        $routeProvider
            // This is the root route, which connects to the login.html
            .when('/', {
                title: "Login",
                templateUrl: 'assets/views/login.html',
                controller: 'LoginFormCtrl as loginCtrl'
            })

            // User Routes
            .when('/forgottenPassword', {
                title: "Forgotten Password",
                templateUrl: 'assets/views/forgottenPassword.html',
                controller: 'ForgottenPasswordCtrl as forgottenPassword'
            })
            .when('/register', {
                title: "Register",
                templateUrl: 'assets/views/register.html',
                controller: 'RegisterFormCtrl as registerCtrl'
            })
            .when('/overview', {
                title: "Overview",
                templateUrl: 'assets/views/overview.html',
                controller: 'OverviewFormCtrl as overviewCtrl'
            })
            .when('/coreData', {
                title: 'Core Data',
                templateUrl: 'assets/views/coreData.html',
                controller: 'CoreDataFormCtrl as coreDataCtrl'
            })
            .when('/eventSpecific', {
                title: "Event-Specific",
                templateUrl: 'assets/views/eventSpecific.html',
                controller: 'EventSpecificFormCtrl as eventSpecificCtrl'
            })
            .when('/qualifications', {
                title: "Qualifications",
                templateUrl: 'assets/views/qualifications.html',
                controller: 'QualificationsFormCtrl as qualificationsCtrl'
            })


            //Admin Routes
            .when('/adminOverview', {
                title: 'Admin Core Data',
                templateUrl: 'assets/views/adminOverview.html',
                controller: 'AdminOverviewCtrl as adminCtrl'
            })

            .when('/adminCoreData', {
                title: 'Admin Core Data',
                templateUrl: 'assets/views/coreData.html',
                controller: 'CoreDataFormCtrl as coreDataCtrl'

            })

            .when('/adminQualifications', {
                title: 'Admin Qualifications',
                templateUrl: 'assets/views/qualifications.html',
                controller: 'QualificationsFormCtrl as qualificationsCtrl'
            })

            .when('/adminEventSpecific', {
                title: 'Admin Event-Specific',
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
