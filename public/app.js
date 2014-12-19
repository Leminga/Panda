// This is the instantiated main-module. Every other module builds upon this one. Dependencies can be added in
// the square brackets.
angular.module('Panda',['ngRoute']);


angular.module('Panda')
    .controller('CoreDataFormCtrl', ['DataService', '$window',
        function (DataService, $window) {
            var self = this;
            var token = $window.sessionStorage.getItem("token");

            self.saveData = function () {
                DataService.save(self.user);
            };

            self.getData = function () {
                DataService.get(token).then(function(response){
                    self.user = response.data;
                });
            };

        }]);

angular.module('Panda')
    .controller('EventSpecificFormCtrl', ['DataService', '$window',
        function (DataService,$window) {
        var self = this;
        var token = $window.sessionStorage.getItem("token");

        self.saveData = function () {
            DataService.save(self.user);
        };

        self.getData = function () {
            DataService.get(token).then(function(response){
                self.user = response.data;
            });
        };
    }]);

// This controller is used for the forgotten Password webpage. It handles the request to the controller, which checks
// whether the user exists or not and then handles the password reset.
angular.module('Panda')
    .controller('ForgottenPasswordCtrl', ['ForgottenPasswordService', function (ForgottenPasswordService) {
        var self = this;

        // Sends the request to the controller for a password recovery
        self.sendForgottenPasswordRequest = function () {
            ForgottenPasswordService.forgottenPassword(self.email);
        }
    }]);
// Service used with the ForgottenPasswordController, which handles all requests to the server.
angular.module('Panda')
    .factory('ForgottenPasswordService', ['$http', function ($http) {
        return {
            forgottenPassword: function (email) {
                return $http.post('/forgottenPassword', email);
            }
        }
    }]);

// The LoginFormController handles the login and authentication of the user.
angular.module('Panda')
    .controller('LoginFormCtrl', ['LoginService' ,'$window', '$location', function (LoginService, $window, $location) {
        var self = this;
        // This sends the Login to the controller, where it is being checked, whether the user exists or not.
        // If the user does not exist, then he receives an Error Message (TBD)
        self.sendLogin = function () {
            LoginService.login(self.user).then(
                function (response) { // success function
                    $window.sessionStorage.setItem("token", response.data.authToken);
                    $location.path('/overview')
                }, function (response) {  // error function
                    $window.alert("Wrong credentials");
                });
        };
    }]);

// Service that is being used with the LoginFormCtrl.
angular.module('Panda')
    .factory('LoginService', ['$http', function ($http) {
        return {
            login: function (user) {
                return $http.post("/login", user);
            }
        };

    }]);
angular.module('Panda')
    .service('DataService', ['$http', function ($http) {
        return {
            save: function (user) {
                return $http.patch("/saveUser", user);
            },

            get: function (token) {
                return $http.get("/getUser",{
                  params:{token: token}
                });
            }
        };
    }]);
// The InterceptorService reacts to any of the mentioned http-methods (request, requestError..)
angular.module('Panda')
    .factory('InterceptorService', ['$q', '$window', function ($q, $window) {
        return {

            request: function (config) {
                console.log('Request made with ', config);
                // At every request, the Token is being added to the Header for authentication purposes
                config.headers['X-AUTH-TOKEN'] = $window.sessionStorage.getItem("token");
                return config;
                // If an error, or not allowed, or my custom condition
                // return $q.reject('Not allowed');
            },
            requestError: function (rejection) {
                console.log('Request error due to ', rejection);
                // Continue to ensure that the next promise chain
                // sees an error
                return $q.reject(rejection);
                // Or handled successfully?
                // return someValue;
            },
            response: function (response) {
                console.log('Response from server', response);
                // Return a promise
                return response || $q.when(response);
            },
            responseError: function (rejection) {
                console.log('Error in response ', rejection);
                // Continue to ensure that the next promise chain
                // sees an error
                // Can check auth status code here if need to
                if (rejection.status === 403) {
                    //   Show a login dialog
                    //   return a value to tell controllers it has
                    // been handled
                }
                // Or return a rejection to continue the
                // promise failure chain
                return $q.reject(rejection);
            }
        };
    }])
    // The InterceptorService is being added to this .config module, which results it being used right away from the
    // build-up of the webpage.
    .config(['$httpProvider', function ($httpProvider) {
        $httpProvider.interceptors.push('InterceptorService');
    }]);
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


            // If none of the above routes fit to the link that has been inserted, the user is being automatically
            // rerouted to the login.html (route with '/')
            .otherwise({
                redirectTo: '/'
            });
    }])
;

// This module is needed for form validation. It checks whether 2 fields are exactly the same or not.

var compareTo = function () {
    return {
        require: "ngModel",
        scope: {
            otherModelValue: "=compareTo"
        },
        link: function (scope, element, attributes, ngModel) {

            ngModel.$validators.compareTo = function (modelValue) {
                return modelValue == scope.otherModelValue;
            };

            scope.$watch("otherModelValue", function () {
                ngModel.$validate();
            });
        }
    };
};

angular.module('Panda').directive("compareTo", compareTo);
// This controller handles the overview form, which is used for viewing user-related data on a single page.
angular.module('Panda')
    .controller('OverviewFormCtrl', ['$window' ,'$location', function ($window, $location) {
        // Check whether the user is logged in or not
        if ($window.sessionStorage.getItem("token") === null) {
            $location.path("/");
        }

        var self = this;

        // Logout function that clears the local and session storage (= Cookies) from the user and
        // then he is being rerouted to the login page
        self.logout = function(config){
            sessionStorage.clear();
            localStorage.clear();
            $location.path("/");
        }

    }]);


angular.module('Panda')
    .controller('QualificationsFormCtrl', ['DataService', '$window',
        function (DataService, $window) {
        var self = this;
        var token = $window.sessionStorage.getItem("token");

        self.saveData = function () {
            DataService.save(self.user);
        };

        self.getData = function () {
            DataService.get(token).then(function(response){
                self.user = response.data;
            });
        };
    }]);

angular.module('Panda')
    .factory('GetRegistrationService', ['$http', function ($http) {
        return {
            getRegistration:function(){
                return $http.get("/getRegistrationData");
            }
        };
    }]);
angular.module('Panda')
    .controller('RegisterFormCtrl', ['RegisterService', 'GetRegistrationService', '$window', '$location',
        function (RegisterService, GetRegistrationService, $window,$location) {
            var self = this;
            self.receivedRegistrationData = {};


            self.register = function () {
                RegisterService.register(self.user).then(function (response) {
                        $window.alert("Registration successful");
                        $window.setTimeout($location.path("/"),3000);
                    }, function (response) {
                        $window.alert("Registration unsuccessful");
                    }
                );
            };


            self.getRegistration = function () {
                GetRegistrationService.getRegistration().then(function (response) {
                    self.receivedRegistrationData = response.data;
                });

            };
        }]);
angular.module('Panda')
    .factory('RegisterService', ['$http', function ($http) {
        return {
            register:function(user){
                return $http.post("/register",user);
            }
        };
    }]);