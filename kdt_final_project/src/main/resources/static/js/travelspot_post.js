$(document).ready(function() {

	//js url parameter 가져오기
	let urlParams = new URL(location.href).searchParams;
	let contentId = urlParams.get('contentId');

	$('#images').click(function() {
		imageAjax();
	});//image onclick end

	$('#info').click(function() {
		infoAjax();
	});//image onclick end

	$('#comments').click(function() {
		$.ajax({
			url: "/travelspot/post/comments?contentId="+contentId,
			type: 'get',
			success: function(commentsList) {
				$('#comments').css("color", "#2463d3");
				$('div[class="result"]').html(`<div class="textarea-outerbox">
				<p class="font_content">여행지 한줄평💭</p><br>
				<textarea id="content" class="textarea-innerbox font_comment" cols="110" rows="4" placeholder="여행지에 대한 한줄평을 남겨주세요"> </textarea>
				<input type="button" class="savebutton" onclick="saveComment()" value="저장">
				</div>`);
				
				//https://chlee21.tistory.com/156 참고
				$.each(commentsList, function(index, item){
					$('div[class="result"]').append(
					`<div class="comments-outerbox"><div class="comments-innerbox"><p>`+item.contents +'</p>'
					+'<p>닉네임 '+item.writer+'</p><p>작성일자 '+item.writingtime+
					`</p> <input class="updatebutton" type="button" value="수정">
					<input class="deletebutton" type="button" value="삭제"</div></div>`);
					
				});
				
				$('div[class="result"]').append(`<div style="position:fixed; bottom:3%; right:-10%;">
				<a href="#"><img src="../img/top.png" width="5%" height="5%"></a>`);
			},
			error: function() { }
		});

	});//comments onclick end
	
/*
	function saveComment(){
		$('.savebutton').click(function(){
			$.ajax({
				url: "/travelspot/comments/save?contentId="+contentId,
				type: 'get',
				data: {content : $('#content').val()},
				success: function(server){
					alert(server);
				}
				
			})//ajax
		});//savebtn
	};
	*/
	
function imageAjax(){
	$.ajax({
			url: "/travelspot/post/images?contentId="+contentId,
			type: 'get',
			success: function(placedto) {
				$('#images').css("color", "#2463d3");
				$('div[class="result"]').html('<img class="images" src='+placedto.image1+'>');	
				$('div[class="result"]').append(`<div style="position:fixed; bottom:3%; right:-10%;">
				<a href="#"><img src="../img/top.png" width="5%" height="5%"></a>`);
			},
			error: function() { }
		});
};

function infoAjax(){
	$.ajax({
			url: "/travelspot/post/info?contentId="+contentId,
			type: 'get',
			success: function(placedto) {
				$('#info').css("color", "#2463d3");
				
				//지도 
				$('div[class="result"]').html('<div id="map" style="width:100%; height:400px;"></div><br>');
		
				var mapx = placedto.mapx; //위도
				var mapy = placedto.mapy; //경도
				var title = placedto.title;
				
				//마커 표시
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
					mapOption = {
						center: new kakao.maps.LatLng(mapy, mapx), // 지도의 중심좌표
						level: 3 // 지도의 확대 레벨
					};

				var map = new kakao.maps.Map(mapContainer, mapOption);

				// 마커가 표시될 위치입니다 
				var markerPosition = new kakao.maps.LatLng(mapy, mapx);

				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({ position: markerPosition });

				// 마커가 지도 위에 표시되도록 설정합니다
				marker.setMap(map);
//https://map.kakao.com/?urlX=400206.0&urlY=-11702.0&name=Hello+World%21
				
				var iwContent = '<div style="padding:5px;">'+ placedto.title +' <br><a href="https://map.kakao.com/?urlX=${mapy}&urlY=<%=mapy%>&name=${title}" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/{placedto.title},{mapy},{mapx}" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
					iwPosition = new kakao.maps.LatLng(mapy, mapx); //인포윈도우 표시 위치입니다

				
				// 인포윈도우를 생성합니다
				var infowindow = new kakao.maps.InfoWindow({
					position: iwPosition,
					content: iwContent
				});

				// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
				infowindow.open(map, marker);
				
				//상세정보
				//문의 및 안내 주소 휴일 입장료 유모차, 홈페이지, 이용시간, 주차, 장애인 주차 안내, 휠체ㅓ, 접근로, 화장실, 반려동물
				if(placedto.contents == 'null'){
					//$('div[class="result"]').append();
				} else {
				$('div[class="result"]').append('<p> 관광지 설명<br>'+placedto.contents+'<br><br>');
				} 
				if(placedto.homepage == 'null'){
					//$('div[class="result"]').append();
				} else {
				$('div[class="result"]').append('<p> 관광지 대표 홈페이지<br>'+placedto.homepage+'<br><br>');
				} 
				
				$('div[class="result"]').append('<p> 문의 및 안내: '+'<br>'); //infocenter, sponsor2tel	
				$('div[class="result"]').append('<p> 이용시간 및 쉬는날: '); //restdate, useseason, usetime
				$('div[class="result"]').append('<p> 이용요금: ');//usetimefestival	
				$('div[class="result"]').append('<p> 주차시설: '+'<br>');//parking
				$('div[class="result"]').append('<p> 유모차 대여 정보: '); //chkbabycarriage	
				$('div[class="result"]').append('<p> 애완동물 동반가능 정보: ');//chkpet
				
					
				//스크롤
				$('div[class="result"]').append(`<div style="position:fixed; bottom:3%; right:-10%;">
				<a href="#"><img src="../img/top.png" width="5%" height="5%"></a>`);
			},
			error: function() { }
		});
};

});//ready end

var mapx = '${placedto.mapy}';//위도
var mapy = '${placedto.mapx}'; //경도
var title = '${placedto.title}'; //장소명

function aClick(){
		location.href = "https://map.kakao.com/?urlX="+mapy+"&urlY="+mapx+"&name="+title;
				}