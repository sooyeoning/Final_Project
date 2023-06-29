<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="/css/reset.css">
</head>
<body>
<%@ include file="../views/header.jsp"%>


<img src="../img/Mainimg.png" style="width:100%;">

<div style="width: 66%; margin: 0 auto; text-align:center" >
<img style="display: inline-box" src=../img/테마_혼자.png width="24%">
<img style="display: inline-box" src=../img/테마_연인.png width="24%">
<img style="display: inline-box" src=../img/테마_친구.png width="24%">
<img style="display: inline-box" src=../img/테마_가족.png width="24%"> 
</div>

<div style="width: 66%; margin: 0 auto; text-align:center" ><br><br>
<h2>여행 기록 TOP5</h2><br><hr><br>
<div>
<img style="display: inline-box" src=../img/notebook.png width="40%">
<img style="display: inline-box" src=../img/notebook.png width="40%">
</div>
<div>
<img style="display: inline-box" src=../img/notebook.png width="30%">
<img style="display: inline-box" src=../img/notebook.png width="30%">
<img style="display: inline-box" src=../img/notebook.png width="30%"> 
</div>
</div>
<div style="width: 66%; margin: 0 auto; text-align:center" ><br><br>
<h2>추천해주세요 TOP5</h2><br><hr><br>
<div >
<img style="display: inline-box" src=../img/notebook.png width="18%">
<img style="display: inline-box" src=../img/notebook.png width="18%">
<img style="display: inline-box" src=../img/notebook.png width="18%">
<img style="display: inline-box" src=../img/notebook.png width="18%">
<img style="display: inline-box" src=../img/notebook.png width="18%"> 
</div>
</div>

<div style="position:fixed; bottom:1%; right:1%;">
<a href="#"><img src="../img/top.png" width="20px" height="20px"></a>
</div>
<%@ include file="../views/footer.jsp"%>
</body>
</html>