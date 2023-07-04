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
 <link rel="stylesheet" href="searchForm.css">
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
 	<p class="font_content regionName" id="5">광주</p>
		<div class="box-list">
   		<img class="profile" id="5" src="/img/jeju.jpg">
  		</div>
	</div>
	<div class="regionItem-list">
 	<p class="font_content regionName" id="7">울산</p>
		<div class="box-list">
   		<img class="profile" id="7" src="/img/jeonnam.jpg">
  		</div>
	</div>
	<div class="regionItem-list">
 	<p class="font_content regionName" id="31">경기</p>
		<div class="box-list">
   		<img class="profile" id="31" src="/img/gyeongnam.jpg">
  		</div>
	</div>
</div>
<br>
<hr class="hrmargin">

<div class="container">

<c:forEach items="${placelist }" var="placeDTO">
 <div class="item">
 	<img class="placeprofile" src=${placeDTO.image1} id=${placeDTO.contentId}>
  	<p class="placeName font_title" id=${placeDTO.contentId}> ${placeDTO.title}</p>
  	<h1 class="placeLocation font_content" id=${placeDTO.contentId}>${placeDTO.address}</h1>
  </div>
</c:forEach>
 
</div>
	<!-- 검색창 -->
	<form action="/search" method="get" class="search-form">
    <input type="text" id="search-input" name="q" class="search-input" placeholder="검색어를 입력하세요...">
    <input type="submit" value="검색" class="search-button">
  </form>
  
   <%
   int areaCode = (Integer)request.getAttribute("areaCode");
   int totalCnt = (Integer)request.getAttribute("totalCnt");
   int totalPage = 0;
   if(totalCnt%9==0){
	   totalPage = totalCnt/9;
   }else {
	   totalPage = (totalCnt/9) +1;
   }%>
   <div class="pages">
   <% for(int i=1; i<=totalPage; i++){  %>
	   <a href="list?areaCode=<%=areaCode %>&page=<%=i %>"><font size="3px"><%=i %></font> &nbsp;&nbsp;</a>	   
  <% } %>
  </div>
  
<!-- 스크롤: 위치 수정 필요 -->
<div style="position:fixed; bottom:1%; right:1%;">
<a href="#"><img src="../img/top.png" width="20px" height="20px"></a>

</div>
</body>
</html>