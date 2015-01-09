// This is the instantiated main-module. Every other module builds upon this one. Dependencies can be added in
// the square brackets.
angular.module('Panda', ['ngRoute']);


angular.module('Panda')
    .controller('CoreDataFormCtrl', ['DataService', '$window',
        function (DataService) {
            var self = this;

            DataService.get().then(function (response) {
                self.user = response.data;
            });

            self.saveData = function (user) {
                DataService.save(user);
            };


        }]);

// Controller for eventSpecific.html
angular.module('Panda')
    .controller('EventSpecificFormCtrl', ['DataService',
        function (DataService) {
            var self = this;

            DataService.get().then(function (response) {
                self.user = response.data;
            });

            self.saveData = function (user) {
                DataService.save(user);
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
    .controller('LoginFormCtrl', ['LoginService', '$window', '$location', function (LoginService, $window, $location) {
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
// This is the main Data service. Due to the forms working the same, this service is integrated in many
// controllers.
angular.module('Panda')
    .service('DataService', ['$http', '$window', function ($http, $window) {
        return {
            save: function (user) {
                return $http.patch("/saveUser", user);
            },

            get: function () {
                // The token is given to the Backend controller right away.
                //return $http.post("/getUser", $window.sessionStorage.getItem("token"));
                return $http.get("/getUser");
            }
        }
    }]);


// Converts files (in this case our profile and passport pictures) to BASE64 and adds the data output to that data model
angular.module('Panda')
    .directive('appFilereader', function(
        $q
    ){
        var slice = Array.prototype.slice;

        return {
            restrict: 'A'
            , require: '?ngModel'
            , link: function(scope, element, attrs, ngModel){
                if(!ngModel) return;

                ngModel.$render = function(){}

                element.bind('change', function(e){
                    var element = e.target;

                    $q.all(slice.call(element.files, 0).map(readFile))
                        .then(function(values){
                            if(element.multiple) ngModel.$setViewValue(values);
                            else ngModel.$setViewValue(values.length ? values[0] : null);
                        });

                    function readFile(file) {
                        var deferred = $q.defer();

                        var reader = new FileReader()
                        reader.onload = function(e){
                            deferred.resolve(e.target.result);
                        }
                        reader.onerror = function(e) {
                            deferred.reject(e);
                        }
                        reader.readAsDataURL(file);

                        return deferred.promise;
                    }

                });//change

            }//link

        };//return

    })//appFilereader
;
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
        // This stores every HTTP-Call in a corresponding cache - this could prove to be useful for data-refreshing in
        // forms.
        $httpProvider.defaults.cache = true;
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
    .controller('OverviewFormCtrl', ['$window', '$location','DataService', function ($window, $location, DataService) {
        var self = this;

        DataService.get().then(function (response) {
            self.user = response.data;
        });


        // Logout function that clears the local and session storage (= Cookies) from the user and
        // then he is being rerouted to the login page
        self.logout = function (config) {
            sessionStorage.clear();
            localStorage.clear();
            $location.path("/");
        }

    }])
;


angular.module('Panda')
    .controller('QualificationsFormCtrl', ['DataService', '$window',
        function (DataService, $window) {
            var self = this;

            DataService.get().then(function (response) {
                self.user = response.data;
            });

            self.saveData = function (user) {
                DataService.save(user);
            };

            // Check whether the language is "Other" or not. If so, then don't display the additional fields.
            self.languageCheck = function(language){
                if(language == 'other' || language == null){
                    return false;
                }else{
                    return true;
                }
            }

        }]);

angular.module('Panda')
    .factory('GetRegistrationService', ['$http', function ($http) {
        return {
            getRegistration:function(){
                return $http.get("/getRegistrationData");
            }
        };
    }]);
// This controller handles the registration of a user
angular.module('Panda')
    .controller('RegisterFormCtrl', ['RegisterService', 'GetRegistrationService', '$window', '$location',
        function (RegisterService, GetRegistrationService, $window,$location) {
            var self = this;
            self.receivedRegistrationData = {};

// This method sends the input data to the controller and receives information on the success or failure of the
// registration.

            self.register = function () {
                RegisterService.register(self.user).then(function (response) {
                        // TODO: React to the controllers messages, don't leave them hardcoded.
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