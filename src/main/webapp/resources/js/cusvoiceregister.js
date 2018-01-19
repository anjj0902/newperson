var app = angular.module("Cusvoiceregister", []);
app.controller("cusvoiceregister", function($rootScope, $scope, $routeParams, $http){
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
	     $("#cusvoice-writebtn").off();
         $("#cusvoice-writebtn").on("click",function(){
        	 var title = $("#cus-title").val();
        	 var contents = $("#cus-contents").val();
        	 console.log(title,contents);
                       	 
        	 $.ajax({
        		 type : "post",
        		 url : "cusvoicewrite",
        		 data : {"title":title,"contents":contents}
        	 }).done(function(d){
        		 location.href="#!/cusvoice";
        	 })
         });
         
         var dt=[];
         function loadEvent(){
        	 $.ajax({
        		 url: "cusvoiceDetail",
                 data:{"no" : no}                   	 
        	 }).done(function(d){
        		 var list = JSON.parse(d);
        	 	
        		 dt = list.data;
         		console.log("jsp:"+dt.title);
         		listHtml();
         		button();
        	 });
        	 
         }   
         function listHtml(){
        	 $("#cus-title").val(dt.title);
        	 $("#cus-contents").val(dt.contents);
         }
         function button(){
        	 $("#cusvoice-updatebtn").off().on("click",function(ev){
        		 var title=$("#cus-title").val();
        		 var contents = $("#cus-contents").val();
        		 
        		 $.ajax({
        			 type:"post",
        			 
        			 url:"cusupdatewrite",
        			 data:{"title":title, "contents":contents,"no" :no}
        		 }).done(function(d){
        			 dt = d.data;
        			 location.href="#!/cusvoicedetail/"+$scope.no;
        		 });
        		 ev.preventDefault();
        	 });
         }
         
         
         loadEvent();
	}
	$scope.cusvoiceregister();
});