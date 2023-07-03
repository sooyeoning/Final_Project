<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/css/user/mypage.css" />
<link rel="stylesheet" href="/css/reset.css">
<head>
<meta charset="UTF-8">
<title>회원정보 조회 및 수정 페이지</title>
</head>

<body>
<%@ include file="../views/header.jsp"%>

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
  <form action="updateUser.jsp" method="post">
  
    <div class="profileImgPreview">
    <img id="preview" class="preview-img" src="/img/profileimg.png" alt="프로필 이미지">
    </div>
    <input type="file" name="profileImg" id="profileImg" style="display:none">
  
    <label for="username">이름</label>
    <input type="text" name="username" id="username">
        
    <label for="nickname">닉네임</label>
    <input type="text" name="nickname" id="nickname">
        
    <label for="userid">아이디</label>
    <input type="text" name="userid" id="userid" readonly>
        
    <label for="password">비밀번호</label>
    <input type="password" name="password" id="password">
        
    <label for="phone">전화번호</label>
    <input type="text" name="phone" id="phone">
    
    <label for="email">이메일</label>
    <input type="text" name="email" id="email">
    
    <label for="mbti">MBTI</label>
    <input type="text" name="mbti" id="mbti">
    
    <label for="address">상세주소</label>
    <input type="text" name="address" id="address">
    
    <label for="address2">상세주소2</label>
    <input type="text" name="address2" id="address2">

    <input type="submit" value="회원 정보 수정">
  </form>
  </div>
  
  <!--   글쓴 내역  -->
  <div class="side-menu-form" id="section2">
  
  </div>
  <!-- 댓글 쓴 내역 -->
   <div class="side-menu-form" id="section3">
  
  </div>
  <!-- 최근 방문한 페이지 -->
   <div class="side-menu-form" id="section4">
  
  </div>
  <!-- 찜한 여행지 -->
   <div class="side-menu-form" id="section5">
  
  </div>
  <!-- 좋아요 누른 게시물 -->
   <div class="side-menu-form" id="section6">
  
  </div>
  
</div>
</div>
<div class="footer">
  <p>푸터 © 2023</p>
</div>

<script>
function openFileSelector() {
	  const fileInput = document.getElementById('profileImg');
	  fileInput.click();
	}

	document.getElementById('preview').addEventListener('click', openFileSelector);

	document.getElementById('profileImg').addEventListener('change', function(e) {
	  const preview = document.getElementById('preview');
	  const file = e.target.files[0];
	  const reader = new FileReader();

	  reader.onloadend = function() {
	    preview.src = reader.result;
	  }

	  if (file) {
	    reader.readAsDataURL(file);
	  } else {
	    preview.src = "디폴트이미지URL";
	  }
	});
	document.addEventListener('DOMContentLoaded', function () {
		  var sideMenuItems = document.querySelectorAll('.side-menu-nav a');

		  function showContent(e) {
		    e.preventDefault();

		    var currentItem = e.target;
		    var contentId = currentItem.getAttribute('href').substring(1);

		    var contentSections = document.querySelectorAll('.side-menu-form');
		    for (var i = 0; i < contentSections.length; i++) {
		      contentSections[i].style.display = 'none';
		    }

		    var targetContent = document.getElementById(contentId);
		    if (targetContent) {
		      targetContent.style.display = 'block';
		    }
		  }

		  for (var i = 0; i < sideMenuItems.length; i++) {
		    sideMenuItems[i].addEventListener('click', showContent);
		  }
		});

</script>

</body>
</html>
