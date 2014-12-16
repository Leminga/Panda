// This is the instantiated main-module. Every other module builds upon this one. Dependencies can be added in
// the square brackets.
angular.module('Panda',['ngRoute','ngStorage']);


angular.module('Panda')
    .controller('CoreDataFormCtrl', ['CoreDataService', '$localStorage', '$sessionStorage',
        function (CoreDataService, $localStorage, $sessionStorage) {
            var self = this;

            self.getData = function () {
                self.user.personalData.prename = $sessionStorage.volunteer.prename;
                self.user.personalData.surname = $sessionStorage.volunteer.surname;
                self.user.contactData.email = $sessionStorage.volunteer.loginData.username;
            };

            self.savePersonalData = function () {
                $sessionStorage.volunteer.prename = self.user.personalData.prename;
                $sessionStorage.volunteer.surname = self.user.personalData.surname;
                //CoreDataService.savePersonalData(self.user.personalData);
            };

            self.saveEmergencyContacts = function () {
                CoreDataService.saveEmergencyContacts(self.user.emergencyContacts);
            };

            self.saveContactData = function () {
                $sessionStorage.volunteer.loginData.username = self.user.contactData.email;
                //CoreDataService.saveContactData(self.user.contactData);
            };

            self.saveSizes = function () {
                CoreDataService.saveSizes(self.user.sizes);
            };

            self.saveAll = function () {
                CoreDataService.saveAll(self.user);
            };

        }]);

angular.module('Panda')
    .factory('CoreDataService', ['$http', function ($http) {
        return {
            savePersonalData: function (personalData) {
                return $http.post("/personalData", personalData);
            },

            saveContactData: function (contactData) {
                return $http.post("/contactData", contactData);
            },

            saveEmergencyContacts: function (emergencyContacts) {
                return $http.post("/emergencyData", emergencyContacts);
            },

            saveSizes: function (sizes) {
                return $http.post("/sizes", sizes);
            },

            saveAll: function (user) {
                return $http.post("/all", user);
            }
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
                    console.log($window.sessionStorage.getItem("token"));
                    $location.path('/overview')
                }, function (response) {  // error function
                    $window.alert("Wrong credentials");
                    console.log(self.user.test.test.test.email);
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
// The InterceptorService reacts to any of the mentioned http-methods (request, requestError..)
angular.module('Panda')
.factory('InterceptorService', ['$q','$window','$location', function($q,$window,$location) {
    return {
        request: function(config) {
            console.log('Request made with ', config);
            // At every request, the Token is being added to the Header for authentication purposes
            config.headers['X-AUTH-TOKEN'] = $window.sessionStorage.getItem("token");
            return config;
            // If an error, or not allowed, or my custom condition
            // return $q.reject('Not allowed');
        },
        requestError: function(rejection) {
            console.log('Request error due to ', rejection);
            // Continue to ensure that the next promise chain
            // sees an error
            return $q.reject(rejection);
            // Or handled successfully?
            // return someValue;
        },
        response: function(response) {
            console.log('Response from server', response);
            // Return a promise
            return response || $q.when(response);
        },
        responseError: function(rejection) {
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
    .config(['$httpProvider', function($httpProvider) {
    $httpProvider.interceptors.push('InterceptorService');
}]);
'use strict';

(function() {

    /**
     * @ngdoc overview
     * @name ngStorage
     */

    angular.module('ngStorage', []).

    /**
     * @ngdoc object
     * @name ngStorage.$localStorage
     * @requires $rootScope
     * @requires $window
     */

        factory('$localStorage', _storageFactory('localStorage')).

    /**
     * @ngdoc object
     * @name ngStorage.$sessionStorage
     * @requires $rootScope
     * @requires $window
     */

        factory('$sessionStorage', _storageFactory('sessionStorage'));

    function _storageFactory(storageType) {
        return [
            '$rootScope',
            '$window',
            '$log',

            function(
                $rootScope,
                $window,
                $log
            ){
                // #9: Assign a placeholder object if Web Storage is unavailable to prevent breaking the entire AngularJS app
                var webStorage = $window[storageType] || ($log.warn('This browser does not support Web Storage!'), {}),
                    $storage = {
                        $default: function(items) {
                            for (var k in items) {
                                angular.isDefined($storage[k]) || ($storage[k] = items[k]);
                            }

                            return $storage;
                        },
                        $reset: function(items) {
                            for (var k in $storage) {
                                '$' === k[0] || delete $storage[k];
                            }

                            return $storage.$default(items);
                        }
                    },
                    _last$storage,
                    _debounce;

                for (var i = 0, k; i < webStorage.length; i++) {
                    // #8, #10: `webStorage.key(i)` may be an empty string (or throw an exception in IE9 if `webStorage` is empty)
                    (k = webStorage.key(i)) && 'ngStorage-' === k.slice(0, 10) && ($storage[k.slice(10)] = angular.fromJson(webStorage.getItem(k)));
                }

                _last$storage = angular.copy($storage);

                $rootScope.$watch(function() {
                    _debounce || (_debounce = setTimeout(function() {
                        _debounce = null;

                        if (!angular.equals($storage, _last$storage)) {
                            angular.forEach($storage, function(v, k) {
                                angular.isDefined(v) && '$' !== k[0] && webStorage.setItem('ngStorage-' + k, angular.toJson(v));

                                delete _last$storage[k];
                            });

                            for (var k in _last$storage) {
                                webStorage.removeItem('ngStorage-' + k);
                            }

                            _last$storage = angular.copy($storage);
                        }
                    }, 100));
                });

                // #6: Use `$window.addEventListener` instead of `angular.element` to avoid the jQuery-specific `event.originalEvent`
                'localStorage' === storageType && $window.addEventListener && $window.addEventListener('storage', function(event) {
                    if ('ngStorage-' === event.key.slice(0, 10)) {
                        event.newValue ? $storage[event.key.slice(10)] = angular.fromJson(event.newValue) : delete $storage[event.key.slice(10)];

                        _last$storage = angular.copy($storage);

                        $rootScope.$apply();
                    }
                });

                return $storage;
            }
        ];
    }

})();
// The RouteProvider module, adds hash-bangs (=anchors) to the webpage. This allows fast and convenient routing, without
// constant reloading of the webpage.
angular.module('Panda')
    .config(['$routeProvider','$locationProvider', function ($routeProvider,$locationProvider) {
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

            // If none of the above routes fit to the link that has been inserted, the user is being automatically
            // rerouted to the login.html (route with '/')
            .otherwise({
                redirectTo: '/'
            });
    }]);

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
    .factory('GetRegistrationService', ['$http', function ($http) {
        return {
            getRegistration:function(){
                return $http.get("/getRegistrationData");
            }
        };
    }]);
angular.module('Panda')
    .controller('RegisterFormCtrl', ['RegisterService', 'GetRegistrationService', '$window', '$location', '$sessionStorage',
        function (RegisterService, GetRegistrationService, $window, $localStorage, $sessionStorage) {
            var self = this;
            self.receivedRegistrationData = {};
            $sessionStorage;

            self.register = function () {
                RegisterService.register(self.user).then(function (response) {
                        $sessionStorage.volunteer = response.data.volunteer;
                        console.log($sessionStorage.volunteer);
                        console.log($sessionStorage.volunteer.prename);
                        console.log($sessionStorage.volunteer.surname);
                        console.log($sessionStorage.volunteer.loginData.username);
                        $window.alert("Registration successful");
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