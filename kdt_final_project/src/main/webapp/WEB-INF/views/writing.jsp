<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>위트</title>
<link rel="icon" href="images/favicon.png">
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/writing.css" />
<style>
  .ck-editor__editable { height: 540px; }
  .ck-content { font-size: 16px; }
</style>
</head>
<body>
<%@ include file="../views/header.jsp"%>
<section>
    <form action="/upload" method="POST">
    <input type=text id="title" name=title placeholder="제목"/>
    <select name="teg">
    	<option value="인천">인천</option>
    	<option value="광주">광주</option>
    	<option value="부산">부산</option>
    	<option value="울산">울산</option>
    	<option value="강원">강원</option>
    	<option value="경기도">경기도</option>
    </select>
    <br/>
      <textarea name="text" id="editor"></textarea>
    <p><input type="submit" value="글쓰기" id="submit"></p>
    </form>
</section>
<script src="https://cdn.ckeditor.com/ckeditor5/38.1.0/classic/ckeditor.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
<script>
  ClassicEditor.create( document.querySelector( '#editor' ), {
	  language: "ko",
	  ckfinder: {uploadUrl : 'upload'}
  } );
</script>
<%@ include file="../views/footer.jsp"%>
<div style="position:fixed; bottom:1%; right:1%;">
<a href="#"><img src="../img/top.png" width="20px" height="20px"></a>
</div>
</body>
</html>