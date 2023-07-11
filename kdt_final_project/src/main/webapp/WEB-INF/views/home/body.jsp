<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/home/body.css">
</head>

<body>
	<!-- body -->
	<%@ include file="../home/slide.jsp"%>

	<div id="recommend">
		<img class="rmenu" src=../img/테마_혼자.png> <img class="rmenu"
			src=../img/테마_연인.png> <img class="rmenu" src=../img/테마_친구.png>
		<img class="rmenu" src=../img/테마_가족.png>
	</div>

	<div id="top5">
		<br>
		<br>
		<h2>여행 기록 TOP5</h2>
		<br>
		<hr>
		<br>
		<div class="recommendtop">
			<img class="tmenu" src=../img/notebook.png>
			<div style="display:inline-block; position: absolute;top:50%;left:30%;"></div>
			<img class="tmenu"src=../img/notebook.png>
		</div>
		
		
		<div class="recommendbottom">
			<img src=../img/notebook.png width="30%">
			<img src=../img/notebook.png width="30%">
			<img src=../img/notebook.png width="30%">
		</div>
		
	</div>
	<div id="top5">
		<br>
		<br>
		<h2>추천해주세요 TOP5</h2>
		<br>
		<hr>
		<br>
		<div class="recommendtop">
			<img class="tmenu" src=../img/notebook.png>
			<img class="tmenu" src=../img/notebook.png>
		</div>
		<div class="recommendbottom">
			<img  src=../img/notebook.png width="30%">
			<img  src=../img/notebook.png width="30%">
			<img  src=../img/notebook.png width="30%">
		</div>
		<!-- <div >
<img style="display: inline-box" src=../img/notebook.png width="18%">
<img style="display: inline-box" src=../img/notebook.png width="18%">
<img style="display: inline-box" src=../img/notebook.png width="18%">
<img style="display: inline-box" src=../img/notebook.png width="18%">
<img style="display: inline-box" src=../img/notebook.png width="18%"> 
</div> -->
	</div>
	<br>
	<br>

	<!-- <div id="topbutton" style="">
<a href="#"><img id="topbuttonimg"src="../img/top.png"></a>
</div> -->

</body>
</html>