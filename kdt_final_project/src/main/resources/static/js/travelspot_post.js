$(document).ready(function() {

	//js url parameter 가져오기
	let urlParams = new URL(location.href).searchParams;
	let contentId = urlParams.get('contentId');
	
	imageAjax(); //기본페이지: 사진모아보기로 설정

	$('#images').click(function() {
		imageAjax();
	});//image onclick end

	$('#info').click(function() {
		infoAjax();
	});//image onclick end

	
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
				
				var iwContent = `<div style="padding:5px;">`+ placedto.title +
				`<br><a href="https://map.kakao.com/link/map/`+title+`,`+mapy+`,`+mapx+`" style="color:blue" target="_blank">큰지도보기</a> 
				<a href="https://map.kakao.com/link/to/`+title+`,`+mapy+`,`+mapx+`"style="color:blue" target="_blank">길찾기</a></div>`;
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
