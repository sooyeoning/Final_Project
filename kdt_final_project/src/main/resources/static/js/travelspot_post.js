$(document).ready(function() {

	//js url parameter 가져오기
	let urlParams = new URL(location.href).searchParams;
	let contentId = urlParams.get('contentId');

	$('#images').click(function() {
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
	});//image onclick end

	$('#info').click(function() {
		$.ajax({
			url: "/travelspot/post/info?contentId="+contentId,
			type: 'get',
			success: function(placedto) {
				$('#info').css("color", "#2463d3");
				
				//지도 
				$('div[class="result"]').html('<div id="map" style="width:100%; height:400px;"></div><br>');
		
				var mapx = placedto.mapx; //위도
				var mapy = placedto.mapy; //경도

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

				var iwContent = '<div style="padding:5px;">'+ placedto.title +' <br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
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
	});//image onclick end

	$('#comments').click(function() {
		$.ajax({
			url: "/travelspot/post/comments",
			type: 'get',
			success: function(server) {
				$('#comments').css("color", "#2463d3");
				$('div[class="result"]').html(`<div class="textarea-outerbox">
				<p class="font_content">여행지 한줄평💭</p><br>  
				<textarea class="textarea-innerbox font_comment" cols="110" rows="4">여행지에 대한 한줄평을 남겨주세요</textarea>
				<input class="savebutton" type="button" value="저장">
				</div>`);
				$('div[class="result"]').append(`<div class="comments-outerbox">
				<div class="comments-innerbox">
				<p>예전에 버스킹 정말 즐겁게 봤었어요! 얼른 코로나가 끝나고 다시 활발해졌으면 좋겠네요!</p>
				<p>닉네임</p>
				<p>2023/06/29</p>
				</div></div>`);
				$('div[class="result"]').append(`<div class="comments-outerbox">
				<div class="comments-innerbox">
				<p>예전에 버스킹 정말 즐겁게 봤었어요! 얼른 코로나가 끝나고 다시 활발해졌으면 좋겠네요!</p>
				<p>닉네임</p>
				<p>2023/06/29</p>
				<input class="updatebutton" type="button" value="수정">
				<input class="deletebutton" type="button" value="삭제">
				</div></div>`);
				$('div[class="result"]').append(`<div style="position:fixed; bottom:3%; right:-10%;">
				<a href="#"><img src="../img/top.png" width="5%" height="5%"></a>`);
			},
			error: function() { }
		});

		//댓글남기기 버튼, 로그인버튼		
	});//image onclick end

});//ready end