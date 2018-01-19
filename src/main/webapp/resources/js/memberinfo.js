var app = angular.module("Memberinfo", []);
app.controller("memberinfo", function($rootScope, $scope, $routeParams, $http){
	
	$rootScope.loginCheck();
	
	$scope.memBer = function(){
	 var data = [];
		$.ajax({
		  type:"post",
		  url:"memberinfo",
	  }).done(function(d){
		  var result = JSON.parse(d);
		  data = result.list;
		  console.log("jsp :", data);
		  for(var i=0; i<data.length;i++){
			  var tag=
				  '<div class="memin-middle listbigbox1">'+
		              '<div class="memin-middle-no1">'+data[i].id+'</div>'+
		              '<div class="memin-middle-title1">'+data[i].email+'</div>'+
		              '<div class="memin-middle-id1">'+data[i].pw+'</div>'+
		              '<div class="memin-middle-btn1"><button id="delbtn" class="delbtn type="button">삭제</button></div>'+
	              '</div>';
			  $(".listin").append(tag);
		  }
		  $(".notice-middle-btn1 .delbtn").off().on("click",function(){
              var index = $(".notice-middle-btn1 .delbtn").index(this);
               console.log("jsp : " +index);
             console.log("index"+data[index].id);
             
             
          })

	  })
	}
	$scope.memBer();
});