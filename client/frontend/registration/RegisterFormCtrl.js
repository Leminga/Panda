// This controller handles the registration of a user
angular.module('Panda')
    .controller('RegisterFormCtrl', ['RegisterService', 'GetRegistrationService', '$window', '$location','FormGendersService',
        function (RegisterService, GetRegistrationService, $window,$location,FormGendersService) {
            var self = this;
            self.receivedRegistrationData = {};

// This method sends the input data to the controller and receives information on the success or failure of the
// registration.

            self.register = function () {
                RegisterService.register(self.user).then(function (response) {
                        // TODO: React to the controllers messages, don't leave them hardcoded.
                        $window.alert("Registration successful");
                        $location.path("/");
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

            self.genders = FormGendersService.getGenders();



            self.dateOfBirthPicker = {
                dateOptions : {
                    formatYear: 'yyyy',
                    startingDay: 1
                    // initDate:'registerCtrl.dateOfBirthPicker.initDate'//moment(new Date()).subtract(25, 'years').format('dd/MM/yyyy') // today minus 25 years
                },
                opened : false,
                open : function($event) {
                    $event.preventDefault();
                    $event.stopPropagation();

                    self.dateOfBirthPicker.opened = true;
                },
                format : 'dd/MM/yyyy',
                minDate : '01/01/1900',
                maxDate : new Date().getTime() // today
               // initDate: new Date()
            };
            self.dateOfBirth = null;
        }]);