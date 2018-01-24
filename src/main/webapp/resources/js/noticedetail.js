var app = angular.module("Noticedetail", []);
app.controller("noticedetail", function($rootScope, $scope, $routeParams, $http){
	console.log("params :",$routeParams.param);
	$rootScope.loginCheck();
	$scope.no = $routeParams.param;
	var no = $scope.no;
	console.log("newsNo :",no);
	$scope.noticeupdate = function(){
		location.href="#!/noticeregister/"+$scope.no;
	}
	$scope.cusvoicedetail = function(){
		  
		$.ajax({
          	url:"newsDetail",
          	data:{"no" : no}
          }).done(function(d){
          	var result = JSON.parse(d);
          	dt=result.data;
//          	console("jsp dt:",dt);
          	listHtml();
           	console.log(dt.id);
          });
		
          function listHtml(){
          	var contents = dt.contents
          	$(".detail-content1").html(contents);
          	
          	var title= dt.title
          	$(".detail-title-title").html(title);
          	
          	var id = dt.id
          	$(".detail-title-id").html(id);
          	
          
          }
//          $("#noticeup").off().on("click",function(){
//        	  console.log("ddd");
//            	location.href="#!/noticeregister/"+$scope.no;
//            });
          $(".button2").click(function(){
          	location.href="#!/notice";
//        	  alert("gg");
//        	  window.history.back();
          });
		
	}
	$scope.cusvoicedetail();
});