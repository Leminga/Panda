angular.module('Panda')
    .controller('RegisterFormCtrl', ['RegisterService', 'GetRegistrationService', '$window', '$location',
        function (RegisterService, GetRegistrationService, $window,$location) {
            var self = this;
            self.receivedRegistrationData = {};


            self.register = function () {
                RegisterService.register(self.user).then(function (response) {
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