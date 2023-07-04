document.getElementById('updateForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    const formData = new FormData(this);

    fetch('/updateUser', {
        method: 'POST',
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        // 서버에서 응답을 받은 후 처리하는 로직
        // 마이페이지를 다시 불러오거나 수정된 정보를 업데이트하는 등의 작업 수행 가능
        console.log(data); // 서버로부터 받은 응답 데이터 출력
    })
    .catch(error => {
        console.error('Error:', error);
    });
});
