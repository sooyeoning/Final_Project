document.addEventListener('DOMContentLoaded', function() {
	const sideMenuNav = document.querySelector('.side-menu-nav');
	const sideMenuForms = document.querySelectorAll('.side-menu-form');
	const userListTableBody = document.getElementById('boardTableBody');
	const userDetailContainer = document.querySelector('.user-details');
	const deleteUserButton = document.getElementById('deleteUserButton'); // 추가: 회원 탈퇴 버튼
	const reportListTableBody = document.getElementById('reportTableBody');

	showSection('#section1');

	sideMenuNav.addEventListener('click', function(event) {
		event.preventDefault();
		if (event.target.tagName === 'A') {
			const targetSectionId = event.target.getAttribute('href');
			showSection(targetSectionId);
		}
	});

	function showSection(targetSectionId) {
		sideMenuForms.forEach(function(form) {
			if ('#' + form.id === targetSectionId) {
				form.style.display = 'block';
			} else {
				form.style.display = 'none';
			}
		});
	}

	function showUserDetails(event) {
		event.preventDefault();
		const target = event.target;
		if (target.tagName === 'A' && target.classList.contains('user-id-link')) {
			const userid = target.textContent.trim();
			const detailUserId = document.getElementById('detailUserId');
			const detailUserName = document.getElementById('detailUserName');
			const detailUserEmail = document.getElementById('detailUserEmail');
			const detailuserpw = document.getElementById('detailuserpw');
			const detailnickname = document.getElementById('detailnickname');
			const detailphone = document.getElementById('detailphone');
			const detailaddress = document.getElementById('detailaddress');
			const detailaddress2 = document.getElementById('detailaddress2');
			const detailaddress3 = document.getElementById('detailaddress3');
			const detailpostcode = document.getElementById('detailpostcode');

			// AJAX를 통해 서버로 해당 회원의 정보를 요청하고 가져온 후, 아래와 같이 표시하면 됩니다.
			fetch('/adminpage/' + encodeURIComponent(userid))
				.then(response => response.json())
				.then(data => {
					// 서버로부터 받아온 데이터를 사용하여 회원 상세 정보를 동적으로 구성
					detailUserId.textContent = data.userid;
					detailUserName.textContent = data.username;
					detailUserEmail.textContent = data.email;
					detailnickname.textContent = data.nickname;
					detailaddress.textContent = data.address;
					detailaddress2.textContent = data.detailAddress;
					detailaddress3.textContent = data.extraAddress;
					detailpostcode.textContent = data.postcode;
					detailphone.textContent = data.phone;
					detailuserpw.textContent = data.userpw;

					// 섹션 1을 숨기고, 회원 상세 정보를 표시합니다.
					sideMenuForms.forEach(function(form) {
						form.style.display = 'none';
					});
					// 회원 상세 정보를 표시하기 위해 display를 block으로 변경
					userDetailContainer.style.display = 'block';
				})
				.catch(error => console.error('Error fetching user details:', error));
		}
	}

	// 회원 강제 탈퇴 버튼 클릭 이벤트 처리
	deleteUserButton.addEventListener('click', function() {
		const detailUserId = document.getElementById('detailUserId');
		const userid = detailUserId.textContent.trim();

		const confirmation = confirm('정말 ' + userid + '님을 탈퇴시키겠습니까?');
		// AJAX를 통해 해당 회원을 강제 탈퇴시킵니다.
		if (confirmation) {
			fetch('/deleteUser/' + encodeURIComponent(userid), {
				method: 'DELETE',
			})
				.then((response) => response.text())
				.then((data) => {
					// 회원을 성공적으로 탈퇴시킨 경우, 화면에서 해당 회원 정보를 삭제하고 리스트로 돌아갑니다.
					alert(data);
					window.location.href = '/adminpage'; // 회원 리스트로 돌아가기
				})
				.catch((error) => console.error('Error deleting user:', error));
		}
	});

	// 회원 아이디에 클릭 이벤트 리스너 등록
	userListTableBody.addEventListener('click', showUserDetails);

	// 사이드메뉴에서 섹션1 또는 섹션2를 클릭할 때, 회원상세정보 숨기기
	const sectionLinks = sideMenuNav.getElementsByTagName('a');
	for (let i = 0; i < sectionLinks.length; i++) {
		sectionLinks[i].addEventListener('click', function(event) {
			event.preventDefault();
			const targetSectionId = event.target.getAttribute('href');
			if (targetSectionId === '#section1' || targetSectionId === '#section2' || targetSectionId === '#section3') {
				hideUserDetails();
			}
			showSection(targetSectionId);
		});
	}

	// 회원 상세 정보를 숨기는 함수
	function hideUserDetails() {
		userDetailContainer.style.display = 'none';
	}

	function showReportList(reportList) {
		reportListTableBody.innerHTML = '';

		reportList.forEach(function(report) {
			const row = document.createElement('tr');
			row.innerHTML = `
        <td>${report.id}</td>
        <td>${report.commentId}</td>
        <td>${report.reportedNickname}</td>
        <td>${report.userNickname}</td>
        <td>${report.userId}</td>
        <td>${report.reportCategory}</td>
        <td>${report.reportContents}</td>
        <td>${report.regDate}</td>
        <td>${report.contentId}</td>
      `;
			reportListTableBody.appendChild(row);
		});
	}

	// AJAX를 이용하여 서버에서 댓글 신고리스트 데이터를 가져오는 함수
	function fetchReportList() {
		fetch('/getReportList') // 서버의 URL을 올바르게 변경해주세요.
			.then((response) => response.json())
			.then((data) => {
				showReportList(data);
			})
			.catch((error) => console.error('Error fetching report list:', error));
	}

	// 페이지 로딩 시 댓글 신고리스트를 가져와서 표시
	fetchReportList();

	// 댓글 신고리스트 자동 갱신을 위해 일정 주기마다 데이터 가져오기
	//setInterval(fetchReportList, 5000); // 5초마다 자동 갱신 (원하는 주기로 변경 가능)
});
