// The LoginFormController handles the login and authentication of the user.
angular.module('Panda')
    .controller('LoginFormCtrl', ['LoginService', '$window', '$location', function (LoginService, $window, $location) {
        var self = this;
        // This sends the Login to the controller, where it is being checked, whether the user exists or not.
        // If the user does not exist, then he receives an Error Message (TBD)
        // if-selection: is user volunteer ('/overview') or admin ('/adminOverview')?
        self.sendLogin = function () {
            LoginService.login(self.user).then(
                    function (response) { // success function
                    $window.sessionStorage.setItem("token", response.data.authToken);
                    $location.path('/overview')
                }, function (response) {  // error function
                    $window.alert(response.data);
                });
        };
    }]);
