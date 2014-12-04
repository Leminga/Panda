angular.module('Panda')
    .controller('LoginFormCtrl', ['LoginService','$window', function (LoginService,$window) {
        var self = this;
        var token = undefined;

        self.sendLogin = function () {
            LoginService.login(self.user).then(function(response){
                console.log(response);
                $window.sessionStorage.setItem("token");
            });
        };

        /*.
         success(function (ö) {
         self.status = "Login successful"

         }).error(function (error) {
         self.status = "There was an error." + error.message;
         });
         */


    }]);
