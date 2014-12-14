angular.module('Panda')
    .factory('CoreDataService', ['$http', function ($http) {
        return {
            savePersonalData: function (personalData) {
                return $http.post("/personalData", personalData)
            },

            saveContactData: function (contactData) {
                return $http.post("/contactData", contactData);
            },

            saveEmergencyContacts: function (emergencyContacts) {
                return $http.post("/emergencyData", emergencyContacts);
            },

            saveSizes: function (sizes) {
                return $http.post("/sizes", sizes);
            },

            saveAll:function(user){
                return $http.post("/all",user);
            }
        };

    }])
;