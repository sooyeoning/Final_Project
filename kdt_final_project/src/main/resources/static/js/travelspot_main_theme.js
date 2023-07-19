$(document).ready(function(){
	
	//js url parameter 가져오기
	let urlParams = new URL(location.href).searchParams;
	let theme = urlParams.get('theme');
	
	//선택된 지역명 selectedRegion
	//지역명 클릭시 화면 이동 및 글자색상 변경
	$(".regionName").click(function(){
		$(this).css("color","#2463d3"); 
		let areaCode = $(this).attr("id");
		location.href="http://localhost:8099/travelspot/list_theme?areaCode="+areaCode;
		
		//이동 - ajax 이용하지 않으면 theme 변수 같이 넘겨줘야해
		
		/* ajax-페이징
		$.ajax({
			url: "http://localhost:8099/travelspot/list_theme?areaCode="+areaCode,
			data: {theme : theme, page: "1"},
			type: "get",
			success: function(map){
				
			}
			
		})*/
	})//click end
	
	
})//ready end