// This controller handles the overview form, which is used for viewing user-related data on a single page.
angular.module('Panda')
    .controller('OverviewFormCtrl', ['$window', '$location','DataService', function ($window, $location, DataService) {
        var self = this;



        DataService.get().then(function (response) {
            self.labels = response.data.labels;
            self.user = response.data.user;
            self.values = response.data.values;
            self.volunteers = response.data.volunteers;
            self.description = response.data.description;
            self.test ={
                event:[
                    {"description": "driver", "value": "1"},
                    {"description": "cook", "value": "23"}

                ]};

        });

        self.eventCheck = function (event) {
            if(event == null){
                return false;
            }else{
                return true;
            }
        }
    }])
;

