var app = angular.module("Direction", []);
app.controller("direction", function($rootScope, $scope, $routeParams, $http){
	
	$rootScope.loginCheck();
	
	$scope.loadMap = function(){
		new daum.roughmap.Lander({
            "timestamp" : "1514442071684",
            "key" : "m57i",
            "mapHeight" : "300"
            }).render();
	}
	$scope.loadMap();
});