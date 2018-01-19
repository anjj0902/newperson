var app = angular.module("Noticeregister", []);
app.controller("noticeregister", function($rootScope, $scope, $routeParams, $http){
    $scope.no = $routeParams.paramrec;
    console.log("no",$scope.no);
    var no =$scope.no
    console.log("var no :",no);
	$rootScope.loginCheck();
//	console.log("ggggggggggggggggggggggggg",$routeparams.param);
	$scope.cusvoiceregister = function(){
		$("#cancelbtn").off().on("click",function(){
			window.history.back();
		});
	     $("#notice-writebtn").off();
         $("#notice-writebtn").on("click",function(){
        	 var title = $("#not-title").val();
        	 var contents = $("#not-contents").val();
        	 console.log(title,contents);
                       	 
        	 $.ajax({
        		 type : "post",
        		 url : "noticewrite",
        		 data : {"title":title,"contents":contents}
        	 }).done(function(d){
        		 location.href="#!/notice";
        	 })
         });
         
         var dt=[];
         function loadEvent(){
        	 $.ajax({
        		 url: "newsDetail",
                 data:{"no" : no}                   	 
        	 }).done(function(d){
        		 var list = JSON.parse(d);
        	 	
        		 dt = list.data;
//         		console.log("jsp:"+dt.title);
         		listHtml();
         		button();
        	 });
        	 
         }   
         function listHtml(){
        	 $("#not-title").val(dt.title);
        	 $("#not-contents").val(dt.contents);
         }
         function button(){
        	 $("#notice-updatebtn").off().on("click",function(ev){
        		 var title=$("#not-title").val();
        		 var contents = $("#not-contents").val();
        		 
        		 $.ajax({
        			 type:"post",
        			 
        			 url:"updatewrite",
        			 data:{"title":title, "contents":contents,"no" :no}
        		 }).done(function(d){
        			 dt = d.data;
        			 location.href="#!/noticedetail/"+$scope.no;
        		 });
        		 ev.preventDefault();
        	 });
         }
         
         if(no==null){
        	 $("#notice-updatebtn").hide();
         }else{
        	 $("#notice-writebtn").hide();
        	 loadEvent(); 
         }
        
	}
	$scope.cusvoiceregister();
});