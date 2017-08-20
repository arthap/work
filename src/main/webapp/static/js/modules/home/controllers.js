'use strict';

angular.module('Home')
    .controller('HomeController', ['$scope','CrudFactory','$http','$q', '$location','$routeParams' ,'$cookieStore','$rootScope','UserService','UserDataService', function ($scope,CrudFactory,$http,$q, $location,$routeParams, $cookieStore,$rootScope,UserService,UserDataService,MySearchTemp) {
$scope.user={};
    // // callback for ng-click 'editUser':
    // $scope.editUser = function (userId) {
    //     CrudFactory.EditUser($scope.username, $scope.password, function(response) {
    //         if(response.success) {
    //
    //             $location.path('/');
    //         } else {
    //             $scope.error = response.message;
    //             $scope.dataLoading = false;
    //         }
    //     });
    //
    // };
    //     $scope.getAllUsers = function () {
    //         $http.get('http://localhost:3000/customers/')
    //             .success(function (data, status, headers, config) {
    //                 $scope.userData = data;
    //             })
    //             .error(function (data, status, header, config) {
    //                 $scope.ResponseDetails = "Data: " + data
    //
    //             });
    //
    //     };
    //     $scope.getAllUsers();
    //
    // // callback for ng-click 'deleteUser':
    // $scope.deleteUser = function (userId) {
    //     CrudFactory.DeleteUser(userId,function () {
    //         if(response.success) {
    //
    //             $location.path('/');
    //         } else {
    //             $scope.error = response.message;
    //             $scope.dataLoading = false;
    //         }
    //     })
    //
    //
    //
    //
    // };
    //
    // // callback for ng-click 'createUser':
    // $scope.createNewUser = function (user) {
    //     CrudFactory.CreateNewUser(user,function () {
    //         if(response.success) {
    //
    //             $location.path('/');
    //         } else {
    //             $scope.error = response.message;
    //             $scope.dataLoading = false;
    //         }
    //     })
    //
    // }
    //


        var vm=this;
        $scope.mainPage=true;
        $scope.totalItems=0;
        $scope.scroleIndex=0;
        $scope.startList;
        $scope.stopLoadingData ;
        $scope.scrollDataStop=false;
        $scope.editPermission=false;
        $scope.manufactShow=true;
        vm.logOut=false;
        var paPromise = $q.defer()
        $scope.letterLimit = 30;

        $rootScope.$on('$routeChangeStart', function (event, next, current) {
            if ($location.path() != "/") {
                $rootScope.hideit = true;
            }else{   $rootScope.hideit = false;}

        });
        $(window).on('hashchange', function() {

            if($location.path()==="/"){

                $scope.mainPage=true;
            }
            else{
                if($location.path()==="/signIn"){
                    if(vm.logOut===true){
                        $scope.userData=undefined;
                        vm.userData=undefined;
                        vm.userName=undefined;
                        $scope.userName=undefined;
                        vm.logOut=false;
                        $location.path('/');
                    }


                }
                $scope.mainPage=false;}

            $rootScope.userData = $cookieStore.get('userData') || {};
            if ($rootScope.userData.currentUser!==undefined) {

                var userPermission=$rootScope.userData.currentUser[0].USER_TYPE;

            }
            if(userPermission==="1") {
                if ($location.path() === "/userPage") {
                    $location.path('/administrationUserPage');
                    // $scope.manufactShow=false;
                }
            }
            // if ($location.path().indexOf( "/addEditAdministrationProduct/")>=0) {$scope.editPermission=true;
            // }
            // if ($location.path() === "/addProduct") {if(userPermission==="1") {$scope.editPermission=false;}}

        });


        $scope.logOut=function () {
            vm.logOut=true;

        }


        $scope.mainPage=$rootScope.locRoot;
        if($cookieStore.get('globals')!==undefined){
            vm.userdata = $cookieStore.get('globals').currentUser;
        }
        // Product.query({productId: 'products'}, function (data) {
        // 	$scope.phones = data;
        // });
        $scope.verify=function () {
            $rootScope.userData = $cookieStore.get('userData') || {};
            if ($rootScope.userData.currentUser!==undefined) {
                var userId = $rootScope.userData.currentUser[0].ID;


            }
            if (userId === undefined) {
                $location.path('/signIn');
            }else{
                $location.path('/userPage');}


        }
        $scope.mainPageDisable=function () {
            $scope.mainPage=false;
            $scope.scrollDataStop=false;

        }
        $scope.mainPageEnable=function () {
            $scope.mainPage=true;
            $scope.scrollDataStop=true;

        }

        // $scope.singshow=function () {
        // 	if($location.path()==="/singIn"){
        // 	$scope.singShow=false;}
        // 	else{$scope.singShow=true;}
        //
        //
        // }
        $scope.reloadFn=function () {

            // location.reload();


        }


        if($scope.searchingText===undefined) {$scope.searchingText = "";}
        // $scope.searchingText = "";
        $scope.categoryLVL1=[];
        UserService.GetCategoryLvL1()
            .then(function (response) {
                if (response.length>0) {
                    response.forEach(function(data) {

                        $scope.categoryLVL1.push(data) ;


                    }, this);;
                }
                console.log($scope.categoryLVL1);
            });

        // $http.post('/productCategoriAdd')
        // 	.then(handleSuccess, handleError('Error getting product by id'));

        $scope.catId;

        $scope.searching = function(searchingText,newPageNumber,searcheIndex,categoryId){


            if(searcheIndex===1){
                $scope.scrollDataStop=true;

            }
            if(searcheIndex===0){
                $scope.scrollDataStop=false;
                $scope.stopLoadingData=false;

            }

            if(categoryId===undefined){$scope.catId="*";
            }else {$scope.catId=categoryId;}
            if(searcheIndex===0){
                $scope.getProductList=[];
                $scope.startList=0;

                $scope.totalItems;
            }
            // if(newPageNumber==undefined){newPageNumber=1;}
            // $scope.pageNumber=newPageNumber;
            if(newPageNumber===0){	$location.path('/');}
            $scope.errorResult=""
            $scope.product={};
            UserService.GetProductList(searchingText,newPageNumber,$scope.catId)
                .then(function (user) {


                    if (user.data.product.length>0) {
                        $scope.totalItems=user.data.total;

                        if(searcheIndex===0){
                            $scope.getProductList=user.data.product;
                            $scope.stopLoadingData=false;


                            console.log($scope.getProductList);}
                        else {

                            user.data.product.forEach(function(data) {
                                // if($scope.index===)
                                $scope.getProductList.push(data) ;
                                console.log($scope.getProductList);
                                $scope.scroleIndex=0;


                            }, this);
                            paPromise.resolve(user)
                            $scope.loading = false;

                        }
                        if($scope.getProductList.length === $scope.totalItems){
                            $scope.stopLoadingData = true;
                            $scope.scrollDataStop=true;}
                        else{
                            $scope.stopLoadingData = false;
                            $scope.scrollDataStop=false;
                        }
                        // $scope.getProductList = user.data;

                        $scope.loading = false;
                    } else {
                        $scope.getProductList=[];
                        $scope.loading = false;
                        $scope.errorResult="Result Not Found!"

                    }


                    if($scope.startList===undefined){$scope.startList = 0;}
                    $scope.startList += 1;
                    console.log($scope.startList);
                });

        }



        $scope.show_more = function (scrollDataStp) {


            if($scope.scrollDataStop){return;}
            else{
                $scope.scroleIndex++;
                if($scope.scroleIndex===6 ){
                    // $scope.loading = true;
                    if (!$scope.stopLoadingData) {
                        $scope.searching($scope.searchingText,$scope.startList,1,$scope.catId);

                        $scope.scroleIndex=0;
                    }
                }


            }

        };
        UserDataService.setUserData();
        $scope.userData={};
        $scope.userData=UserDataService.getUserData();

        // if($cookieStore.get('globals').isObject){
        //     UserModelService.setUser($cookieStore.get('globals').currentUser);
        //     $scope.userData= $cookieStore.get('globals').currentUser;
        $scope.avatarShow=false;
        if($scope.userData!==undefined){
            // $scope.userCurrentRate=userData[0].CURRENT_RATE;
            $scope.userName =$scope.userData[0].USERNAME;
            $scope.userAvatar =$scope.userData[0].AVATAR;
            if($scope.userAvatar!==null){
                if($scope.userAvatar.indexOf(".jpg") ||$scope.userAvatar.indexOf(".png")){$scope.avatarShow=true;}}


            console.log($scope.userData[0].USERNAME);
            console.log($scope.userData[0].CURRENT_RATE);
        }
        $scope.singout=function () {
            $scope.singOut=!$scope.singOut;
        }




    }]);

