<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/css/user/login.css" />
<link rel="stylesheet" href="/css/reset.css">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../header.jsp"%>

    <div class="container">
        <h2 class="text-center">로그인</h2>
        <form id="login" method="post" action="/login">
            <div class="form-group">
                <label for="userid"></label>
                <input type="text" class="form-control" id="userid" placeholder="아이디를 입력하세요" name="userid">
            </div>
            <div class="form-group">
                <label for="userpw"></label>
                <input type="password" class="form-control" id="userpw" placeholder="비밀번호를 입력하세요" name="userpw">
            </div>
            <button type="submit" class="btn btn-default">로그인</button>
        </form>
        <ul>
	<li id="kakaologin" onclick="kakaoLogin();">
      <a href="javascript:void(0)">
          <img src="/img/kakao_login_medium_wide.png" alt="카카오 로그인"/>
      </a>
	</li>
	<li onclick="kakaoLogout();">
      <a href="javascript:void(0)">
          <span>카카오 로그아웃</span>
      </a>
	</li>
</ul>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('703977c6169e77e695a95fddc13ff62b'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response);
        	  // 사용자 정보 처리
        	  var kakaoUserId = response.id;
        	  var kakaoNickname = response.properties.nickname;
        	  var kakaoProfileImage = response.properties.profile_image;
        	  var kakaoEmail = response.kakao_account.email;
        	  // 처리한 사용자 정보를 서버로 전송하거나 필요한 작업을 수행할 수 있습니다.
          },
          fail: function (error) {
            console.log(error);
          },
        });
      },
      fail: function (error) {
        console.log(error);
      },
    });
  }
function redirectMain() {
    location.href = "/"; // 메인 페이지 URL로 리다이렉트
  }

  Kakao.Auth.login({
    success: function (response) {
      // 로그인 성공 처리
      redirectMain(); // 메인 페이지로 리다이렉트
    },
    fail: function (error) {
      // 로그인 실패 처리
      console.log(error);
    },
  });
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response);
        },
        fail: function (error) {
          console.log(error);
        },
      });
      Kakao.Auth.setAccessToken(undefined);
    }
  }  
</script>


</body>
</html>
