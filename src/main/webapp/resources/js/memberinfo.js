var app = angular.module("Memberinfo", []);
app.controller("memberinfo", function($rootScope, $scope, $routeParams, $http){
	
	$rootScope.loginCheck();
	
	$scope.memBer = function(){
	 var data = [];
	 var dt= [];
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
		              
		              '<div class="memin-middle-id1">'+data[i].pw+'</div>'+
		              '<div class="memin-middle-btn1"><button id="delbtn" class="delbtn type="button">삭제</button></div>'+
	              '</div>';
			  
			  $(".listin").append(tag);
		  }
		  $(".memin-middle-btn1 .delbtn").off().on("click",function(){
              var index = $(".memin-middle-btn1 .delbtn").index(this);
               console.log("jsp : " +index);
             console.log("index:"+data[index].id);
             var upid = data[index].id;
             console.log("upid :" ,upid);
             $.ajax({
            	 type : "post",
            	 url : "memberupdate",
            	 data: {"upid":upid}
             }).done(function(d){
            	 alert("삭제되었습니다.");
            	 window.location.reload();
//            	 var result = JSON.parse(d);
//            	 dt = result.list;
//            	 console.log("dt:",dt);
             })
             
             
          })

	  })
	}
	$scope.memBer();
});