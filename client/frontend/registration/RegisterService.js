angular.module('Panda')
    .factory('RegisterService', ['$http', function ($http) {
        return {
            register:function(user){
                $http.post("/register",user);
            }
        };
    }]);