angular.module('Panda')
    .controller('CoreDataFormCtrl', ['DataService',
        function (DataService) {
            var self = this;

            DataService.get().then(function (response) {
                    self.tmp_picture = "";
                    self.profilePicture = response.data.picture;
                    self.user = JSON.parse(response.data.volunteer);
                    self.labels = response.data.labels;
                    self.description = response.data.description;
                    self.values = response.data.values;
            });

            DataService.getDummyPicture().then(function (response) {
                self.test.picture =  response.data.picture;
            });

            self.sendDummyPicture = function () {
                DataService.sendDummyPicture(self.test).then(function(response){
                    {console.log("Picture sent")}
                })
            };

            self.saveData = function (user) {
                DataService.save(user);
            };


        }
    ])
;
