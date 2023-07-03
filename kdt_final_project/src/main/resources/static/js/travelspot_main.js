$(document).ready(function(){
	
	//선택된 지역명 selectedRegion
	//지역명 클릭시 화면 이동 및 글자색상 변경
	$(".regionName").click(function(){
		$(this).css("color","#2463d3"); 
		let areaCode = $(this).attr("id");
		location.href="http://localhost:8099/travelspot/list?areaCode="+areaCode//이동
	})//click end
		
	//이미지 선택시 화면 이동 및 테두리 생성
	$(".box").click(function(){
		$(this).css("border","4px solid #2463d3"); 
		let areaCode = $(this).attr("id");
		location.href="http://localhost:8099/travelspot/list?areaCode="+areaCode//이동
	})

	//선택했다가 뒤로 되돌아오면 글자 색상 원래대로, 테두리 원래대로 변경 추가
	
	
	
})//ready end