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
                    self.test = {
                        gender: [
                            {"description": "Male", "value": "1"},
                            {"description": "Female", "value": "100"}
                        ],
                        nationalities:[
                            {"description": "Austria", "value":"1"},
                            {"description": "America","value":"2"}
                        ],

                        driversLicense: [
                            {"description": "Austria", "value":"0"},
                            {"description": "America","value":"1"}
                        ]
                    };
            });

            DataService.getDummyPicture().then(function (response) {
                self.picture =  response.data.picture;
            });

            self.sendDummyPicture = function () {
                DataService.sendDummyPicture(self.picture).then(function(response){
                    {console.log("Picture sent")}
                })
            };

            self.saveData = function (user) {
                DataService.save(user);
            };


        }
    ])
;
