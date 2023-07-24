<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>문의 게시판</title>

<link rel="stylesheet" type="text/css" href="css/FAQ/main2.css">

</head>
<body>
	<header>
		<%@ include file="../home/header.jsp"%>
	</header>
	<div class="section-container">
		<div class="left-section">
			<!-- 왼쪽 섹션 -->
			<h2>문의 분류</h2>
			<br>
			<ul class="category-list">
				<li><a href="/FAQ01">일반</a></li>
				<li><a href="/FAQ02">가입 변경/탈퇴</a></li>
				<li><a href="/FAQ03">신고/이용제한</a></li>
				<li><a href="/FAQ04">프로필 관련</a></li>
				<li><a href="/selectFAQs">이용 문의</a></li>
			</ul>
		</div>
		<div class="right-section">
			<h2>이용 문의</h2>
			<div class="tablearea">
				<table>
					<tr>	
						<th id="title">제목</th>
						<th>내용</th>
						<th>작성시간</th>
						<th>작성자</th>
						<th>분류</th>
					</tr>
					<c:forEach items="${boardList}" var="dto">
						<tr>

							<td>${dto.title}</td>
							<td>${dto.contents}</td>
							<td>${dto.writingtime}</td>
							<td>${dto.writer}</td>
							<td>${dto.categories}</td>
							<%-- 						<td><c:out value="${dto.imageFileName}"/></td> --%>

						</tr>
					</c:forEach>
				</table>


			</div>
		</div>

</div>

	<!-- top button -->
	<%@ include file="../home/topbutton.jsp"%>

	<!-- footer -->
	<%@ include file="../home/footer.jsp"%>

</body>

<!-- JavaScript -->
<script>
	function toggleContents() {
		// 해당 행의 "내용" 부분을 가져옴
		var contentRow = event.target.parentElement.nextElementSibling;
		// "내용" 부분을 토글(Toggle)하여 보이거나 숨김
		if (contentRow.style.display === "none") {
			contentRow.style.display = "table-row";
		} else {
			contentRow.style.display = "none";
		}
	}
</script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    // "제목" 클릭 시 해당 "내용" td가 토글되도록 이벤트 처리
    $(document).ready(function () {
        $("#title").click(function () {
            // 클릭한 "제목"의 다음 요소인 "내용" td를 토글 (보이기/숨기기)
            $(this).next().toggle();
        });
    });
</script>
</html>
