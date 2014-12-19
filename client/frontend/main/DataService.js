angular.module('Panda')
    .service('DataService', ['$http', function ($http) {
        return {
            save: function (user) {
                return $http.patch("/saveUser", user);
            },

            get: function (token) {
                return $http.get("/getUser",{
                  params:{token: token}
                });
            }
        };
    }]);