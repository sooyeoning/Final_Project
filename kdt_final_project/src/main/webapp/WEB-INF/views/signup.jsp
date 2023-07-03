<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/css/reset.css" />
<link rel="stylesheet" href="/css/user/signinform.css" />
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../views/header.jsp"%>
		<form>
		<!-- 로그인 모달 창 -->
		<div class="modal" id="loginModal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- 모달 헤더 -->
					<div class="modal-header">
						<h4 class="modal-title">로그인</h4>
						<button type="button" class="btn-close" id="closeLoginModal"
							data-bs-dismiss="modal" aria-label="Close"></button>
					</div>

					<!-- 모달 바디 -->
					<div class="modal-body">
						<form id="login" method="post" action="/login">
							<div class="mb-3">
								<label for="userid" class="form-label"></label> <input
									type="text" class="form-control" id="userid" name="userid"
									placeholder="아이디" required>
							</div>
							<div class="mb-3">
								<label for="userid" class="form-label"></label> <input
									type="password" class="form-control" id="userpw"
									name="userpw" placeholder="비밀번호" required>
							</div>
						</form>
					</div>

					<!-- 모달 푸터 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="loginBtn">로그인</button>
						<button type="button" class="btn btn-secondary"
							id="openSignupFromLogin">회원가입</button>
					</div>
				</div>
			</div>
		</div>
	</form>

	<!-- 회원가입 모달 창 -->
	<div class="modal" id="signupModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- 모달 헤더 -->
				<div class="modal-header">
					<h4 class="modal-title">회원가입</h4>
					<button type="button" class="btn-close" id="closeSignupModal"
						data-bs-dismiss="modal" aria-label="Close"></button>
				</div>

				<!-- 모달 바디 -->
				<div class="modal-body">
					<form id="signupForm" method="post" action="/signup">
						<div class="form-group">
							<label for="username"></label> <input type="text"
								class="form-control" id="username" name="username"
								placeholder="이름">
						</div>

						<div class="form-group">
							<label for="nickname"></label> <input type="text"
								class="form-control" id="nickname" name="nickname"
								placeholder="닉네임">
						</div>

						<div class="form-group">
							<label for="userid2"></label> <input type="text"
								class="form-control" id="userid2" name="userid"
								placeholder="아이디">
						</div>

						<div class="form-group">
							<label for="userpw"></label> <input type="password"
								class="form-control" id="userpw2" name="userpw"
								placeholder="비밀번호">
						</div>

						<div class="form-group">
							<label for="phone"></label> <input type="text"
								class="form-control" id="phone" name="phone" placeholder="전화번호">
						</div>

						<div class="form-group">
							<label for="email"></label> <input type="text"
								class="form-control" id="email" name="email" placeholder="이메일">
						</div>

						<div class="form-group">
							<label for="mbti"></label> <input type="text"
								class="form-control" id="mbti" name="mbti" placeholder="MBTI">
						</div>

						<div class="form-group">
							<label for="address" class="sr-only"></label>
							<div class="input-container">
								<input type="text" class="form-control input-field" id="address"
									name="address" placeholder="상세주소">
								<button class="btn btn-primary input-button">검색</button>
							</div>
						</div>
						<div class="form-group">
							<label for="address2"></label> <input type="text"
								class="form-control" id="address2" placeholder="상세주소2">
						</div>
				</div>

				<!-- 모달 푸터 -->
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="signupbtn">회원가입</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" id="closeSignupModal">닫기</button>
				</div>
				</form>

			</div>
		</div>
	</div>
	<div style="position:fixed; bottom:1%; right:1%;">
<a href="#"><img src="../img/top.png" width="5%" height="5%"></a>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
	<script>
	$(document).on('click', '#headerLoginBtn', function() {
	    $('#loginModal').modal('show');
	});
	$(document).on('click', '#headerSignupBtn', function() {
	    $('#signupModal').modal('show');
	});
    $(document).on('click', '#openSignupFromLogin', function() {
        $('#loginModal').modal('hide');
        $('#signupModal').modal('show');
    });
    $(document).on('click', '#closeSignupModal', function() {
        $('#signupModal').modal('hide');
    });
    
    $(document).on('click', '#signupbtn', function() {
    	  
    	  $.ajax({
    	    url: "/signup", 
    	    type: "POST",
    	    data: $("#signupForm").serialize(),
    	    success: function(response) {
    	      console.log("success response:",response);
    	      alert("회원가입이 완료되었습니다.");
    	      $("#signupModal").modal("hide");
    	    },
    	    error: function(jqXHR, textStatus, errorThrown) {
    	      console.log("error response:",jqXHR,textStatus,errorThrown);
    	      alert("회원가입 중 오류가 발생했습니다. 다시 시도해주세요.");
    	    }
    	  });
    	});
    
 // 로그인 버튼 클릭
    $(document).on('click', '#loginBtn', function() {
  	
    const userid = $('#login input[name="userid"]').val();
    const userpw = $('#login input[name="userpw"]').val();
        
        $.ajax({
            url: "/login", 
            type: "POST",
            data: {
            	userid: $('#userid').val(),
                userpw: $('#userpw').val()
                },
                dataType: 'json',
                beforeSend: function(xhr) {
                    xhr.setRequestHeader('Accept', 'application/json');
                }, 
            success: function(response) {
                console.log("success response:", response);
                if(response.status){
                    alert(response.message);
                    $("#loginModal").modal("hide");
                    location.reload();
                }else{
                    alert(response.message);
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
            
                console.log("error response:", jqXHR, textStatus, errorThrown);
                alert("서버에서 오류가 발생했습니다. 다시 시도해주세요.");
            }
        });
    });


	</script>
</body>
</html>