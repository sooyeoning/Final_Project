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
            <button type="button" class="btn btn-default" onclick="findId()">아이디 찾기</button>
            <button type="button" class="btn btn-default" onclick="findPassword()">비밀번호 찾기</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
function findId() {
    var email = prompt("이메일을 입력하세요:");
    if (email != null) {
        // 서버로 이메일 정보를 전송하여 아이디 찾기 동작 수행
        // 서버에서 해당 이메일로 아이디를 전송하는 로직을 구현해야 합니다.
        // 예시로 jQuery의 AJAX를 사용하여 서버로 요청을 보내는 방법을 보여드리겠습니다.
        $.ajax({
            url: '/findId',
            method: 'POST',
            data: { email: email },
            success: function(response) {
                alert("아이디가 이메일로 전송되었습니다.");
            },
            error: function(xhr, status, error) {
                alert("아이디 찾기에 실패했습니다.");
            }
        });
    }
}

function findPassword() {
    var userId = prompt("아이디를 입력하세요:");
    var email = prompt("이메일을 입력하세요:");
    if (userId != null && email != null) {
        // 서버로 아이디와 이메일 정보를 전송하여 비밀번호 찾기 동작 수행
        // 서버에서 해당 아이디와 이메일로 임시 비밀번호를 생성하고 이메일로 전송하는 로직을 구현해야 합니다.
        // 예시로 jQuery의 AJAX를 사용하여 서버로 요청을 보내는 방법을 보여드리겠습니다.
        $.ajax({
            url: '/findPassword',
            method: 'POST',
            data: { userId: userId, email: email },
            success: function(response) {
                alert("임시 비밀번호가 이메일로 전송되었습니다.");
            },
            error: function(xhr, status, error) {
                alert("비밀번호 찾기에 실패했습니다.");
            }
        });
    }
}
</script>


</body>
</html>
