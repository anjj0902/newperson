var app = angular.module("Cusvoicedetail", []);
app.controller("cusvoicedetail", function($rootScope, $scope, $routeParams, $http){
	console.log("params :",$routeParams.param);
	$rootScope.loginCheck();
	$scope.no = $routeParams.param;
	var no = $scope.no;
//	console.log("newsNo :",newsNo);
	$scope.cusvoicedetail = function(){
		  $.ajax({
          	url:"cusvoiceDetail",
          	data:{"no" : no}
          }).done(function(d){
          	var result = JSON.parse(d);
          	dt=result.data;
          	listHtml();
           	console.log(dt.id);
          });
          function listHtml(){
          	var contents = dt.contents
          	console.log("jsp contents:",contents);
          	$(".detail-content1").html(contents);
          	
          	var title= dt.title
          	$(".detail-title-title").html(title);
          	
          	var id = dt.id
          	$(".detail-title-id").html(id);
          	
          
          }
          $(".button1").off().on("click",function(){
          	location.href="#!/cusvoiceregister/"+$scope.no;
          });
          $(".button2").click(function(){
          	location.href="#!/cusvoice";
          });
		
	}
	$scope.cusvoicedetail();
});