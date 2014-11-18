angular.module('TabsApp')
    .factory('LoginService', ['$http', function ($http) {
        return {
            login:function(user){
                return $http.post("/login",user);
            }
        };
    }]);