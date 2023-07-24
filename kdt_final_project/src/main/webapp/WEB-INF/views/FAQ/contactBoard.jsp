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

							<td class="title" onclick="toggleContents('${dto.id}')">${dto.title}</td>
							<td>
							<div class="content" style="display: none;" id="content_${dto.id}">${dto.contents}
							</div>
							</td>
							<td>${dto.writingtime}</td>
							<td>${dto.writer}</td>
							<td>${dto.categories}</td>
							<td>
								<a href="/updateForm?id=${dto.id }">수정</a>
							</td>
							<td>
								<button onclick="deleteArticle(${dto.id})">삭제</button>
							</td>
							<%-- 						<td><c:out value="${dto.imageFileName}"/></td> --%>

						</tr>
					</c:forEach>
				</table>

				<div class="faqbtn">
					<a href="/FAQ"><h2>문의 작성</h2></a>
				</div>


			</div>
		</div>

	</div>

	<!-- top button -->
	<%@ include file="../home/topbutton.jsp"%>

	<!-- footer -->
	<%@ include file="../home/footer.jsp"%>

</body>

<!-- JavaScript -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
  function toggleContents(id) {
    var content = document.getElementById(`content_${id}`);
    if (content) {
      if (content.style.display === 'none') {
        content.style.display = 'block';
      } else {
        content.style.display = 'none';
      }
    }
  }
</script>

<script>
    // JavaScript 함수를 통해 게시물 삭제 요청 전송
    function deleteArticle(id) {
        if (confirm("정말로 삭제하시겠습니까?")) {
            // AJAX를 사용하여 서버로 삭제 요청 전송
            $.ajax({
                url: '/deleteArticle',
                method: 'POST',
                data: {id: id},
                success: function (response) {
                    // 성공적으로 삭제됐을 때 처리할 내용
                    alert('게시물이 삭제되었습니다.');
                    window.location.reload(); 
                    window.location.href = "/selectFAQs";
                    // 필요한 경우 삭제 후 추가적인 작업을 수행할 수 있습니다.
                },
                error: function (error) {
                    // 삭제 요청 실패 또는 오류 발생 시 처리할 내용
                    alert('게시물 삭제에 실패했습니다. 다시 시도해주세요.');
                    // 필요한 경우 에러 처리를 위한 추가적인 작업을 수행할 수 있습니다.
                }
            });
        }
    }
</script>

<script>
  // "제목" 클릭 시 해당 "내용" td가 토글되도록 이벤트 처리
  $(document).ready(function() {
    // 모든 클래스명이 "title"인 요소들에 대해 클릭 이벤트 등록
    $(".title").click(function() {
      var id = this.id.split("_")[1]; // 클릭한 요소의 ID에서 숫자 부분 추출
      toggleContents(id); // 추출한 ID를 이용하여 toggleContents 함수 호출
    });
  });
</script>
