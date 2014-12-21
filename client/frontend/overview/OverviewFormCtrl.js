// This controller handles the overview form, which is used for viewing user-related data on a single page.
angular.module('Panda')
    .controller('OverviewFormCtrl', ['$window', '$location','DataService', function ($window, $location, DataService) {
        var self = this;

        DataService.get().then(function (response) {
            self.user = response.data;
        });


        // Logout function that clears the local and session storage (= Cookies) from the user and
        // then he is being rerouted to the login page
        self.logout = function (config) {
            sessionStorage.clear();
            localStorage.clear();
            $location.path("/");
        }

    }])
;

