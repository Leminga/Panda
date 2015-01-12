angular.module('Panda')
    .controller('AdminOverviewCtrl', ['$window', '$location', 'DataService', function ($window, $location, DataService) {
        var self = this;
        self.adminEditVolunteer = "";
        self.adminDeleteVolunteer = "";

        var load = function(){DataService.get().then(function (response) {
            self.user = response.data.user;
            self.labels = response.data.labels;
            self.volunteers = response.data.volunteers;
            self.values = response.data.values;
        });};

        load();

        self.exportDocument = function() {
            var blob = new Blob([document.getElementById('exportable').innerHTML], {
                type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
            });
            saveAs(blob, "Volunteers.xls");
        };

        self.adminEditVolunteer = function (id) {
            DataService.getVolunteerAdmin(id).then(function (response) {
                $location.path("/overview");
            },function(){
                $location.path("/overview");
            })
        };

        self.adminDeleteVolunteer = function (id) {
            DataService.deleteVolunteerAdmin(id).then(function (response) {
                load();
            },function(){
                load();
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