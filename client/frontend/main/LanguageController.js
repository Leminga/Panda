angular.module('Panda')
    .controller('LanguageController', ['DataService', '$window', function (DataService, $window) {
        var self = this;

        self.changeLanguage = function () {
            if (self.language == 'D') {
                self.language = 'E';
            } else if (self.language = 'E') {
                self.language = 'D'
            }

            DataService.changeLanguage(self.language).then(function (response) {
                $window.location.reload();
            }, function () {
                console.log("Reload");
                $window.location.reload();
            });
        }
    }]);
