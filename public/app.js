// This is the instantiated main-module. Every other module builds upon this one. Dependencies can be added in
// the square brackets.
angular.module('Panda',['ngRoute']);


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
    .controller('LoginFormCtrl', ['LoginService', '$window','$location', function (LoginService, $window, $location) {
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
                    console.log("Test");
                });
        };
    }]);

// Service that is being used with the LoginFormCtrl.
angular.module('Panda')
    .factory('LoginService', ['$http', function ($http){
        return{
            login:function(user){
                return $http.post("/login",user);
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
// The RouteProvider module, adds hash-bangs (=anchors) to the webpage. This allows fast and convenient routing, without
// constant reloading of the webpage.
angular.module('Panda')
    .config(['$routeProvider', function ($routeProvider) {
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

            // If none of the above routes fit to the link that has been inserted, the user is being automatically
            // rerouted to the login.html (route with '/')
            .otherwise({
                redirectTo: '/'
            })
    }]);

// This controller handles the overview form, which is used for viewing user-related data on a single page.
angular.module('Panda')
    .controller('OverviewFormCtrl', ['$window', '$location', function ($window, $location) {
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
            $location.path("/")
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
    .controller('RegisterFormCtrl', ['RegisterService', 'GetRegistrationService', function (RegisterService, GetRegisterService) {
        var self = this;

        self.receivedRegistrationData = {};


        self.register = function () {
            RegisterService.register(self.user);
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
                $http.post("/register",user);
            }
        };
    }]);