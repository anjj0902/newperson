var app = angular.module("Notice", []);
app.controller("notice", function($rootScope, $scope, $routeParams, $http){
    $scope.viewRow = 10;
    $scope.start = 0;
	$rootScope.loginCheck();
	$scope.btnDelete = function(row){
		$http.post("noticede","",{params : {"noid": row.no}})
        	.then(function(result){
        		alert("삭제되었습니다.");
        		window.location.reload();
        });
	}
	$scope.btnSelect = function(row){
		location.href = "#!/noticedetail/" + row.no;
	}
	$scope.btnWrite1= function(){
		location.href = "#!/noticeregister";
	}
	$scope.initData = function() { // 디비에서 데이터 가져오기 위한 함수
	      if(location.hash.split("#").length > 2){ // hash 값이 있을 경우 page 변수의 값으로 사용한다.
	         page = location.hash.substring(location.hash.lastIndexOf("#") + 1, location.hash.length); // a 태그의 이벤트로 발생한 hash 값을 가져온다. 
	      } else {
	    	  page = 1;
	      }
	      var end = ($scope.viewRow * page); // 10 * 2 = 20 
	      $scope.start = (end - $scope.viewRow); // 20 - 10 = 10
	      $http.post("newsData")
	         .then(function(result){
	        	 $scope.data = result.data.list;
	        	 $scope.totCnt = $scope.data.length;
	        	 $scope.pagings = [];
	        	 for(var i = 0; i < $scope.totCnt / $scope.viewRow; i++){
	        		 $scope.pagings[i] = i; 
	        	 }
	      });
	}
	$scope.initData();
	
//   var data = [];      
//   var viewRow = 10;   
//   var tag = "";
//   var tag1= "";
//   var page = 1;
//   var totCnt = 0;
//	$scope.cusVoice = function(){
//		 $("#notice-write").click(function(){
//		  		location.href="#!/noticeregister";
//		     	
//		     });
//		 function createHtml(){ // ul(부모) 태그 속에 li(자식) 태그 넣기 위한 함수
//		        $(".form").empty(); // ul 태그의 자식들를 초기화가 필요하다.
//		        for(var i = 0; i<data.length; i++){
//		           tag =  '<div class="notice-middle listbigbox1">'+
//		  				      ' <div class="notice-middle-no1">'+(i+1)+'</div>'+
//		  				      	' <div class="notice-middle-title1">'+data[i].title+
//		  				      '</div>'+
//		  				      '<div class="notice-middle-id1">'+data[i].id+'</div>'+
//		  				      '<div>'+
//		           			  '<div class="notice-deldel"><button id="nobtn" style="width : 72%;height: 87%; margin-left :15%;" type="button">삭제</button></div>';
//		  			     $(".form").append(tag);
//		        }
//		        $(".notice-deldel button").click(function(){
//		        	var index = $(".notice-deldel button").index(this)
//		        	console.log("jsp btn:", index);
//		        	console.log("index id:", data[index].no);
//		        	var noid = data[index].no;
//		        	$.ajax({
//		        		type :"post",
//		        		url : "noticede",
//		        		data : {"noid":noid}
//		        	}).done(function(d){
//		        		alert("삭제되었습니다.");
//		        		window.location.reload();
//		        	})
//		        });
//		        $(".notice-middle-title1").off().on("click",function(){
//		           var index = $(".notice-middle-title1").index(this);
//		           console.log("jsp :" +index);
//		           var newsNo = data[index].no;
//		           location.href = "#!/noticedetail/" + newsNo;
//		        });
//		    }
//			function createPaging(){
//		        console.log("pageing");
//		        var paging = totCnt / viewRow;
//		        // 전체의 행의 수에서 보여줄 행을 나누면 페이지의 갯수를 알 수 있다.
//		        $(".page").empty(); // div 태그 속에 a 태그를 초기화 한다.
//		        for(var i = 0; i < paging; i++){
//		           $(".page").append("<a href='#!/notice#" + (i + 1) + "'>" + (i + 1) + "</a>");
//		           console.log("1111");
//		        }
//		        $(".page a").eq(page - 1).addClass("bg"); 
//		        
//		        $(".page a").off().on("click", function(){ // 페이지 전환 이벤트를 작성 한다.
//		              // a 태그 중에 몇번째 페이지인지 알면 리스트 화면를 다시 보여 줄 수 있다. page 변수 활용 할것!
//		              page = $(this).text(); // 선택한 페이지의 text 추출
//		              
//		              var a = page+"page";
//		            $("#paginationCurrentPage").empty();
//		            if($("#paginationCurrentPage").text()==null){
//		               $("#paginationCurrentPage").text("1page");
//		            }else{
//		               $("#paginationCurrentPage").append(a);
//		            }
//		              setTimeout(function(){ 
//		                 initData(); // 디비에서 데이터 다시 가져 오기 위하여 함수 호출
//		              }, 100); // 타이머가 완료된 뒤 지정 함수가 실행 됨
//		           });
//		     }
//			   function initData(){ // 디비에서 데이터 가져오기 위한 함수
//		       
//			      if(location.hash.split("#").length > 2){ // hash 값이 있을 경우 page 변수의 값으로 사용한다.
//			         page = location.hash.substring(location.hash.lastIndexOf("#") + 1, location.hash.length); // a 태그의 이벤트로 발생한 hash 값을 가져온다. 
//			         console.log("page : ", page);
//			      } else {
//			    	  page = 1;
//			      }
//			      var end = ($scope.viewRow * page); // 10 * 2 = 20 
//			      $scope.start = (end - $scope.viewRow); // 20 - 10 = 10
//		      
//			      $http.post("newsData")
//			         .then(function(result){
//			        	 $scope.data = result.data.list;
//			        	 $scope.totCnt = $scope.data.length;
//			        	 $scope.pagings = [];
//			        	 for(var i = 0; i < $scope.totCnt / $scope.viewRow; i++){
//			        		 $scope.pagings[i] = i; 
//			        	 }
//				         console.log("totcnt js", $scope.totCnt, " data : " , $scope.data, $scope.pagings);
//			      });
//		      $.ajax({
//		            type:"post", 
//		            url:"newsData", // Spring에서 만든 URL 호출
//		            data:{"start":start, "viewRow":viewRow} // 파라메터로 사용할 변수 값 객체 넣기
//		      }).done(function(d){ // 비동기식 데이터 가져오기
//		         var result = JSON.parse(d);
//		         data = result.list;
//		         totCnt = result.totCnt.tot;
//		         console.log("totcnt js" +totCnt, " data : " ,data);
//		         createHtml(); // 화면에 표현하기 위하여 함수 호출
//		         createPaging(); // 페이지 링크 표현하기 우하여 함수 호출
//		      });
//		   }
//		   initData();
//	}
//	$scope.cusVoice();
});