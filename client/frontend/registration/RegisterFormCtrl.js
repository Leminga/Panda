angular.module('Panda')
    .controller('RegisterFormCtrl', ['RegisterService', 'GetRegistrationService', '$window', '$location', '$sessionStorage',
        function (RegisterService, GetRegistrationService, $window, $localStorage, $sessionStorage) {
            var self = this;
            self.receivedRegistrationData = {};
            $sessionStorage;

            self.register = function () {
                RegisterService.register(self.user).then(function (response) {
                        $sessionStorage.volunteer = response.data.volunteer;
                        console.log($sessionStorage.volunteer);
                        console.log($sessionStorage.volunteer.prename);
                        console.log($sessionStorage.volunteer.surname);
                        console.log($sessionStorage.volunteer.loginData.username);
                        $window.alert("Registration successful");
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