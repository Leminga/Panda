angular.module('Panda')
    .controller('CoreDataFormCtrl', ['CoreDataService', '$localStorage', '$sessionStorage',
        function (CoreDataService, $localStorage, $sessionStorage) {
            var self = this;

            self.getData = function () {
                self.user.personalData.prename = $sessionStorage.volunteer.prename;
                self.user.personalData.surname = $sessionStorage.volunteer.surname;
                self.user.contactData.email = $sessionStorage.volunteer.loginData.username;
            };

            self.savePersonalData = function () {
                $sessionStorage.volunteer.prename = self.user.personalData.prename;
                $sessionStorage.volunteer.surname = self.user.personalData.surname;
                //CoreDataService.savePersonalData(self.user.personalData);
            };

            self.saveEmergencyContacts = function () {
                CoreDataService.saveEmergencyContacts(self.user.emergencyContacts);
            };

            self.saveContactData = function () {
                $sessionStorage.volunteer.loginData.username = self.user.contactData.email;
                //CoreDataService.saveContactData(self.user.contactData);
            };

            self.saveSizes = function () {
                CoreDataService.saveSizes(self.user.sizes);
            };

            self.saveAll = function () {
                CoreDataService.saveAll(self.user);
            };

        }]);
