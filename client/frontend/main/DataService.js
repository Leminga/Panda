// This is the main Data service. Due to the forms working the same, this service is integrated in many
// controllers.
angular.module('Panda')
    .service('DataService', ['$http', '$window', function ($http, $window) {
        return {
            save: function (user) {
                return $http.patch("/saveUser", user);
            },

            get: function () {
                // The token is given to the Backend controller right away.
                //return $http.post("/getUser", $window.sessionStorage.getItem("token"));
                return $http.get("/getUser");
            }
        }
    }]);

