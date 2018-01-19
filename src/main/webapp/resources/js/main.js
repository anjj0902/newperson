var app = angular.module("Main", []);
app.controller("main", function($rootScope, $scope, $routeParams, $http){
	$rootScope.loginCheck();
});