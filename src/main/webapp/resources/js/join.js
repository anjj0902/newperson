var app = angular.module("Join", []);
app.controller("join", function($rootScope, $scope, $routeParams, $http){
	$rootScope.loginCheck();
	
	$scope.loadMap = function(){
		var idText= "";
    	var finId = "";
    	var id;
    	var pw;
    	var email;
    	$("#joinbutton").off();
        $("#joinbutton").on("click",function(){
        	
        	id= $("#id").val();
        	pw= $("#pw").val();
        	email=$("#email").val();
        	finId = $("#id").val();
        	checkid = $("#checkid").text();
        	console.log("id :" +id+ "pw :"+pw+ "email :"+email+"finId :"+finId);
        	console.log("checkid :" + checkid);
        	if(id != null && pw != null && email != null && checkid=="완료" &&finId==id){
        		$.ajax({
        			type:"POST",
        			url:"Userjoin",
        			data:{"id":id,"pw":pw,"email":email}
        		}).done(function(result){
        			var join= JSON.parse(result);
        			console.log("jsp:" + join);
        			if(join.join == 1){
        				alert("회원가입이 완료되었습니다.");
        				location.href="#!/login"
        			}else{
        				alert("회원가입에 실패했습니다.")
        			}
        		});
        	}else if(id == "" || pw == "" || email == ""){
        		alert("모든 텍스트를 입력하세요");
        	}else if(checkid=="중복확인"){
        		alert("중복확인을 해주세요.");
        	}else if(finId != idText){
        		alert("id를 다시 확인하세요.");
        		$("#id").val(idText);
        	}else if(pw.length > 15){
        		alert("비밀번호를 15자 이하로 입력해주세요");
        	}
        });
        $("#checkid").off().on("click",function(){
        	idText = $("#id").val();
        	
        	if(idText == ""){
        		alert("아이디를 입력해주세요.");
        	}else if(idText.length > 15){
        		alert("아이디를 15자 안으로 입력해주세요.");
        	}else{
        		$.ajax({
        			type :"POST",
        			url :"CheckId",
        			data : {"id":id},
        			datatype : "json"
        		}).done(function(result){
        			console.log("중복확인"+result.checkid);
        			if(result.checkid == null){
        				$("#checkid").text("완료");
        				alert("사용가능한 아이디입니다.");
        			}else{
        				$("#checkid").text("중복확인");
        				$("#id").val("");
        				alert("사용중인 아이디 입니다.")
        			}
        		})
        	}
        })
	}
	$scope.loadMap();
});