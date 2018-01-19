var app = angular.module("Menuregister", []);
app.controller("menuregister", function($rootScope, $scope, $routeParams, $http){
	$scope.no=$routeParams.parammenu;
	console.log("param : scope: ", $scope.no);
	var no = $scope.no;
	console.log("param : var :" ,no);
	$rootScope.loginCheck();
	
	$scope.menuregister = function(){
		if(no > 1){
			$("div[name=submenu]").hide();
		}else if(no < 2){
			$("div[name=submenu]").show();
		}
		
		if(no>2){
			$(".input1").hide();
		}else{
			$(".input1").show();
		}
			
			
		
		$("input[name=menu_type]").val(no);  
		$("#addBtn").on("click", function(){
//              alert("gg")
              $("form").submit();
           });
		$("#cancelbtn").click(function(){
			window.history.back();
		});
	}
	$scope.menuregister();
});