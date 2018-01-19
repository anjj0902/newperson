var app = angular.module("Spagetti", []);
app.controller("spagetti", function($rootScope, $scope, $routeParams, $http){
	
	$rootScope.loginCheck();
	$scope.menutype=1
	var menutype = $scope.menutype;
	$scope.menuregister = function(){
		$("#registerbtn").off().on("click",function(){
//			alert="ggg";
			 location.href="#!/menuregister/"+menutype;
		});
		
		$.ajax({
			type:"post",
			url:"getMenu",
			data:{"menu_type":1}
		}).done(function(d){
			var result = JSON.parse(d)
			data = result;
			console.log("jsp data:"+ data);
//			console.log("jsp gg: "+data[12].name);
			for(var i=0; i< data.length; i++){
				console.log("ggg",data[i].name);
				var id = "id" +i;
				var tag = 
					'<div class="menubase" style="background: rgba(227,224,197,16.9);">'+
						'<div class="menutop"style="line-height : 5rem;">'+
							'<div>'+data[i].menu_name+'</div>'+
						'</div>'+
						'<div class="menuimg">'+
							'<div class="menuimgl"></div>'+
							'<div class="menuimgm">'+
								'<div onclick="document.getElementById(\''+id+'\').style.display='+"'block'"+'" class="w3-button">'+
									'<img style="width : 100%; height : 90%;" class="menu-img" src="resources/upload/' + data[i].image_name1 + '" />'+
								'</div>'+
							'</div>'+
							'<div class="menuimgr"></div>'+
        	   		 	'</div>'+
    	   		 	'</div>'+
				
		   		 	'<div id="' + id + '" class="w3-modal" >'+
						
					    '<div class="w3-modal-content4 disNone disblock">'+
					      '<div class="w3-container jdcjeju">'+
					        '<span onclick="document.getElementById(\''+id+'\').style.display='+"'none'"+'" class="w3-button w3-display-topright closed">&times;</span>'+
					       ' <img src="resources/upload/' + data[i].image_name1 + '" style="height: 70%; width: 100%; margin-top:3%;" />'+
					      '</div>'+
					    '</div>'+
					    
					    '<div class="w3-modal-content4 disNone">'+
					      '<div class="w3-container jdcjeju">'+
					        '<span onclick="document.getElementById(\''+id+'\').style.display='+"'none'"+'" class="w3-button w3-display-topright closed">&times;</span>'+
					       ' <img src="resources/upload/' + data[i].image_name2 + '" style="height: 70%; width: 100%;margin-top:3%;" />'+
					      '</div>'+
					    '</div>'+
					    
				    	'<div class="bannerControl">'+
				    		'<div class="btn button1"  style="cursor: pointer;margin-left : 0%; margin-top: 6%;">'+
				    			'<img src="resources/img/sole.png" style="width : 96px; height : 60px;background-color : black;">'+
				    		'</div>'+
		            	'</div>'+
	            	'</div>';
				if(data[i].name==1){
					$("#spagetti-menu").append(tag);
				}else if(data[i].name==2){
					$("#oil-menu").append(tag);
				}else if(data[i].name==3){
					$("#hot-menu").append(tag);
				}
				
				
			      $(".bannerControl .btn").off().on("click", function(){
                      
                      var bi = $(".bannerControl .btn").index(this);
                      var i = $(this).closest(".w3-modal").find(".w3-modal-content4").index($(this).closest(".w3-modal").find(".w3-modal-content4.disblock"));
                      
                      $(this).closest(".w3-modal").find(".w3-modal-content4").removeClass("disblock");
                        // addClass() : 클래스를 주입하는 함수
                        // removeClass() : 해당 클래스 삭제하는 함수
                         if(bi%2 == 0){ // 왼쪽
                           if(i == 0){ // 현재 인덱스가 0이면 -1값이 되지 않게 하기 위해서 사용
                              i = ($(this).closest(".w3-modal").find(".w3-modal-content4").length - 1); // 현재 이미지 갯수를 인덱스로 처리 
                           }else {
                              i--; // 현재 인덱스 보다 -1 되도록 처리
                           }
                        }else if(bi%2 == 1){ // 오른쪽
                           if(i == ($(this).closest(".w3-modal").find(".w3-modal-content4").length - 1)){ // 현재 인덱스가 이미지 갯수 보다 커지지 않게 하기 위해서 처리
                              i = 0; // 처음으로 돌아가지 위해서 0 값으로 변경
                           }else {
                              i++; // 현재 인덱스 보다 +1 되도록 처리
                           }
                        }
                        
                         $(this).closest(".w3-modal").find(".w3-modal-content4").eq(i).addClass("disblock").animate({
                            
                         }, 1000); // 위의 정의 되어진 내용으로 화면에 출력
                     });
			}
		});
	}
	
	$scope.menuregister();
});

