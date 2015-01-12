// This controller handles the overview form, which is used for viewing user-related data on a single page.
angular.module('Panda')
    .controller('OverviewFormCtrl', ['$window', '$location','DataService', function ($window, $location, DataService) {
        var self = this;


        DataService.get().then(function (response) {
            self.labels = response.data.labels;
            self.user = response.data.user;
            self.values = response.data.values;
            self.volunteers = response.data.volunteers;

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
        },

        self.eventCheck = function (event) {
            if(event == null){
                return false;
            }else{
                return true;
            }
        }

    }])
;

