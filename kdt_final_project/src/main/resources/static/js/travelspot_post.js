$(document).ready(function() {

	let urlParams = new URL(location.href).searchParams;
	let selectedPlace = urlParams.get('selectedPlace');

	$('#images').click(function() {
		$.ajax({
			url: "/travelspot/post/images",
			type: 'get',
			success: function(server) {
				$('#images').css("color", "#2463d3");
				$('div[class="result"]').html('<img class="images" src="/img/busan.jpg">');
				$('div[class="result"]').append('<img class="images" src="/img/gangwon.jpg">');
				$('div[class="result"]').append(`<div style="position:fixed; bottom:3%; right:-10%;">
				<a href="#"><img src="../images/top.png" width="5%" height="5%"></a>`);
			},
			error: function() { }
		});
	});//image onclick end

	$('#info').click(function() {
		$.ajax({
			url: "/travelspot/post/info",
			type: 'get',
			success: function(server) {
				$('#info').css("color", "#2463d3");
				//지도 
				$('div[class="result"]').html('<div id="map" style="width:100%; height:400px;"></div><br>');

				//마커 표시
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
					mapOption = {
						center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
						level: 3 // 지도의 확대 레벨
					};

				var map = new kakao.maps.Map(mapContainer, mapOption);

				// 마커가 표시될 위치입니다 
				var markerPosition = new kakao.maps.LatLng(33.450701, 126.570667);

				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({ position: markerPosition });

				// 마커가 지도 위에 표시되도록 설정합니다
				marker.setMap(map);

				var iwContent = '<div style="padding:5px;">관광지명 <br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
					iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

				// 인포윈도우를 생성합니다
				var infowindow = new kakao.maps.InfoWindow({
					position: iwPosition,
					content: iwContent
				});

				// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
				infowindow.open(map, marker);
				//상세정보
				$('div[class="result"]').append('<p>부산 지하철 1호선인 자갈치역 7번출구와 남포동역 1번출구에 인접한 곳이다. 1945년 광복이 되자 일본인들이 철수하면서 전시 물자를 팔아 돈을 챙기기 위해 국제시장 자리를 장터로 삼으면서 시장이 형성되었다. 한국전쟁 후 피난민들이 장사를 하며 활기를 띠었고, 미군의 군용 물자와 함께 부산항으로 밀수입된 온갖 상품들이 이곳을 통해 전국으로 공급되었다. 이른바 도떼기시장이 바로 국제시장이었다.구제시장 골목, 팥빙수 골목, 화장품 골목, 먹자골목, 소품골목 등등 정말 다양한 볼거리가 있다. 본래는 한국 광복 후 일본인들이 철수하면서 전시 물자를 팔아 돈을 벌려고 장터에 자리를 잡으면서 시장이 형성되었다고 한다. 한국 전쟁 후에는 피난민들이 장사를 하며 시장이 활성화 되었으며, 부산항으로 수입된 온갖 상품들이 이 곳을 통해 전국으로 공급되고 있다. 주력 품목은 기계공구, 주방기구, 의류이며, 미로처럼 얽힌 골목에 각종 점포들이 들어서 있다. 도·소매 시장으로 1 ~ 6공구로 나누어져 있다. 국제시장의 오른쪽으로 가면 구제상품을 파는 상가들이 있고, 왼쪽에는 일명 깡통시장이라 불리는 곳이 나온다. 특히 구제시장의 어느 골목들에서는 상태가 그리 좋지않은 빈티지 상품들을 바닥에 쌓아놓고 저렴한 가격에 판매한다.</p>');
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