package FAQ;

public class FAQDTO {
	
	String title, contents, board_title, writer, writingtime, answer;
	int id;
	
	public String getAnswer() {
		return answer;
	}

	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public String getWritingtime() {
		return writingtime;
	}

	public void setWritingtime(String writingtime) {
		this.writingtime = writingtime;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * private int articleNO; private String title; private String content; private
	 * String board_title; private String email; private String phone; private String
	 * agree_yn; private String imageFileName; private MultipartFile imageFile;
	 * 
	 * // Getter와 Setter 메서드 추가
	 * 
	 * public String getAgree_yn() { return agree_yn; }
	 * 
	 * public void setAgree_yn(String agree_yn) { this.agree_yn = agree_yn; }
	 * 
	 * public int getArticleNO() { return articleNO; }
	 * 
	 * public void setArticleNO(int articleNO) { this.articleNO = articleNO; }
	 * 
	 * public String getTitle() { return title; }
	 * 
	 * public void setTitle(String title) { this.title = title; }
	 * 
	 * public String getContent() { return content; }
	 * 
	 * public void setContent(String content) { this.content = content; }
	 * 
	 * public String getboard_title() { return board_title; }
	 * 
	 * public void setboard_title(String board_title) { this.board_title = board_title;
	 * }
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * public String getPhone() { return phone; }
	 * 
	 * public void setPhone(String phone) { this.phone = phone; }
	 * 
	 * public String getImageFileName() { return imageFileName; }
	 * 
	 * public void setImageFileName(String imageFileName) { this.imageFileName =
	 * imageFileName; }
	 * 
	 * public MultipartFile getImageFile() { return imageFile; }
	 * 
	 * public void setImageFile(MultipartFile imageFile) { this.imageFile =
	 * imageFile; }
	 * 
	 * @Override public String toString() { return "FAQDTO [articleNO=" + articleNO
	 * + ", title=" + title + ", content=" + content + ", board_title=" + board_title
	 * + ", email=" + email + ", phone=" + phone + ", imageFileName=" +
	 * imageFileName +
	 * ",imageFile=\" + imageFile + \", agree_yn=\" + agree_yn + \"]"; }
	 */
}
