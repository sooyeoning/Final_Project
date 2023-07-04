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
					<li><a href="#section7">회원 탈퇴</a></li>
				</ul>
			</nav>
			<div class="side-menu-form" id="section1">
				<h1>회원 정보 조회 및 수정</h1>
				<form action="updateUser" method="post" enctype="multipart/form-data">
				<!-- 회원 번호는 숨겨진 필드 -->
				<input type="hidden" name="id" id="id" value="${user.id}">
				
				<!-- 프로필 이미지를 선택 -->
				<img id="preview" src="" alt="프로필 미리보기">
                <label for="profileImage">프로필 이미지 업로드</label>
                <input type="file" name="profileImage" id="profileImage" onchange="previewImage(event)">
				
				<!-- 회원 정보 필드 -->		
				<label for="username">이름</label> 
				<input type="text" name="username" id="username" value="${user.username}">

				<label for="nickname">닉네임</label> 
				<input type="text" name="nickname" id="nickname" value="${user.nickname}"> 
				
				<label for="userid">아이디</label> 
				<input type="text" name="userid" id="userid" readonly value="${user.userid}"> 
						
				<label for="userpw">비밀번호</label> 
				<input type="password" name="userpw" id="userpw" value="${user.userpw}">
				
                <label for="phone">전화번호</label>
				<input type="text" name="phone" id="phone" value="${user.phone}">

				<label for="email">이메일</label> 
				<input type="text" name="email" id="email" value="${user.email}"> 
						
				<label for="mbti">MBTI</label>
				<input type="text" name="mbti" id="mbti" value="${user.mbti}">

				<label for="address">상세주소</label> 
				<input type="text" name="address" id="address" value="${user.address}">
				<label for="address2">상세주소2</label> 
				<input type="text" name="address2" id="address2" value="${user.address2}"> 
				
				<input type="submit" value="회원 정보 수정">
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
			
			<!-- 회원 탈퇴 -->
            <div class="side-menu-form withdraw-section" id="section7" style="display: none;">
            <h1>회원 탈퇴</h1>
            <p class="red-text">회원 탈퇴 시에 작성했던 게시글 및 댓글과 같은 내역들이 모두 삭제됩니다.<br>
            <span>회원 탈퇴</span>를 하시겠습니까?</p>
            <form action="withdrawUser" method="post">
            <input type="submit" value="회원 탈퇴">
            </form>
            </div>
		</div>
	</div>
	
<script>
    // 이미지 선택 시 미리보기 기능을 위한 JavaScript 함수
    function previewImage(event) {
        var file = event.target.files[0];
        var reader = new FileReader();

        reader.onload = function() {
            var preview = document.getElementById('preview');
            preview.src = reader.result;
        }

        if (file) {
            reader.readAsDataURL(file);
        }
    }
</script>
<%@ include file="../footer.jsp"%>
</body>
</html>