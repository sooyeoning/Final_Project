<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>위트</title>
<link rel="icon" href="images/favicon.png">
<link rel="stylesheet" type="text/css" href="css/reset.css" />
</head>
<body>
<%@ include file="../../views/home/header.jsp"%>
<section>
    <h1>글 상세</h1>
    <h2>카테고리: ${board.board_title}</h2>
    <h2>지역: ${board.place}</h2>
    <h2>제목: ${board.title}</h2>
    <h3>작성자: ${board.writer}</h3>
    <p>내용: ${board.contents}</p>
    <p>작성시간: ${board.writingtime}</p>
    <p>조회수: ${board.views}</p>
    <p>좋아요: ${board.likecount}</p>
</section>
<%@ include file="../../views/home/footer.jsp"%>
<div style="position:fixed; bottom:1%; right:1%;">
<a href="#"><img src="../img/top.png" width="20px" height="20px"></a>
</body>
</html>