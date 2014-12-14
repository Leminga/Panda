angular.module('Panda')
    .controller('RegisterFormCtrl', ['RegisterService', 'GetRegistrationService','$window','$location', function (RegisterService, GetRegistrationService, $window) {
        var self = this;
        self.receivedRegistrationData = {};


        self.register = function () {
            RegisterService.register(self.user).then(function(response){
                    $window.alert(response.data);
            },function(response){
                    $window.alert(response.data);
                }
            );
        };


        self.getRegistration = function () {
            GetRegistrationService.getRegistration().then(function (response) {
                self.receivedRegistrationData = response.data;
            });

        };
    }]);