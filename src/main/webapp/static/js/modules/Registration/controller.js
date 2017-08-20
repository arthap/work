/**
 * Created by Hayarpi on 8/12/2017.
 */
/* Registration Controller */
angular.module('Registration')
    .controller('RegisterCtrl',[
    '$scope','$http', '$location', 'AuthenticationService','FlashService','UserService',
    function($scope, $http, $location, AuthenticationService, FlashService,UserService) {
        $scope.confirmePassError=false;
        var vm = this;

        vm.register = register;

        function register() {
            vm.dataLoading = true;
            UserService.Create(vm.user)
                .then(function (response) {
                    if (response.success) {
                        FlashService.Success('Registration successful', true);
                        $location.path('/signIn');
                    } else {
                        $scope.errorMessage=response.message;
                        FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                });
        }
        $scope.cheakPassword=function () {
            if(vm.user.CONFIRMEPASSWORD!==vm.user.PASSWORD){
                $scope.confirmePassError=true;}
            else{$scope.confirmePassError=false;}
        }
    }

]);