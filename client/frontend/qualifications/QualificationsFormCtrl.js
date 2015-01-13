angular.module('Panda')
    .controller('QualificationsFormCtrl', ['DataService', '$window',
        function (DataService, $window) {
            var self = this;

            DataService.get().then(function (response) {
                self.user = response.data.user;
                self.description = response.data.description;
                self.labels = response.data.labels;
                self.description = response.data.description;
                self.values = response.data.values;
                self.test = {
                    currentWork: [
                        {"description": "freelance", "value": "1"},
                        {"description": "student", "value": "100"}
                    ]
                };
            });

            self.saveData = function (user) {
                DataService.save(user);
            };

            // Check whether the language is "Other" or not. If so, then don't display the additional fields.
            self.languageCheck = function(language){
                if(language == 'other' || language == null){
                    return false;
                }else{
                    return true;
                }
            }

        }]);
