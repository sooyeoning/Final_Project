<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>여행지 추천 메뉴</title>
<script src="http://localhost:8099/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:8099/js/travelspot_main.js"></script>

<link href="/css/import.css" rel="stylesheet"/>

</head>
<body>
<%@ include file="../views/home/header.jsp"%>

<!-- https://dogcowking.tistory.com/326 -->
<div class="titlebox font_title">가고 싶은 여행지를 선택해주세요</div>

<% 
int[] ids = new int[]{32, 6, 2, 5, 7, 31};
String[] titles = new String[]{"강원", "부산", "인천", "광주", "울산", "경기"};
String[] engtitles = new String[]{"gangwon", "busan", "incheon","gwangju", "ulsan", "gyeonggi"};
%>
<div class="regionContainer">
<% for(int i=0; i<ids.length; i++){%>
 <div class="regionItem">
  <p class="font_content regionName" id=<%=ids[i]%>><%=titles[i] %></p>
 	<div class="box" id=<%=ids[i]%>>
   		<img class="profile" src="/img/<%=engtitles[i] %>.jpg">
  	</div>
  </div>
<%} %>
 </div>



</body>
</html>
