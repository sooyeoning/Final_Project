<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행지 목록</title>
<script src="http://localhost:8099/js/jquery-3.6.4.min.js"></script>

<link href="/css/import.css" rel="stylesheet" type="text/css" />
<!--<link rel="stylesheet" href="searchForm.css">-->
<script src="http://localhost:8099/js/travelspot_list.js"></script>

</head>
<body>
<%@ include file="../views/home/header.jsp"%>

	<%
	String[] themes = new String[] { "alone", "couple", "friends", "family" };
	%>

	<!-- 6개씩 배치-->
	<div class="themeContainer">
		<%
		for (int i = 0; i < themes.length; i++) {
		%>
		<div class="themeItem-list">
			<p class="font_content regionName" id=<%=themes[i]%>><%=themes[i]%></p>
			<div class="box-list">
				<a href="list_theme?theme=<%=themes[i]%>&page=1"><img class="themeprofile" id=<%=themes[i]%> src="/img/<%=themes[i]%>.png"></a>
			</div>
		</div>
		<%
		}
		%>
	</div>
	<br>
	<hr class="hrmargin">

	<div class="container">
		<c:forEach items="${placelist }" var="placeDTO">
			<div class="item">
				<img class="placeprofile" src=${placeDTO.image1} id=${placeDTO.contentId}>
				<p class="placeName font_title" id=${placeDTO.contentId}>${placeDTO.title}</p>
				<h1 class="placeLocation font_content" id=${placeDTO.contentId}>${placeDTO.address}</h1>
			</div>
		</c:forEach>
	</div>

	<!-- 스크롤: 위치 수정 필요 -->
	<div style="position: fixed; bottom: 1%; right: 1%;">
		<a href="#"><img src="../img/top.png" width="20px" height="20px"></a>

		<%
		int totalCnt = (Integer)request.getAttribute("totalCnt");
		String theme = String.valueOf(request.getAttribute("theme"));

		int totalPage = 0;
		if (totalCnt % 9 == 0) {
			totalPage = totalCnt / 9;
		} else {
			totalPage = (totalCnt / 9) + 1;
		}
		%>
		<div class="pages">
			<font size="3px"> ◀ </font>
			<%
			for (int i = 1; i <= totalPage; i++) {
				//10페이지 처리
			%>
			<a href="list_theme?theme=<%=theme %>&page=<%=i%>"><font
				size="3px"><%=i%></font> &nbsp;&nbsp;</a>
			<%
			}
			%>
			<font size="3px"> ▶ </font>
			
		</div>

	</div>
</body>
</html>