angular.module('Panda',['ngRoute']);


angular.module('Panda')
    .controller('ForgottenPasswordCtrl', ['ForgottenPasswordService', function (ForgottenPasswordService) {
        var self = this;

        self.sendForgottenPasswordRequest = function () {
            ForgottenPasswordService.forgottenPassword(self.email);
            /*
             .success(function () {
             self.status = "Request was sent successfully. You should receive an E-Mail within 10 minutes"

             }).error(function (error) {
             self.status = "There was an error." + error.message;
             })
             */
        }
    }]);
angular.module('Panda')
    .factory('ForgottenPasswordService', ['$http', function ($http) {
        return {
            forgottenPassword: function (email) {
                return $http.post('/forgottenPassword', email);
            }
        }
    }]);

angular.module('Panda')
    .controller('LoginFormCtrl', ['LoginService','$window', function (LoginService,$window) {
        var self = this;
        var token = undefined;

        self.sendLogin = function () {
            LoginService.login(self.user).then(function(response){
                console.log(response);
                $window.sessionStorage.setItem("token");
            });
        };

        /*.
         success(function (ö) {
         self.status = "Login successful"

         }).error(function (error) {
         self.status = "There was an error." + error.message;
         });
         */


    }]);

angular.module('Panda')
    .factory('LoginService', ['$http', function ($http){
        return{
            login:function(user){
                return $http.post("/login",user);
            }
        };

    }]);
angular.module('Panda')
.factory('InterceptorService', ['$q','$window', function($q,$window) {
    return {
        request: function(config) {
            console.log('Request made with ', config);
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
    .config(['$httpProvider', function($httpProvider) {
        $httpProvider.interceptors.push('InterceptorService');
    }]);
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
        var promise = 0;
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