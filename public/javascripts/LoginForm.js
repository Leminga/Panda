angular.module('Login', [])
    .controller('LoginFormCtrl', ['LoginService', function (LoginService) {
        var self = this;

        self.sendLogin = function () {
            LoginService.login(self.user);
            /*.
             success(function () {
             self.status = "Login successful"

             }).error(function (error) {
             self.status = "There was an error." + error.message;
             });
             */
        };

    }]);
