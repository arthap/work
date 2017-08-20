/**
 * Created by asargsyan on 2/3/17.
 */
'use strict';
var services = angular.module('Home');
services.factory('CrudFactory',
    ['Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
        function (Base64, $http, $cookieStore, $rootScope, $timeout) {

// services.factory('CrudFactory', function () {

    var service = {};

    service.EditUser = function (userId,username, password, callback) {


        $http.post('http://localhost:3000/editUsers/', { id:userId,username: username, password: password })
            .success(function (response) {
                if(!response.success) {
                    response.message = 'Username or password is incorrect';
                }
                callback(response);
            });


    };
            service.GetAllUsers = function (callback) {
                $http.get('http://localhost:3000/customers/')
                    .success(function (data, status, headers, config) {
                        $scope.userData = data;
                    })
                    .error(function (data, status, header, config) {
                        $scope.ResponseDetails = "Data: " + data

                    });
            }
    service.DeleteUser = function (userId) {
        $http.post('http://localhost:3000/deleteUsers/', { id:userId })
            .success(function (response) {
                if(!response.success) {
                    response.message = 'Username or password is incorrect';
                }
                callback(response);
            });

    };



    service.CreateNewUser = function (user, callback) {


        $http.post('http://localhost:3000/customers/', {name: user.name, address: user.address,status:"true", phone: user.phone,email:user.email})
            .success(function (response) {
                if (!response.success) {
                    response.message = 'Username or password is incorrect';
                }
                callback(response);
            });
    }

        return service;
}]);
