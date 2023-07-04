
function openFileSelector() {
	const fileInput = document.getElementById('profileImg');
	fileInput.click();
}

document.getElementById('preview').addEventListener('click', openFileSelector);

document.getElementById('profileImg').addEventListener('change', function(e) {
	const preview = document.getElementById('preview');
	const file = e.target.files[0];
	const reader = new FileReader();

	reader.onloadend = function() {
		preview.src = reader.result;
	}

	if (file) {
		reader.readAsDataURL(file);
	} else {
		preview.src = "디폴트이미지URL";
	}
});
document.addEventListener('DOMContentLoaded', function() {
	var sideMenuItems = document.querySelectorAll('.side-menu-nav a');

	function showContent(e) {
		e.preventDefault();

		var currentItem = e.target;
		var contentId = currentItem.getAttribute('href').substring(1);

		var contentSections = document.querySelectorAll('.side-menu-form');
		for (var i = 0; i < contentSections.length; i++) {
			contentSections[i].style.display = 'none';
		}

		var targetContent = document.getElementById(contentId);
		if (targetContent) {
			targetContent.style.display = 'block';
		}
	}

	for (var i = 0; i < sideMenuItems.length; i++) {
		sideMenuItems[i].addEventListener('click', showContent);
	}
});



