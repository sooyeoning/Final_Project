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
<link rel="stylesheet" type="text/css" href="css/community.css" />
<script defer="defer" src="js/jquery-3.6.4.min.js"></script>
<script defer="defer" src="js/community.js"></script>
</head>
<body>
<%@ include file="../views/header.jsp"%>
<div></div>
<section>
	<ul>
		<li id="recordTap" class="on font_title"><a href="">여행기록</a></li>
		<li id="recommendTap" class="font_title"><a href="">추천해주세요</a></li>
	</ul>
	<!-- 검색탭 들어갈 부분 -->
	<article id="record" class="on">
		<ol class="topTen">
			<li id="top1">
				<div class="thumbnail">썸네일 입니다</div>
				<h5 class="title">임시제목입니다</h5>
				<div class="writerinfo">
					<span class="profile"></span>
					<span class="writer">작성자</span>
				</div>
				<div class="info">
					<span class="views">views 120</span>
					<span class="likeCount">like 84</span>
					<span class="wirteTime">2023-06-29</span>
				</div>
			</li>
			<li id="top2">
				<div class="thumbnail">썸네일 입니다</div>
				<h5 class="title">임시제목입니다</h5>
				<div class="writerinfo">
					<span class="profile"></span>
					<span class="writer">작성자</span>
				</div>
				<div class="info">
					<span class="views">views 120</span>
					<span class="likeCount">like 84</span>
					<span class="wirteTime">2023-06-29</span>
				</div>
			</li>
			<li id="top3">
				<div class="thumbnail">썸네일 입니다</div>
				<h5 class="title">임시제목입니다</h5>
				<div class="writerinfo">
					<span class="profile"></span>
					<span class="writer">작성자</span>
				</div>
				<div class="info">
					<span class="views">views 120</span>
					<span class="likeCount">like 84</span>
					<span class="wirteTime">2023-06-29</span>
				</div>
			</li>
			<li id="top4">
				<div class="thumbnail">썸네일 입니다</div>
				<h5 class="title">임시제목입니다</h5>
				<div class="writerinfo">
					<span class="profile"></span>
					<span class="writer">작성자</span>
				</div>
				<div class="info">
					<span class="views">views 120</span>
					<span class="likeCount">like 84</span>
					<span class="wirteTime">2023-06-29</span>
				</div>
			</li>
			<li id="top5">
				<div class="thumbnail">썸네일 입니다</div>
				<h5 class="title">임시제목입니다</h5>
				<div class="writerinfo">
					<span class="profile"></span>
					<span class="writer">작성자</span>
				</div>
				<div class="info">
					<span class="views">views 120</span>
					<span class="likeCount">like 84</span>
					<span class="wirteTime">2023-06-29</span>
				</div>
			</li>
			<li id="top6">
				<div class="thumbnail">썸네일 입니다</div>
				<h5 class="title">임시제목입니다</h5>
				<div class="writerinfo">
					<span class="profile"></span>
					<span class="writer">작성자</span>
				</div>
				<div class="info">
					<span class="views">views 120</span>
					<span class="likeCount">like 84</span>
					<span class="wirteTime">2023-06-29</span>
				</div>
			</li>
			<li id="top7">
				<div class="thumbnail">썸네일 입니다</div>
				<h5 class="title">임시제목입니다</h5>
				<div class="writerinfo">
					<span class="profile"></span>
					<span class="writer">작성자</span>
				</div>
				<div class="info">
					<span class="views">views 120</span>
					<span class="likeCount">like 84</span>
					<span class="wirteTime">2023-06-29</span>
				</div>
			</li>
			<li id="top8">
				<div class="thumbnail">썸네일 입니다</div>
				<h5 class="title">임시제목입니다</h5>
				<div class="writerinfo">
					<span class="profile"></span>
					<span class="writer">작성자</span>
				</div>
				<div class="info">
					<span class="views">views 120</span>
					<span class="likeCount">like 84</span>
					<span class="wirteTime">2023-06-29</span>
				</div>
			</li>
			<li id="top9">
				<div class="thumbnail">썸네일 입니다</div>
				<h5 class="title">임시제목입니다</h5>
				<div class="writerinfo">
					<span class="profile"></span>
					<span class="writer">작성자</span>
				</div>
				<div class="info">
					<span class="views">views 120</span>
					<span class="likeCount">like 84</span>
					<span class="wirteTime">2023-06-29</span>
				</div>
			</li>
			<li id="top10">
				<div class="thumbnail">썸네일 입니다</div>
				<h5 class="title">임시제목입니다</h5>
				<div class="writerinfo">
					<span class="profile"></span>
					<span class="writer">작성자</span>
				</div>
				<div class="info">
					<span class="views">views 120</span>
					<span class="likeCount">like 84</span>
					<span class="wirteTime">2023-06-29</span>
				</div>
			</li>
		</ol>
		<table>
			<thead>			
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>공감수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>0</td>
					<td><a href="">임시 정보 입니다</a></td>
					<td>akm</td>
					<td>12</td>
					<td>8</td>
					<td>2023-06-28</td>
				</tr>
				<tr>
					<td>0</td>
					<td><a href="">임시 정보 입니다</a></td>
					<td>akm</td>
					<td>12</td>
					<td>8</td>
					<td>2023-06-28</td>
				</tr>
				<tr>
					<td>0</td>
					<td><a href="">임시 정보 입니다</a></td>
					<td>akm</td>
					<td>12</td>
					<td>8</td>
					<td>2023-06-28</td>
				</tr>
			</tbody>
		</table>
		<ol class="pageNum">
			<li><a href="">1</a></li>
			<li><a href="">2</a></li>
			<li><a href="">3</a></li>
			<li><a href="">4</a></li>
			<li><a href="">5</a></li>
		</ol>
	</article>
	<article id="recommend">
		<table>
			<thead>			
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>공감수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>0</td>
					<td><a href="">임시 정보 입니다</a></td>
					<td>akm</td>
					<td>12</td>
					<td>8</td>
					<td>2023-06-28</td>
				</tr>
				<tr>
					<td>0</td>
					<td><a href="">임시 정보 입니다</a></td>
					<td>akm</td>
					<td>12</td>
					<td>8</td>
					<td>2023-06-28</td>
				</tr>
				<tr>
					<td>0</td>
					<td><a href="">임시 정보 입니다</a></td>
					<td>akm</td>
					<td>12</td>
					<td>8</td>
					<td>2023-06-28</td>
				</tr>
			</tbody>
		</table>
		<ol class="pageNum">
			<li><a href="">1</a></li>
			<li><a href="">2</a></li>
			<li><a href="">3</a></li>
			<li><a href="">4</a></li>
			<li><a href="">5</a></li>
		</ol>
	</article>
	<a href="/writing" id="writingbtn">글쓰기</a>
</section>

<!-- footer -->
<%@ include file="../views/footer.jsp"%>
<div style="position:fixed; bottom:1%; right:1%;">
<a href="#"><img src="../img/top.png" width="20px" height="20px"></a>
</div>
</body>
</html>