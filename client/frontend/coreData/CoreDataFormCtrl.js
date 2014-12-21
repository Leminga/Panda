angular.module('Panda')
    .controller('CoreDataFormCtrl', ['DataService', '$window',
        function (DataService) {
            var self = this;

            DataService.get().then(function (response) {
                self.user = response.data;
            });

            self.saveData = function (user) {
                DataService.save(user);
            };


        }]);
