'use strict';

// declare modules
angular.module('Authentication', []);
angular.module('Registration', []);
angular.module('Home', []);
angular.module('Customers', ['kendo.directives', 'ngResource']);

angular.module('WorkApp', [
    'Registration',
    'Authentication',
    'Home',
	'Customers',
    'ngRoute',
    'ngCookies',
	//'dynamicMenu'
])
 
.config(['$routeProvider','$locationProvider', function ($routeProvider, $locationProvider) {

    $routeProvider
        .when('/login', {
            templateUrl: 'modules/authentication/views/login.html',
            controller: 'LoginController',
            hideMenus: true
        })

         .when('/', {
             controller: 'HomeController',
             templateUrl: 'modules/home/views/home.html'
         })
		
		.when('/IndexCustomers', {
			templateUrl: 'modules/customers/views/Index.html',
			controller : 'CustomersController'
		})
		

 
        .otherwise({ redirectTo: '/' });
		
		 $locationProvider.html5Mode(true).hashPrefix('');
}])
 
.run(['$rootScope', '$location', '$cookieStore', '$http',
    function ($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line			
        }
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
             //redirect to login page if not logged in
             if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
                 $location.path('/login');
             }
        });
    }]);
	