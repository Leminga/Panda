angular.module('Panda')
    .controller('QualificationsFormCtrl', ['DataService', '$window',
        function (DataService, $window) {
            var self = this;

            DataService.get().then(function (response) {
                self.user = response.data;
            });

            self.saveData = function (user) {
                DataService.save(user);
            };

            self.languageCheck = function(language){
                if(language == 'other' || language == null){
                    return false;
                }else{
                    return true;
                }
            }

        }]);
