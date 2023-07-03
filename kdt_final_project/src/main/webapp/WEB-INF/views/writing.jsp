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
  .ck-editor__editable { height: 400px; }
  .ck-content { font-size: 16px; }
</style>
</head>
<body>
<%@ include file="../views/header.jsp"%>
<section>
	<h1>글쓰기</h1>
    <form action="/upload" method="POST">
      <textarea name="text" id="editor"></textarea>
    <p><input type="submit" value="전송"></p>
</section>
<script src="https://cdn.ckeditor.com/ckeditor5/38.1.0/classic/ckeditor.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
<script>
  ClassicEditor.create( document.querySelector( '#editor' ), {
	  language: "ko",
	  ckfinder: {uploadUrl : 'upload'}
  } );
</script>
<footer>임시 footer</footer>
<div style="position:fixed; bottom:1%; right:1%;">
<a href="#"><img src="../images/top.png" width="20px" height="20px"></a>
</div>
</body>
</html>