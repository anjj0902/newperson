// 앵귤라 모듈 만들기
var app = angular.module("AJJ", ["ngRoute","Direction","Main","Join","Login","Cusvoice","Cusvoiceregister","Cusvoicedetail","Notice","Noticedetail","Noticeregister","Menuregister","Spagetti","Risotto","Pizza","Stake","Salad","Member","Memberinfo"]);
		
// 라우터 처리 부분 (싱글 페이지 적용)
app.config(function($routeProvider){
	var template = "resources/html/";
	$routeProvider.when("/main", {
		templateUrl : template+"main.html"
	   ,controller : "main"
	}).when("/introduce", {
		templateUrl : template+"SoleMio/introduce.html"
		   ,controller : "common"
	}).when("/direction", {
		templateUrl : template+"SoleMio/direction.html"
	   ,controller : "direction"
	}).when("/interior", {
		templateUrl : template+"SoleMio/interior.html"
		   ,controller : "common"
	}).when("/join", {
		templateUrl : template+"SoleMio/join.html"
		,controller : "join"
	}).when("/login", {
		templateUrl : template+"SoleMio/login.html"
		,controller : "login"
	}).when("/spagetti", {
		templateUrl : template+"Menu/spagetti.html"
		   ,controller : "spagetti"
	}).when("/risotto", {
		templateUrl : template+"Menu/risotto.html"
		   ,controller : "risotto"
	}).when("/pizza", {
		templateUrl : template+"Menu/pizza.html"
		   ,controller : "pizza"
	}).when("/stake", {
		templateUrl : template+"Menu/stake.html"
		   ,controller : "stake"
	}).when("/salad", {
		templateUrl : template+"Menu/salad.html"
		   ,controller : "salad"
	}).when("/menuregister/:parammenu", {
		templateUrl : template+"Menu/menuregister.html"
		   ,controller : "menuregister"
	}).when("/notice", {
		templateUrl : template+"Customer/notice.html"
		,controller : "notice"
	}).when("/cusvoice", {
		templateUrl : template+"Customer/cusvoice.html"
		   ,controller : "cusvoice"
	}).when("/cusvoicedetail/:param", {
		templateUrl : template+"Customer/cusvoicedetail.html"
		   ,controller : "cusvoicedetail"
	}).when("/cusvoiceregister/:paramrec", {
		templateUrl : template+"Customer/cusvoiceregister.html"
		   ,controller : "cusvoiceregister"
	}).when("/cusvoiceregister", {
		templateUrl : template+"Customer/cusvoiceregister.html"
		   ,controller : "cusvoiceregister"
	}).when("/noticedetail/:param", {
		templateUrl : template+"Customer/noticedetail.html"
		   ,controller : "noticedetail"
	}).when("/noticeregister/:paramrec", {
		templateUrl : template+"Customer/noticeregister.html"
		   ,controller : "noticeregister"
	}).when("/noticeregister", {
		templateUrl : template+"Customer/noticeregister.html"
		   ,controller : "noticeregister"
	}).when("/memberinfo", {
		templateUrl : template+"MyPage/memberinfo.html"
		   ,controller : "memberinfo"
	}).when("/member", {
		templateUrl : template+"MyPage/member.html"
		   ,controller : "member"
	}).otherwise({redirectTo: "/main"});
});
//"/cusvoicedetail/:param"
//앵귤라에서 사용할 전역 변수 선언 하는 곳?
app.run(function($rootScope, $http, loginService){
	$rootScope.commonLeft = "resources/html/commons/left.html";
	$rootScope.commonRight = "resources/html/commons/right.html";
	$rootScope.commonmLeft = "resources/html/commons/mleft.html";
	$rootScope.commonmRight = "resources/html/commons/mright.html";
	$rootScope.mainFlag = false;
	$rootScope.loginFlag = false;
	$rootScope.memberFlag = false;
	$rootScope.userId = "";
	
	$rootScope.historyBack = function(){
		window.history.back();
	}
	
	$rootScope.loginCheck = function(){
		if(location.hash == "#!/main"){
			$rootScope.mainFlag = true;
		} else {
			$rootScope.mainFlag = false;
		}
		
		loginService.async().then(function(){
			var data = loginService.data();
			
			
			if(data.data.state == 1){
				$rootScope.loginFlag = true;
				$rootScope.userId = data.data.id;
				if(data.data.auth == 1){
					$rootScope.memberFlag= true;
				} else if(data.data.auth == 2){
					$rootScope.memberFlag= false;
				}
			} else {
				
			}
			
			if(data.data.state==1){
				$("#cusvoice-write").show();
			}else{
				$("#cusvoice-write").hide();
			}
			
			if(data.data.auth == 1){
				$("#registerbtn").show();
				$("#notice-write").show();
			}else{
				$("#registerbtn").hide();
				$("#notice-write").hide();
			}
		});
	}
	
	$rootScope.logout = function(){
		$http.post("logout").then(function(result){
			console.log(result);
			location.href = "/";
		});
		
//		$.post("logout").done(function(result){
//			console.log("결과 :" + result)
//			location.href = "/";
//		});
	}
});

//앵귤라에서 서비스 만들기
app.factory("loginService", function($http, $q){
   var deffered = $q.defer();
   var data = [];
   return { 
		   async : function(){
			   $http.post("checkLogin")
		         .then(function(result){
		            data = result;
		            
		            
		            deffered.resolve();
		         });
		      return deffered.promise;
		   },
		   data : function(){
					return data;
				  }
	     };
});

app.controller("common", function($rootScope, $scope, $routeParams, $http){
	$rootScope.loginCheck();
});