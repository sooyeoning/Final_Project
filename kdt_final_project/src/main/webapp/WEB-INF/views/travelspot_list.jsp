<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행지 목록</title>
<script src="http://localhost:8099/js/jquery-3.6.4.min.js"></script>

<link href="/css/import.css" rel="stylesheet" type="text/css"/>
<script src="http://localhost:8099/js/travelspot_list.js"></script>

</head>
<body>
<jsp:include page="../views/header.jsp" />

<!-- 6개씩 배치-->
<div class="regionContainer">
	<div class="regionItem-list">
 	<p class="font_content regionName" id="32">강원</p>
		<div class="box-list">	
   		<img class="profile" id="32" src="/img/gangwon.jpg">
  		</div>
  	</div>
	<div class="regionItem-list">
 	<p class="font_content regionName" id="6">부산</p>
		<div class="box-list">
   		<img class="profile" id="6" src="/img/busan.jpg">
  		</div>
	</div>
	<div class="regionItem-list">
 	<p class="font_content regionName" id="2">인천</p>
		<div class="box-list">
   		<img class="profile" id="2" src="/img/incheon.jpg">
  		</div>
	</div>
	<div class="regionItem-list">
 	<p class="font_content regionName" id="jeju">제주도</p>
		<div class="box-list">
   		<img class="profile" id="jeju" src="/img/jeju.jpg">
  		</div>
	</div>
	<div class="regionItem-list">
 	<p class="font_content regionName" id="jeonnam">전라남도</p>
		<div class="box-list">
   		<img class="profile" id="jeonnam" src="/img/jeonnam.jpg">
  		</div>
	</div>
	<div class="regionItem-list">
 	<p class="font_content regionName" id="gyeongnam">경상남도</p>
		<div class="box-list">
   		<img class="profile" id="gyeongnam" src="/img/gyeongnam.jpg">
  		</div>
	</div>
</div>
<br>
<hr class="hrmargin">

<div class="container">

  <div class="item">
 	<img class="placeprofile" src="/img/gyeongnam.jpg" id="anban">
  	<p class="placeName font_title" id="anban">안반데기</p>
  	<h1 class="placeLocation font_content" id="anban">장소명</h1>
  </div>
 <div class="item">
 	<img class="placeprofile" src="/img/jeonnam.jpg" id="anban">
  	<p class="placeName font_title" id="anban">안반데기</p>
  	<h1 class="placeLocation font_title" id="anban">장소명</h1>
  </div>
  <div class="item">
 	<img class="placeprofile" src="/img/gyeongnam.jpg" id="anban">
  	<p class="placeName font_title" id="anban">안반데기</p>
  	<h1 class="placeLocation font_title" id="anban">장소명</h1>
  </div>
 <div class="item">
 	<img class="placeprofile" src="/img/jeonnam.jpg" id="anban">
  	<p class="placeName font_title" id="anban">안반데기</p>
  	<h1 class="placeLocation font_title" id="anban">장소명</h1>
  </div>
   <div class="item">
 	<img class="placeprofile" src="/img/gyeongnam.jpg" id="anban">
  	<p class="placeName font_title" id="anban">안반데기</p>
  	<h1 class="placeLocation font_title" id="anban">장소명</h1>
  </div>
 <div class="item">
 	<img class="placeprofile" src="/img/jeonnam.jpg" id="anban">
  	<p class="placeName font_title" id="anban">안반데기</p>
  	<h1 class="placeLocation font_title" id="anban">장소명</h1>
  </div>
</div>

<!-- 스크롤: 위치 수정 필요 -->
<div style="position:fixed; bottom:1%; right:1%;">
<a href="#"><img src="../img/top.png" width="20px" height="20px"></a>
</div>
</body>
</html>