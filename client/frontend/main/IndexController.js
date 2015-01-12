angular.module('Panda')
    .controller('IndexController', ['DataService', '$window','$location', function (DataService, $window, $location) {
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
        };

        // Logout function that clears the local and session storage (= Cookies) from the user and
// then he is being rerouted to the login page

        self.logout = function () {
            sessionStorage.clear();
            localStorage.clear();
            $location.path("/");
        };
    }]);