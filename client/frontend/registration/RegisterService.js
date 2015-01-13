angular.module('Panda')
    .factory('RegisterService', ['$http', function ($http) {
        return {
            register:function(user){
                user.dateOfBirth = user.dateOfBirthHumanized.getTime();
                return $http.post("/register",user);
            }
        };
    }]);