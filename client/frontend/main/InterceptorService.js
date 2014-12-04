angular.module('Panda')
.factory('InterceptorService', ['$q','$window','$location', function($q,$window,$location) {
    return {
        request: function(config) {
            console.log('Request made with ', config);
            config.headers['X-AUTH-TOKEN'] = $window.sessionStorage.getItem("token");
            if(config.headers['X-AUTH-TOKEN'] === null ){
                $location.path("/");
            }
            return config;
            // If an error, or not allowed, or my custom condition
            // return $q.reject('Not allowed');
        },
        requestError: function(rejection) {
            console.log('Request error due to ', rejection);
            // Continue to ensure that the next promise chain
            // sees an error
            return $q.reject(rejection);
            // Or handled successfully?
            // return someValue;
        },
        response: function(response) {
            console.log('Response from server', response);
            // Return a promise
            return response || $q.when(response);
        },
        responseError: function(rejection) {
            console.log('Error in response ', rejection);
            // Continue to ensure that the next promise chain
            // sees an error
            // Can check auth status code here if need to
            if (rejection.status === 403) {
            //   Show a login dialog
            //   return a value to tell controllers it has
            // been handled
            }
            // Or return a rejection to continue the
            // promise failure chain
            return $q.reject(rejection);
        }
    };
}])
    .config(['$httpProvider', function($httpProvider) {
        $httpProvider.interceptors.push('InterceptorService');
    }]);