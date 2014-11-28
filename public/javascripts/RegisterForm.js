angular.module('Register', [])
    .controller('RegisterCtrl', ['RegisterService', 'GetRegistrationService', '$log', function (RegisterService, GetRegisterService) {
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

        }
        /*
         self.register = function () {
         self.receivedRegistrationData = user;
         };

         self.getRegistration = function () {
         console.log(JSON.stringify(self.receivedRegistrationData));
         };
         */
    }]);
