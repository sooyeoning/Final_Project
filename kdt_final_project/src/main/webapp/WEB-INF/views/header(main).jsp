<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/header.css">
</head>
<body>

<header> 
<div id="body" >
<div class="name">
<a href="javascript:void(0)" id="headerLoginBtn" >로그인</a>
<a href="/signup" id="headerSignupBtn" >회원가입</a>
<a >English</a>
</div>

<a href="/"><img src=../img/logo.png class="logo"></a>
<a href="/travelspot/main"><div class="menu" >여행지 추천</div></a>
<a href="/community"><div class="menu" >커뮤니티</div></a>
<a href="/mypage"><div class="menu" >마이페이지</div></a>
<a href=""><div class="menu" >고객센터</div></a>
<br><br>
</div>
</header>

</body>
</html>