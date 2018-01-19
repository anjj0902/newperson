var app = angular.module("Cusvoice", []);
app.controller("cusvoice", function($rootScope, $scope, $routeParams, $http){
   var data = [];      
   var viewRow = 10;   
   var tag = "";
   var tag1= "";
   var page = 1;
   var totCnt = 0;
	$rootScope.loginCheck();
	
	$scope.cusVoice = function(){
		
  	 $("#cusvoice-write").click(function(){
  		location.href="#!/cusvoiceregister";
     	
     });
  	function createHtml(){ // ul(부모) 태그 속에 li(자식) 태그 넣기 위한 함수
        
        $(".form").empty(); // ul 태그의 자식들를 초기화가 필요하다.
           
        
        for(var i = 0; i<data.length; i++){
           tag =  '<div class="notice-middle listbigbox">'+
  				      ' <div class="notice-middle-no">'+(i+1)+'</div>'+
  				      	' <div class="notice-middle-title">'+data[i].title+
  				      '</div>'+
  				      '<div class="notice-middle-id">'+data[i].id+'</div>';
  				   
  			     $(".form").append(tag);

          	
        }
        $(".listbigbox").off();
        $(".listbigbox").on("click",function(){
           var index = $(".listbigbox").index(this);
           console.log("jsp :" +index);
           var newsNo = data[index].no;
           location.href = "#!/cusvoicedetail/" + newsNo;
        });
    }
	     function createPaging(){
        console.log("pageing");
        var paging = totCnt / viewRow;
        // 전체의 행의 수에서 보여줄 행을 나누면 페이지의 갯수를 알 수 있다.
        $(".page").empty(); // div 태그 속에 a 태그를 초기화 한다.
        for(var i = 0; i < paging; i++){
           $(".page").append("<a href='#!/cusvoice#" + (i + 1) + "'>" + (i + 1) + "</a>");
           console.log("1111");
        }      
        
//        $(".page a").eq(page - 1).addClass("bg"); 
//        
//        $(".page a").off().on("click", function(){ // 페이지 전환 이벤트를 작성 한다.
//              // a 태그 중에 몇번째 페이지인지 알면 리스트 화면를 다시 보여 줄 수 있다. page 변수 활용 할것!
//              page = $(this).text(); // 선택한 페이지의 text 추출
//              
//              var a = page+"page";
//            $("#paginationCurrentPage").empty();
//            if($("#paginationCurrentPage").text()==null){
//               $("#paginationCurrentPage").text("1page");
//            }else{
//               $("#paginationCurrentPage").append(a);
//            }
//              setTimeout(function(){ 
//                 initData(); // 디비에서 데이터 다시 가져 오기 위하여 함수 호출
//              }, 100); // 타이머가 완료된 뒤 지정 함수가 실행 됨
//           });
        
     }
	   function initData(){ // 디비에서 데이터 가져오기 위한 함수
      
      var hash = location.hash.substring(1, location.hash.length); // a 태그의 이벤트로 발생한 hash 값을 가져온다.
      if(hash.indexOf("#") > -1){ // hash 값이 있을 경우 page 변수의 값으로 사용한다.
         page = hash.substring(hash.indexOf("#") + 1, hash.length); 
         console.log("page : ", page);
      }     
      var end = (viewRow * page); // 10 * 2 = 20 
      var start = (end - viewRow); // 20 - 10 = 10
      
      $.ajax({
            type:"post", 
            url:"cusnewsData", // Spring에서 만든 URL 호출
            data:{"start":start, "viewRow":viewRow} // 파라메터로 사용할 변수 값 객체 넣기
      }).done(function(d){ // 비동기식 데이터 가져오기
         var result = JSON.parse(d);
         data = result.list;
         totCnt = result.totCnt.tot;
         console.log("totcnt js" +totCnt, " data : " ,data);
         
         
         createHtml(); // 화면에 표현하기 위하여 함수 호출
         
         createPaging(); // 페이지 링크 표현하기 우하여 함수 호출
      });
   }
   initData();
	}
	$scope.cusVoice();
});