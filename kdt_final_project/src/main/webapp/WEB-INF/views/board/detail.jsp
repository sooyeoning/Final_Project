<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>위트</title>
<link rel="icon" href="img/favicon.png">
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/detail.css" />

<script src="http://localhost:8099/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:8099/js/community/comment.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<%@ include file="../../views/home/header.jsp"%>
<section>
    <span class="main_color">${board.board_title}</span>
    <span>${board.place}</span>
    <h2>${board.title}</h2>
    <div id="infocontainer">
    	<div class="info">    
    		<div id="profile"></div>
    		<span>${board.writer}</span>
    		<span>조회수: ${board.views}</span>
    		<span>좋아요: ${board.likecount}</span>    
    		<span>${board.writingtime}</span>
    	</div>
    <div class="buttons">
    	<c:choose>
        	<c:when test="${board.writer eq nickname}">
            	<a href="/update?boardId=${board.id }">수정</a>
            	<a href="/delete?boardId=${board.id }">삭제</a>
            </c:when>
            <c:otherwise>
                <a href="/board/report?id=${board.id}" class="reportbutton" onclick="checkDuplicateReport(${board.id})">신고</a>
            </c:otherwise>
    	</c:choose>
    </div>
    </div>
    <div id="contents">${board.contents}</div>
    <a class="likebtn" onclick="checkLoginAndHandleLike(${board.id})">like button</a>
    <span id="likeCount">${board.likecount}</span>
    <script>
    	/* const likebtn = document.querySelector(".likebtn");
    	likebtn.addEventListener('click',function(){
    		this.classList.toggle("likeon");
    	}); */
    	
    	// 좋아요 상태를 확인하고 로그인 상태를 체크하는 함수
        function checkLoginAndHandleLike(boardId) {
            $.ajax({
                url: "/api/getLikeStatus?boardId=" + boardId,
                method: "GET",
                success: function(response) {
                    if (response.isLoggedIn) {
                        // 로그인 상태인 경우 좋아요 처리 수행
                        toggleLike(boardId);
                    } else {
                        // 로그인 상태가 아닌 경우 로그인 페이지로 이동
                        window.location.href = "/login";
                    }
                },
                error: function() {
                    alert("서버와 통신 중 오류가 발생했습니다.");
                }
            });
        }

        // 좋아요 처리 함수
        function toggleLike(boardId) {
            $.ajax({
                url: "/toggleLike?boardId=" + boardId,
                method: "POST",
                success: function(response) {
                    // 성공적으로 처리되었을 때의 로직
                    // 예: 버튼 색 변경, 좋아요 수 갱신 등
                    if (response.likeStatus === "liked") {
                        $("#likeButton").text("좋아요 취소");
                    } else {
                        $("#likeButton").text("좋아요");
                    }
                    $("#likeCount").text("좋아요 수: " + response.likeCount);
                },
                error: function() {
                    alert("서버와 통신 중 오류가 발생했습니다.");
                }
            });
        }

    </script>
    
    <!-- 댓글창 추가: 하트 위치 변경 -->
	<p class="main_color">댓글창</p><br>
	<textarea id="content" style="width:100%; resize: none;" rows="4">댓글을 남겨주세요 </textarea><!-- 여백 조정없이 padding 필요 -->
	<input type="text" class="login" value="${nickname }" hidden="hidden">
	<input type="button" class="savebutton" value="저장"><!-- 오른쪽 정렬 -->
	
	<div class="comments"></div>
</section>
<%@ include file="../../views/home/footer.jsp"%>
<div style="position:fixed; bottom:1%; right:1%;">
<a href="#"><img src="../img/top.png" width="20px" height="20px"></a>
</body>
</html>