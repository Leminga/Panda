// Service that is being used with the LoginFormCtrl.
angular.module('Panda')
    .factory('LoginService', ['$http', function ($http) {
        return {
            login: function (user) {
                return $http.post("/login", user);
            }
        };

    }]);