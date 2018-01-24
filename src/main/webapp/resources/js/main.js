var app = angular.module("Main", []);
app.controller("main", function($rootScope, $scope, $routeParams, $http){
	$rootScope.loginCheck();
	
	$scope.mainLogo = function(){
		console.log("mainLogo");
	}
	
	$scope.data = function(){
		   $http.post("prenotice")
	         .then(function(result){
	        	 $scope.data = result.data.list;
	        	 console.log("scope",$scope.data);
	        	 $scope.previewnoti = [];
	        	 for(var i = 0; i < $scope.data; i++){
	        		 $scope.previewnoti[i] = i;
	        	 }
	      });
	};
	$scope.data();
	
	$scope.noticelink= function(){
		location.href = "#!/notice";
	}
	
	$scope.cusvoicelink = function(){
		location.href = "#!/cusvoice";
	}
	
	$scope.data1 = function(){
		   $http.post("precusvoice")
	         .then(function(result){
	        	 $scope.data1 = result.data.list;
	        	 console.log("scope1111:",$scope.data1);
	        	 $scope.previewcus = [];
	        	 for(var i = 0; i < $scope.data1; i++){
	        		 $scope.previewcus[i] = i;
	        	 }
	      });
	}
	$scope.data1();
});