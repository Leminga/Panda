angular.module('ForgottenPassword', [])
    .controller('ForgottenPasswordCtrl', ['ForgottenPasswordService', function (ForgottenPasswordService) {
        var self = this;

        self.sendForgottenPasswordRequest = function () {
            ForgottenPasswordService.forgottenPassword(self.email);
            /*
             .success(function () {
             self.status = "Request was sent successfully. You should receive an E-Mail within 10 minutes"

             }).error(function (error) {
             self.status = "There was an error." + error.message;
             })
             */
        }
    }]);