angular.module('Panda')
    .service('PermissionService', ['$rootScope',function ($rootScope) {
        return {
            setPermission: function (permission) {
                $rootScope.GLOBALPERMISSION = permission;
            },

            getPermission: function(){
                return $rootScope.GLOBALPERMISSION;
            }
        }
    }]);



