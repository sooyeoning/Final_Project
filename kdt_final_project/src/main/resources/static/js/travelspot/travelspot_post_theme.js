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

	//좋아요 클릭
	$("#like").click(function() {
		if (document.getElementById('like_id').value == "null") {
			alert("찜하기 기능은 로그인 후 사용가능합니다.")
		} else {
			$.ajax({
				url: "/travelspot/themepost/likes?contentId=" + contentId,
				type: 'get',
				success: function(response) {
					if ($.trim(response) == "success") {	
						alert("해당 관광지에 좋아요를 누르셨습니다.");
					} else if($.trim(response) == "alreadyliked"){
						//취소
						if(confirm("좋아요를 취소하시겠습니까?")){
							$.ajax({
								url: "/travelspot/themepost/cancelLikes?contentId="+contentId,
								type: 'get',
								success: function(response){
									if($.trim(response) == "success"){
										alert("정상적으로 취소되었습니다.");
									}
								}
							})
						}
					} 		
					
				},//success
				error: function() { }

			})//ajax
		}
	});

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
			url: "/travelspot/post/themeinfo?contentId=" + contentId,
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

				var iwContent = 
				`<div style="padding:5px; width:fit-content; height:fit-content;">` + placeContentsDTO.title +
				`<br><a href="https://map.kakao.com/link/map/` + title + `,` + mapy + `,` + mapx + `" style="color:blue" target="_blank">큰지도보기</a> 
				<a href="https://map.kakao.com/link/to/`+ title + `,` + mapy + `,` + mapx + `"style="color:blue" target="_blank">길찾기</a></div>`;
				
				iwPosition = new kakao.maps.LatLng(mapy, mapx); //인포윈도우 표시 위치입니다

				// 인포윈도우를 생성합니다
				var infowindow = new kakao.maps.InfoWindow({
					position: iwPosition,
					content: `<div style="padding:5px; width:fit-content; height:fit-content;">` + placeContentsDTO.title +
						`<br><a href="https://map.kakao.com/link/map/` + title + `,` + mapy + `,` + mapx + `" style="color:blue" target="_blank">큰지도보기</a> 
					<a href="https://map.kakao.com/link/to/`+ title + `,` + mapy + `,` + mapx + `"style="color:blue" target="_blank">길찾기</a></div>`
				});

				// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
				infowindow.open(map, marker);
							
				// 기본상세정보
				if (placeContentsDTO.contents != 'null') {
					$('div[class="result"]').append('<p class="pstyle">관광지 설명<br><hr class="hrdetail"><br>' + placeContentsDTO.contents + '<br><br>');
				}
				if (placeContentsDTO.homepage != 'null') {
					$('div[class="result"]').append('<p class="pstyle">관광지 대표 홈페이지<br><hr class="hrdetail"><br>' + placeContentsDTO.homepage + '<br><br>');
				}

				dto = placeContentsDTO.contentsdto;

				//관광지 세부정보: 12
				if (placeContentsDTO.contentTypeId == 12) {
					if (dto.infocenter != null || dto.infocenter != "null") {
						$('div[class="result"]').append('<p class="pstyle">문의 및 안내<br><hr class="hrdetail"><br>' + dto.infocenter + '<br><br>');
					} if (dto.usetime != 'null') {
						$('div[class="result"]').append('<p class="pstyle">이용시간<br><hr class="hrdetail"><br>' + dto.usetime + '<br><br>');
					} if (dto.restdate != null || dto.restdate != "null") {
						$('div[class="result"]').append('<p class="pstyle">쉬는날<br><hr class="hrdetail"><br>' + dto.restdate + '<br><br>');
					} if (dto.chkbabycarriage != 'null') {
						$('div[class="result"]').append('<p class="pstyle">유모차 대여가능여부<br><hr class="hrdetail"><br>' + dto.chkbabycarriage + '<br><br>');
					} if (dto.chkcreditcard != 'null') {
						$('div[class="result"]').append('<p class="pstyle">신용카드 사용가능여부<br><hr class="hrdetail"><br>' + dto.chkcreditcard + '<br><br>');
					} if (dto.chkpet != 'null') {
						$('div[class="result"]').append('<p class="pstyle">애완동물 동반가능여부<br><hr class="hrdetail"><br>' + dto.chkpet + '<br><br>');
					}
				}

				//식당 세부정보: 39
				if (placeContentsDTO.contentTypeId == 39) {
					if (dto.infocenter != null || dto.infocenter != "null") {
						$('div[class="result"]').append('<p style="font-weight: bold;">문의 및 안내<br> ' + dto.infocenterfood + '<br><br>');
					} if (dto.restdate != null || dto.restdate != "null") {
						$('div[class="result"]').append('<p>쉬는날<br>' + dto.restdate + '<br><br>');
					} if (dto.parkingfood != null || dto.parkingfood != "null") {
						$('div[class="result"]').append('<p>주차 가능여부<br> ' + dto.parkingfood + '<br><br>');
					} if (dto.reservationfood != null || dto.reservationfood != "null") {
						$('div[class="result"]').append('<p>예약 안내<br> ' + dto.reservationfood + '<br><br>');
					} if (dto.firstmenu != null || dto.firstmenu != "null") {
						$('div[class="result"]').append('<p>대표메뉴<br>' + dto.firstmenu + '<br><br>');
					} if (dto.packing != null || dto.packing != "null") {
						$('div[class="result"]').append('<p>포장 가능여부<br> ' + dto.packing + '<br><br>');
					} if (dto.discountinfofood != null) {
						$('div[class="result"]').append('<p>할인 내용<br> ' + dto.discountinfofood + '<br><br>');
					} if (dto.chkcreditcardfood != null || dto.chkcreditcardfood != "null") {
						$('div[class="result"]').append('<p>신용카드 사용가능여부<br> ' + dto.chkcreditcardfood + '<br><br>');
					} if (dto.kidsfacility != null || dto.kidsfacility != "null") {
						$('div[class="result"]').append('<p>어린이 놀이방 유무<br> ' + dto.kidsfacility + '<br><br>');
					}
				}

				//문화시설 세부정보: 14
				if (placeContentsDTO.contentTypeId == 14) {
					if (dto.infocenterculture != null) {
						$('div[class="result"]').append('<p>문의 및 안내<br><hr class="hrdetail"><br>' + dto.infocenterculture + '<br><br>');
					} if (dto.usefee != null) {
						$('div[class="result"]').append('<p>이용요금<br><hr class="hrdetail"><br>' + dto.usefee + '<br><br>');
					} if (dto.discountinfo != "null") {
						$('div[class="result"]').append('<p>할인 내용<br><hr class="hrdetail"><br> ' + dto.discountinfo + '<br><br>');
					} if (dto.chkcreditcardculture != 'null') {
						$('div[class="result"]').append('<p>신용카드 사용가능여부<br><hr class="hrdetail"><br>' + dto.chkcreditcardculture + '<br><br>');
					} if (dto.usetimeculture != 'null') {
						$('div[class="result"]').append('<p>이용시간<br><hr class="hrdetail"><br> ' + dto.usetimeculture + '<br><br>');
					} if (dto.restdateculture != 'null') {
						$('div[class="result"]').append('<p>쉬는날<br><hr class="hrdetail"><br> ' + dto.restdateculture + '<br><br>');
					} if (dto.accomcountculture != 'null') {
						$('div[class="result"]').append('<p>수용인원<br><hr class="hrdetail"><br>' + dto.accomcountculture + '<br><br>');
					} if (dto.parkingculture != 'null') {
						$('div[class="result"]').append('<p>주차 가능여부<br><hr class="hrdetail"><br> ' + dto.parkingculture + '<br><br>');
					} if (dto.parkingfee != 'null') {
						$('div[class="result"]').append('<p>주차요금 안내<br><hr class="hrdetail"><br>' + dto.parkingfee + '<br><br>');
					} if (dto.chkbabycarriageculture != 'null') {
						$('div[class="result"]').append('<p>유모차대여 가능여부<br><hr class="hrdetail"><br>' + dto.chkbabycarriageculture + '<br><br>');
					} if (dto.chkpetculture != 'null') {
						$('div[class="result"]').append('<p>애완동물 동반여부<br><hr class="hrdetail"><br>' + dto.chkpetculture + '<br><br>');
					}
				}

				//레포츠 세부정보: 28
				if (placeContentsDTO.contentTypeId == 28) {
					if (dto.infocenterleports != null) {
						$('div[class="result"]').append('<p>문의 및 안내<br><hr class="hrdetail"><br> ' + dto.infocenterleports + '<br><br>');
					} if (dto.usefeeleports != null) {
						$('div[class="result"]').append('<p>이용요금<br><hr class="hrdetail"><br>' + dto.usefeeleports + '<br><br>');
					} if (dto.reservation != "null") {
						$('div[class="result"]').append('<p>예약 안내<br><hr class="hrdetail"><br> ' + dto.reservation + '<br><br>');
					} if (dto.chkcreditcardleports != 'null') {
						$('div[class="result"]').append('<p>신용카드 사용가능여부<br><hr class="hrdetail"><br> ' + dto.chkcreditcardleports + '<br><br>');
					} if (dto.usetimeleports != 'null') {
						$('div[class="result"]').append('<p>이용시간<br><hr class="hrdetail"><br> ' + dto.usetimeleports + '<br><br>');
					} if (dto.restdateleports != 'null') {
						$('div[class="result"]').append('<p>쉬는날<br><hr class="hrdetail"><br> ' + dto.restdateleports + '<br><br>');
					} if (dto.accomcountleports != 'null') {
						$('div[class="result"]').append('<p>수용인원<br><hr class="hrdetail"><br> ' + dto.accomcountleports + '<br><br>');
					} if (dto.parkingleports != 'null') {
						$('div[class="result"]').append('<p>주차 가능여부<br><hr class="hrdetail"><br> ' + dto.parkingleports + '<br><br>');
					} if (dto.parkingfeeleports != 'null') {
						$('div[class="result"]').append('<p>주차요금 안내<br><hr class="hrdetail"><br> ' + dto.parkingfeeleports + '<br><br>');
					} if (dto.chkbabycarriageleports != 'null') {
						$('div[class="result"]').append('<p>유모차대여 가능여부<br><hr class="hrdetail"><br> ' + dto.chkbabycarriageleports + '<br><br>');
					} if (dto.chkpetleports != 'null') {
						$('div[class="result"]').append('<p>애완동물 동반여부<br><hr class="hrdetail"><br> ' + dto.chkpetleports + '<br><br>');
					}
				}
				//스크롤
				$('div[class="result"]').append(`<div style="position:fixed; bottom:3%; right:-10%;">
				<a href="#"><img src="../img/top.png" width="5%" height="5%"></a>`);
			},
			error: function() { }
		});
	};

});//ready end