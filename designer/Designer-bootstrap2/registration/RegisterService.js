angular.module('Panda')
    .factory('RegisterService', ['$http', function ($http) {
        return {
            register:function(user){
                return $http.post("/register",user);
            }
        };
    }]);