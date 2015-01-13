/**
 * Created by dabernigmichael on 12.01.15.
 */
angular.module('Panda')
    .factory('FormGendersService', [function () {
        return {
            getGenders:function(){
                // TODO: get data from server?
                return [
                    {"description": "Male", "value": "1"},
                    {"description": "Female", "value": "2"}
                ];
            }
        };
    }]);