angular.module('Panda')
    .controller('CoreDataFormCtrl', ['DataService', '$window',
        function (DataService, $window) {
            var self = this;
            var token = $window.sessionStorage.getItem("token");

            self.saveData = function () {
                DataService.save(self.user);
            };

            self.getData = function () {
                DataService.get(token).then(function(response){
                    self.user = response.data;
                });
            };

        }]);
