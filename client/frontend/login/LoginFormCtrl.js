angular.module('Panda')
    .controller('LoginFormCtrl', ['LoginService', '$window','$location', function (LoginService, $window, $location) {
        var self = this;

        self.sendLogin = function () {
            LoginService.login(self.user).then(
                function (response) { // success function
                    $window.sessionStorage.setItem("token", response.data.authToken);
                    console.log($window.sessionStorage.getItem("token"));
                    $location.path('/overview')
                }, function (response) {  // error function
                    console.log("Not authorized");
                });
        };
    }]);
