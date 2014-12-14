angular.module('Panda')
    .controller('CoreDataFormCtrl', ['CoreDataService', function (CoreDataService) {
            var self = this;

        self.savePersonalData = function(){
            CoreDataService.savePersonalData(self.user.personalData)
        };
        self.saveEmergencyContacts = function(){
            CoreDataService.saveEmergencyContacts(self.user.emergencyContacts)
        };

        self.saveContactData = function(){
            CoreDataService.saveContactData(self.user.contactData)
        };

        self.saveSizes = function(){
            CoreDataService.saveSizes(self.user.sizes)
        };

        self.saveAll = function(){
            CoreDataService.saveAll(self.user)
        };

    }]);
