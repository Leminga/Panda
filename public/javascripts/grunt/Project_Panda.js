angular.module('Panda',['Register','Login','ForgottenPassword']);


angular.module('RouteProvider', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/forgottenPassword', {
                templateUrl: '/forgottenPassword.html',
                controller: 'ForgottenPasswordCtrl'
            })
            .otherwise({
                redirectTo:'/'
            })
    }]);

angular.module('ForgottenPassword', [])
    .controller('ForgottenPasswordCtrl', ['ForgottenPasswordService', function (ForgottenPasswordService) {
        var self = this;

        self.sendForgottenPasswordRequest = function () {
            ForgottenPasswordService.forgottenPassword(self.email);
        };
    }]);
angular.module('Register', [])
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

angular.module('Login',[])
    .controller('LoginFormCtrl', ['LoginService', function (LoginService) {
    var self = this;

        self.sendLogin = function() {
            LoginService.login(self.user);
        };

    }]);

angular.module('ForgottenPassword')
    .factory('ForgottenPasswordService', ['$http', function ($http) {
        return {
            forgottenPassword: function (email) {
                return $http.post('/forgottenPassword', email);
            }
        }
    }]);

angular.module('Register')
    .factory('GetRegistrationService', ['$http', function ($http) {
        return {
            getRegistration:function(){
                return $http.get("/getRegistrationData");
            }
        };
    }]);
angular.module("Register")
    .factory('LoginService', ['$http', function ($http){
        return{
            login:function(user){
                return $http.post("/login",user);
            }
        };

    }]);
angular.module('Register')
    .factory('RegisterService', ['$http', function ($http) {
        return {
            register:function(user){
                $http.post("/register",user);
            }
        };
    }]);