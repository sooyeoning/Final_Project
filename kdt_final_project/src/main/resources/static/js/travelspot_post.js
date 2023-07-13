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


	function imageAjax() {
		$.ajax({
			url: "/travelspot/post/images?contentId=" + contentId,
			type: 'get',
			success: function(placedto) {
				$('#images').css("color", "#2463d3");
				$('div[class="result"]').html('<img class="images" src=' + placedto.image1 + '>');
				$('div[class="result"]').append(`<div style="position:fixed; bottom:3%; right:-10%;">
				<a href="#"><img src="../img/top.png" width="5%" height="5%"></a>`);
			},
			error: function() { }
		});
	};

	function infoAjax() {
		$.ajax({
			url: "/travelspot/post/info?contentId=" + contentId,
			type: 'get',
			success: function(placeContentsDTO) {
				$('#info').css("color", "#2463d3");

				//지도 
				$('div[class="result"]').html('<div id="map" style="width:100%; height:400px;"></div><br>');

				var mapx = placeContentsDTO.mapx; //위도
				var mapy = placeContentsDTO.mapy; //경도
				var title = placeContentsDTO.title;

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

				var iwContent = `<div style="padding:5px;">` + placeContentsDTO.title +
					`<br><a href="https://map.kakao.com/link/map/` + title + `,` + mapy + `,` + mapx + `" style="color:blue" target="_blank">큰지도보기</a> 
				<a href="https://map.kakao.com/link/to/`+ title + `,` + mapy + `,` + mapx + `"style="color:blue" target="_blank">길찾기</a></div>`;
				iwPosition = new kakao.maps.LatLng(mapy, mapx); //인포윈도우 표시 위치입니다

				// 인포윈도우를 생성합니다
				var infowindow = new kakao.maps.InfoWindow({
					position: iwPosition,
					content: iwContent
				});

				// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
				infowindow.open(map, marker);

				// 기본상세정보
				if (placeContentsDTO.contents != 'null') {
					$('div[class="result"]').append('<p>관광지 설명<br>' + placeContentsDTO.contents + '<br><br>');
				}
				if (placeContentsDTO.homepage != 'null') {
					$('div[class="result"]').append('<p>관광지 대표 홈페이지<br>' + placeContentsDTO.homepage + '<br><br>');
				}

				//문의 및 안내 주소 휴일 입장료 유모차, 홈페이지, 이용시간, 주차, 장애인 주차 안내, 휠체ㅓ, 접근로, 화장실, 반려동물
				if (placeContentsDTO.contentTypeId == 12) {
					if (placeContentsDTO.infocenter != 'null') {
						$('div[class="result"]').append('<p>문의 및 안내: ' + placeContentsDTO.contentsdto.infocenter + '<br><br>');
					} if(placeContentsDTO.usetime != 'null'){	
						$('div[class="result"]').append('<p>이용시간: '+placeContentsDTO.contentsdto.usetime+'<br><br>');
					} if(placeContentsDTO.restdate != 'null'){	
						$('div[class="result"]').append('<p>쉬는날: '+placeContentsDTO.contentsdto.restdate+'<br><br>');
					} if (placeContentsDTO.chkbabycarriage != 'null') {
						$('div[class="result"]').append('<p>유모차 대여가능여부: ' + placeContentsDTO.contentsdto.chkbabycarriage + '<br><br>');
					} if (placeContentsDTO.chkcreditcard != 'null') {
						$('div[class="result"]').append('<p>신용카드 사용가능여부: ' + placeContentsDTO.contentsdto.chkcreditcard + '<br><br>');
					} if (placeContentsDTO.chkpet != 'null') {
						$('div[class="result"]').append('<p>애완동물 동반가능여부 : ' + placeContentsDTO.contentsdto.chkpet + '<br><br>');
					}
				}
				
				if (placeContentsDTO.contentTypeId == 39) {
					if (placeContentsDTO.infocenter != 'null') {
						$('div[class="result"]').append('<p>문의 및 안내: ' + placeContentsDTO.contentsdto.infocenterfood + '<br><br>');
					} if(placeContentsDTO.restdate != 'null'){	
						$('div[class="result"]').append('<p>쉬는날: '+placeContentsDTO.contentsdto.restdate+'<br><br>');
					} if (placeContentsDTO.parkingfood != 'null') {
						$('div[class="result"]').append('<p>주차 가능여부: ' + placeContentsDTO.contentsdto.parkingfood + '<br><br>');
					} if(placeContentsDTO.reservationfood != 'null'){	
						$('div[class="result"]').append('<p>예약 안내: '+placeContentsDTO.contentsdto.reservationfood+'<br><br>');
					} if(placeContentsDTO.firstmenu != 'null'){	
						$('div[class="result"]').append('<p>대표메뉴: '+placeContentsDTO.contentsdto.firstmenu+'<br><br>');
					} if (placeContentsDTO.packing != 'null') {
						$('div[class="result"]').append('<p>포장 가능여부: ' + placeContentsDTO.contentsdto.packing + '<br><br>');
					} if (placeContentsDTO.discountinfofood != "null") {
						$('div[class="result"]').append('<p>할인 내용: ' + placeContentsDTO.contentsdto.discountinfofood + '<br><br>');
					} if (placeContentsDTO.chkcreditcardfood != 'null') {
						$('div[class="result"]').append('<p>신용카드 사용가능여부: ' + placeContentsDTO.contentsdto.chkcreditcardfood + '<br><br>');
					} if (placeContentsDTO.kidsfacility != 'null') {
						$('div[class="result"]').append('<p>어린이 놀이방 유무: ' + placeContentsDTO.contentsdto.kidsfacility + '<br><br>');
					} 
				}
				
				
				console.log(placeContentsDTO.contentsdto);
				console.log(placeContentsDTO.contentsdto.infocenterfood);
				console.log(placeContentsDTO.contentsdto.infocenter);
				console.log(placeContentsDTO.infocenter);
				/*
					if(placedto.infocenter != 'null'){	
						$('div[class="result"]').append('<p>문의 및 안내: '+placedto.contentsdto.infocenterfood+'<br><br>');
					} 
					if(placedto.usetime != 'null'){	
						$('div[class="result"]').append('<p>이용시간: '+placedto.contentsdto.usetime+'<br><br>');
					}
					if(placedto.restdate != 'null'){	
						$('div[class="result"]').append('<p>쉬는날: '+placedto.contentsdto.restdate+'<br><br>');
					} 
					if(placedto.chkbabycarriage != 'null'){	
						$('div[class="result"]').append('<p>유모차 대여가능여부 : '+placedto.contentsdto.chkbabycarriage+'<br><br>');
					} 
					if(placedto.chkcreditcard != 'null'){	
						$('div[class="result"]').append('<p>신용카드 사용가능여 부: '+placedto.contentsdto.chkcreditcard+'<br><br>');
					}
					if(placedto.chkpet != 'null'){	
						$('div[class="result"]').append('<p>애완동물 동반가능여부 : '+placedto.contentsdto.chkpet+'<br><br>');
					} 
					
					*/
				//스크롤
				$('div[class="result"]').append(`<div style="position:fixed; bottom:3%; right:-10%;">
				<a href="#"><img src="../img/top.png" width="5%" height="5%"></a>`);
			},
			error: function() { }
		});
	};

});//ready end
