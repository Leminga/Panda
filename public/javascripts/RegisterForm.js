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
