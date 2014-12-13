angular.module('Panda')
    .controller('RegisterFormCtrl', ['RegisterService', 'GetRegistrationService','$window','$location', function (RegisterService, GetRegisterService) {
        var self = this;
        self.receivedRegistrationData = {};


        self.register = function () {
            self.user.password = md5(self.user.password);
            RegisterService.register(self.user).then(function(response){
                    $location.path("/");
                    $window.alert(response.ok);
            },function(response){
                    $window.alert(response.ok);
                }
            );
        };


        self.getRegistration = function () {
            GetRegistrationService.getRegistration().then(function (response) {
                self.receivedRegistrationData = response.data;
            });

        };
    }]);