angular.module('Panda')
    .controller('AdminOverviewCtrl', ['$window', '$location', 'DataService', 'PermissionService', function ($window, $location, DataService, PermissionService) {
        var self = this;
        self.adminEditVolunteer = "";
        self.adminDeleteVolunteer = "";

        PermissionService.setPermission("admin");

        var load = function () {
            DataService.get().then(function (response) {
                self.user = response.data.user;
                self.labels = response.data.labels;
                self.volunteers = response.data.volunteers;
                self.values = response.data.values;
            });
        };

        load();


        self.exportDocument = function () {
            var blob = new Blob([document.getElementById('exportable').innerHTML], {
                type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
            });
            saveAs(blob, "Volunteers.xls");
        };

        self.adminEditVolunteer = function (id) {
            DataService.getVolunteerAdmin(id).then(function (response) {
                $location.path("/adminOverview");
            }, function () {
                $location.path("/adminOverview");
            })
        };

        self.adminDeleteVolunteer = function (id) {
            DataService.deleteVolunteerAdmin(id).then(function (response) {
                load();
            }, function () {
                load();
            })
        };
        /*DataService.getAll().then(function(response){
         self.volunteer = response.data;
         })*/

    }])
;