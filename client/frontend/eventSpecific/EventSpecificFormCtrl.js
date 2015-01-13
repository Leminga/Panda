// Controller for eventSpecific.html
angular.module('Panda')
    .controller('EventSpecificFormCtrl', ['DataService',
        function (DataService) {
            var self = this;

            DataService.get().then(function (response) {
                self.user = response.data.user;
                self.description = response.data.description;
                self.labels = response.data.labels;
                self.description = response.data.description;
                self.values = response.data.values;

            });

            self.saveData = function (user) {
                DataService.save(user);
            };


        }]);
