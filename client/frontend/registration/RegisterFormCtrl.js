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