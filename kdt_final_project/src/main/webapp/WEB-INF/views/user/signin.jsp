<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/css/user/login.css" />
<link rel="stylesheet" href="/css/reset.css">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../header.jsp"%>

    <div class="container">
        <h2 class="text-center">회원가입</h2>
        <form id="signupForm" method="post">
        
        <div class="form-group">
                <label for="username"></label>
                <input type="text" class="form-control" id="username" placeholder="이름을 입력하세요" name="username">
            </div>
            
            <div class="form-group">
                <label for="nickname"></label>
                <input type="text" class="form-control" id="nickname" placeholder="닉네임을 입력하세요" name="nickname">
            </div>
            
            <div class="form-group">
                <label for="userid"></label>
                <input type="text" class="form-control" id="userid" placeholder="아이디를 입력하세요" name="userid">
            </div>
            
            <div class="form-group">
                <label for="userpw"></label>
                <input type="password" class="form-control" id="userpw" placeholder="비밀번호를 입력하세요" name="userpw">
            </div>
            
            <div class="form-group">
                <label for="phone"></label>
                <input type="text" class="form-control" id="phone" placeholder="전화번호를 입력하세요" name="phone">
            </div>
            
            <div class="form-group">
                <label for="email"></label>
                <input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요" name="email">
            </div>
            
            <div class="form-group">
				<label for="mbti"></label> <input type="text"
				class="form-control" id="mbti" name="mbti" placeholder="MBTI">
			</div>

			<div class="form-group">
				<label for="address" class="sr-only"></label>
				<div class="input-container">
				<input type="text" class="form-control input-field" id="address"
				name="address" placeholder="상세주소">
				<button class="btn btn-primary input-button">검색</button>
			</div>
			
			</div>
			<div class="form-group">
				<label for="address2"></label> <input type="text"
				class="form-control" id="address2" placeholder="상세주소2">
			</div>
						
            <button type="button" class="btn btn-default" id="signupbtn">회원가입</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <script>
    $(document).on('click', '#signupbtn', function() {
  	  
  	  $.ajax({
  	    url: "/signin", 
  	    type: "POST",
  	    data: $("#signupForm").serialize(),
  	    success: function(response) {
  	      console.log("success response:",response);
  	      alert("회원가입이 완료되었습니다.");
  	      window.location.href = "/"; 
  	    },
  	    error: function(jqXHR, textStatus, errorThrown) {
  	      console.log("error response:",jqXHR,textStatus,errorThrown);
  	      alert("회원가입 중 오류가 발생했습니다. 다시 시도해주세요.");
  	    }
  	  });
  	});
    </script>
</body>
</html>
