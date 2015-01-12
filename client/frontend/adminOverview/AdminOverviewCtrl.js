angular.module('Panda')
    .controller('AdminOverviewCtrl', ['$window', '$location','DataService', function ($window, $location, DataService) {
        var self = this;

       self.adminEditVolunteer = function () {
            $location.path( "#/overview" );

        };


        DataService.get().then(function (response) {
            self.user = response.data.user;
            self.labels = response.data.labels;
            self.volunteers = response.data.volunteers;
            self.values = response.data.values;
        });

        /*DataService.getAll().then(function(response){
         self.volunteer = response.data;
         })*/

        // Logout function that clears the local and session storage (= Cookies) from the user and
        // then he is being rerouted to the login page
        self.logout = function (config) {
            sessionStorage.clear();
            localStorage.clear();
            $location.path("/");
        }

    }])
;