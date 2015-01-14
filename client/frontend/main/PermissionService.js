angular.module('Panda')
    .service('PermissionService', ['$window',function ($window) {

        return {
            setPermission: function (permission) {
                $window.sessionStorage.setItem("permission", permission);
            },

            getPermission: function(){
                return $window.sessionStorage.getItem('permission');
            }
        }
    }]);



