var app = angular.module("Login", []);
app.controller("login", function($rootScope, $scope, $routeParams, $http){
	$rootScope.loginCheck();
	
	$scope.login = function() {
		$http.post("loginData","", {params : $scope.user}).then(function(result){
			console.log(result);
			if(result.data.stat == 1){
				location.href="/"
			}else{
				alert("입력하신 정보가 잘못되었습니다.");
				$scope.user.id = "";
				$scope.user.pw = "";
			}
		});
		
//		$.ajax({
//			type:"post",
//			url:"loginData",
//			data: $scope.user
//		}).done(function(result){
//			var data = JSON.parse(result);
//			console.log("결과 :" + data.stat)
//			if(data.stat == 1){
//				location.href="/"
//			}else{
//				alert("입력하신 정보가 잘못되었습니다.");
//				$scope.user.id = "";
//				$scope.user.pw = "";
//			}
//		});
	}
	
});