<%@ page import="travelspot.PlaceDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행지 추천 메뉴</title>
<script src="http://localhost:8099/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9a02700d6a520b1b4d23a9886f1160e0"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>
<script src="http://localhost:8099/js/travelspot_post.js"></script>
<script src="http://localhost:8099/js/travelspot_comment.js"></script>

<link href="/css/import.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<%@ include file="../views/home/header.jsp"%>

<%-- <% //ModelAndView attribute으로 전달한 매개변수 받기
PlaceDTO placedto = (PlaceDTO)request.getAttribute("placedto");
double mapx = placedto.getMapx(); //위도
double mapy = placedto.getMapy();//경도
String title = placedto.getTitle();
%>
 --%>
 
<!-- 관광명소이름 -->
<div class="font_title margin"> ${placedto.title} </div>

<!-- 관광명소 메뉴바 -->
<hr class="hrmargin">
<div class="postmenu">
<p class="font_content" id="images">여행지 사진 모아보기</p>
<p class="font_content" id="info">여행지 상세정보</p>
<p class="font_content" id="comments">여행지 한줄평 남기기</p>
</div>
<hr class="hrmargin">

<div class="result"> </div><!-- ajax 이용 결과물 출력하는 곳 -->

<div style="position:fixed; bottom:3%; right:-10%;">
<a href="#"><img src="../img/top.png" width="5%" height="5%"></a></div>
<!-- 개선사항 -->
<!-- 여행지 사진 모아보기 아래 구분선만 색 변경x -->
<!-- 댓글 작성하는 textarea 글씨(not bod)로 변경-->
<!-- 버튼: 좋아요 (신고버튼) -->
</body>
</html>