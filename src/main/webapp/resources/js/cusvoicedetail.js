var app = angular.module("Cusvoicedetail", []);
app.controller("cusvoicedetail", function($rootScope, $scope, $routeParams, $http){
	console.log("params :",$routeParams.param);
	$scope.noupdateFlag = false;
	$rootScope.loginCheck();
	$scope.no = $routeParams.param;
	var no = $scope.no;
//	console.log("newsNo :",newsNo);
	$scope.cusvoicedetail = function(){
		var noticeno = $rootScope.nodeteilid;
		console.log("app js에서 갖어온 :",noticeno);
		  $.ajax({
          	url:"cusvoiceDetail",
          	data:{"no" : no}
          }).done(function(d){
          	var result = JSON.parse(d);
          	dt=result.data;
          	listHtml();
          	console.log("전체:",dt);
           	console.log("로그인한 아이디:",result.id);
           	console.log("게시판아이다:",result.data.id);
           	$scope.dtno = dt.id;
//           	console.log("1212:",$rootScope.nodeteilid);
//         	if(dt.id!= noticeno){
//           		$(".cusvoupda").hide();
//           	}
//           	if(dt.id==noticeno){
//           		$(".cusvoupda").show();
//           	}
           	console.log($scope.dtno, noticeno);
           	if(result.id == result.data.id){
           		$(".cusvoupda").show();
           	}else{
           		$(".cusvoupda").hide();
           	}
           	
           	
          });
		  console.log("app js에서 갖어온:",$rootScope.nodeteilid);
//		  $rootScope.nodeteilid();
//		  $rootScope.nodetail();
//		  console.log("dd",$rootScope.nodeteilid);
          function listHtml(){
          	var contents = dt.contents
          	console.log("jsp contents:",contents);
          	$(".detail-content1").html(contents);
          	
          	var title= dt.title
          	$(".detail-title-title").html(title);
          	
          	var id = dt.id
          	$(".detail-title-id").html(id);
          	
          
          }
          $(".cusvoupda").off().on("click",function(){
          	location.href="#!/cusvoiceregister/"+$scope.no;
          });
          $(".button2").click(function(){
          	location.href="#!/cusvoice";
          });
		
	}
	$scope.cusvoicedetail();
});