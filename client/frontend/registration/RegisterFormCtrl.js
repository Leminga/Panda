// This controller handles the registration of a user
angular.module('Panda')
    .controller('RegisterFormCtrl', ['RegisterService', 'GetRegistrationService', '$window', '$location',
        function (RegisterService, GetRegistrationService, $window,$location) {
            var self = this;
            self.receivedRegistrationData = {};

// This method sends the input data to the controller and receives information on the success or failure of the
// registration.

            self.register = function () {
                RegisterService.register(self.user).then(function (response) {
                        // TODO: React to the controllers messages, don't leave them hardcoded.
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