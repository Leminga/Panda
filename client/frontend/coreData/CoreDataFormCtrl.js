angular.module('Panda')
    .controller('CoreDataFormCtrl', ['DataService',
        function (DataService) {
            var self = this;

            DataService.get().then(function (response) {
                    self.tmp_picture = "";
                    self.user = response.data.user;
                    self.labels = response.data.labels;
                    self.description = response.data.description;
                    self.values = response.data.values;
                    self.test = {
                        gender: [
                            {"description": "Male", "value": "1"},
                            {"description": "Female", "value": "100"}
                        ]
                    };

                }
            )
            ;


            self.saveData = function (user) {
                DataService.save(user);
            };


        }
    ])
;
