// This controller handles the overview form, which is used for viewing user-related data on a single page.
angular.module('Panda')
    .controller('OverviewFormCtrl', ['$window', '$location', function ($window, $location) {
        // Check whether the user is logged in or not
        if ($window.sessionStorage.getItem("token") === null) {
            $location.path("/");
        }

        var self = this;

        // Logout function that clears the local and session storage (= Cookies) from the user and
        // then he is being rerouted to the login page
        self.logout = function(config){
            sessionStorage.clear();
            localStorage.clear();
            $location.path("/")
        }

    }]);

