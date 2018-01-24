var app = angular.module("Member", []);
app.controller("member", function($rootScope, $scope, $routeParams, $http){
	
	$rootScope.loginCheck();
	
	$scope.memberse = function(){
		  $http.post("cusmemberboard")
	         .then(function(result){
	        	 $scope.data = result.data.list;
	        	 console.log("scope12341234:",$scope.data);
	        	 $scope.cusmember = [];
	        	 for(var i = 0; i <  $scope.data; i++){
	        		 $scope.cusmember[i] = i; 
	        	 }
	      });
		
	}
	$scope.memberse();
	$scope.memBer = function(){
		
	}
	$scope.memBer();
});