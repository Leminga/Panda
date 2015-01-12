angular.module('Panda')
    .controller('AdminOverviewCtrl', ['$window', '$location', 'DataService', function ($window, $location, DataService) {
        var self = this;
        self.adminEditVolunteer = "";
        self.adminDeleteVolunteer = "";

        DataService.get().then(function (response) {
            self.user = response.data.user;
            self.labels = response.data.labels;
            self.volunteers = response.data.volunteers;
            self.values = response.data.values;
        });

        self.adminEditVolunteer = function (id) {
            DataService.sendId(id).then(function (response) {
                $location.path("/overview");
            },function(){
                $location.path("/overview");
            })
        };

        self.adminDeleteVolunteer = function (id) {
            DataService.sendId(id).then(function (response) {
                $window.location.reload();
            },function(){
                $window.location.reload();
            })
        };
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