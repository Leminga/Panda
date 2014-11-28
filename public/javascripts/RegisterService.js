angular.module('Register')
    .factory('RegisterService', ['$http', function ($http) {
        return {
            register:function(user){
                $http.put("/register",user);
            }
        };
    }]);