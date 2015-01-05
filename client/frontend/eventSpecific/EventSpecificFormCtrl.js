angular.module('Panda')
    .controller('EventSpecificFormCtrl', ['DataService',
        function (DataService) {
            var self = this;

            DataService.get().then(function (response) {
                self.user = response.data;
            });

            self.saveData = function (user) {
               /* if (user.profilePicture != null) {
                    user.profilePicture = JSON.encodeBase64(user.profilePicture);
                }
                if (user.passportPicture != null) {
                    user.passportPicture = JSON.encodeBase64(user.passportPicture);
                }*/
                DataService.save(user);
            };


        }]);
