<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="User.UserDAO"%>
<%@ page import="User.UserDAOImpl"%>
<%@ page import="User.UserDTO"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/css/user/mypage.css" />
<link rel="stylesheet" href="/css/reset.css">
<script defer="defer" src="js/user/mypage.js"></script>
<head>
<meta charset="UTF-8">
<title>회원정보 조회 및 수정 페이지</title>
</head>

<body>
	<%@ include file="../header.jsp"%>

	<div class="container">
		<div class="side-menu">
			<!-- 왼쪽 사이드 메뉴 추가 -->
			<nav class="side-menu-nav">
				<ul>
					<li><a href="#section1">회원 정보 수정</a></li>
					<li><a href="#section2">글쓴 내역</a></li>
					<li><a href="#section3">댓글 쓴 내역</a></li>
					<li><a href="#section4">최근 방문한 페이지</a></li>
					<li><a href="#section5">찜한 여행지</a></li>
					<li><a href="#section6">좋아요 누른 게시글</a></li>
				</ul>
			</nav>
			<div class="side-menu-form" id="section1">
				<h1>회원 정보 조회 및 수정</h1>
				<form action="updateUser" method="post">

	<!-- 				<div class="profileImgPreview">
						<img id="preview" class="preview-img" src="/img/profileimg.png"
							alt="프로필 이미지">
					</div>
					<input type="file" name="profileImg" id="profileImg"
						style="display: none">  -->
												<label for="id">회원번호</label> <input
						type="text" name="id" id="id" value="${user.id}">
						
						<label for="username">이름</label> <input
						type="text" name="username" id="username" value="${user.username}">

					<label for="nickname">닉네임</label> <input type="text"
						name="nickname" id="nickname" value="${user.nickname}"> <label
						for="userid">아이디</label> <input type="text" name="userid"
						id="userid" readonly value="${user.userid}"> <label
						for="userpw">비밀번호</label> <input type="password" name="userpw"
						id="userpw" value="${user.userpw}"> <label for="phone">전화번호</label>
					<input type="text" name="phone" id="phone" value="${user.phone}">

					<label for="email">이메일</label> <input type="text" name="email"
						id="email" value="${user.email}"> <label for="mbti">MBTI</label>
					<input type="text" name="mbti" id="mbti" value="${user.mbti}">

					<label for="address">상세주소</label> <input type="text" name="address"
						id="address" value="${user.address}"> <label
						for="address2">상세주소2</label> <input type="text" name="address2"
						id="address2"<%-- value="${user.username}" --%>> <input
						type="submit" value="회원 정보 수정">
				</form>
			</div>

			<!--   글쓴 내역  -->
			<div class="side-menu-form" id="section2" style="display: none;">

			</div>
			<!-- 댓글 쓴 내역 -->
			<div class="side-menu-form" id="section3" style="display: none;">

			</div>
			<!-- 최근 방문한 페이지 -->
			<div class="side-menu-form" id="section4" style="display: none;">

			</div>
			<!-- 찜한 여행지 -->
			<div class="side-menu-form" id="section5" style="display: none;">

			</div>
			<!-- 좋아요 누른 게시물 -->
			<div class="side-menu-form" id="section6" style="display: none;">

			</div>

		</div>
	</div>
	<div class="footer">
		<p>푸터 © 2023</p>
	</div>
</body>
</html>