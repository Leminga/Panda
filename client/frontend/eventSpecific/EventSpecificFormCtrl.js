// Controller for eventSpecific.html
angular.module('Panda')
    .controller('EventSpecificFormCtrl', ['DataService',
        function (DataService) {
            var self = this;

            DataService.get().then(function (response) {
                self.user = response.data;
            });

            self.saveData = function (user) {
                DataService.save(user);
            };


        }]);
