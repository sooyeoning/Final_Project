$(document).ready(function(){
	
	//선택된 지역명(selectedRegion) 흐림 처리 - 첫번째 말고 다른것도 흐림 처리 필요
	let urlParams = new URL(location.href).searchParams;
	let name = urlParams.get('selectedRegion');
	console.log(name);
	let selectedRegion= $(".profile").attr("id");
	if(name === selectedRegion){
		$(`img[id='${name}']`).css("opacity","0.5");
		$(`img[id='${name}']`).css("border","2px solid #2463d3");
	}
	
	//지역명 클릭시 화면 이동 및 글자색상 변경
	$(".placeprofile").click(function(){
		$(this).css("color","#2463d3"); 
		//선택된 지역명 전달
		let selectedPlace = $(this).attr('id');
		location.href="http://localhost:8099/travelspot/post?selectedPlace="+ selectedPlace//이동
	})
	$(".placeName").click(function(){
		$(this).css("color","#2463d3"); 
		let selectedPlace = $(this).attr("id");
		location.href="http://localhost:8099/travelspot/post?selectedPlace="+selectedPlace//이동
	})//click end
	
	$(".placeLocation").click(function(){
		//$(this).css("color","#2463d3"); 
		let selectedPlace = $(this).attr("id");
		location.href="http://localhost:8099/travelspot/post?selectedPlace="+selectedPlace//이동
	})
	
	//선택했다가 뒤로 되돌아오면 글자 색상 원래대로, 테두리 원래대로 변경 추가
	
	
	
})//ready end