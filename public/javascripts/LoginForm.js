angular.module('Login',[])
    .controller('LoginFormCtrl', ['LoginService', function (LoginService) {
    var self = this;

        self.sendLogin = function() {
            LoginService.login(self.user);
        };

    }]);
