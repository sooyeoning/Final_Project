package travelspot;

import org.springframework.stereotype.Component;

@Component
public class ReportDTO {
	int id; //신고번호
	int commentId; //신고당하는 댓글 번호
	String userNickname; //신고자 닉네임
	String userId; //신고자 아이디
	int reportCategory; //신고 카테고리
	String reportContents; //신고 내용
	String regDate; //신고날짜
	int contentId; //신고당하는 댓글이 있는 게시글 번호
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public ReportDTO(int id, int commentId, String userNickname, String userId, int reportCategory,
			String reportContents, String regDate, int contentId) {
		super();
		this.id = id;
		this.commentId = commentId;
		this.userNickname = userNickname;
		this.userId = userId;
		this.reportCategory = reportCategory;
		this.reportContents = reportContents;
		this.regDate = regDate;
		this.contentId = contentId;
	}

	public ReportDTO() {
		super();
	}

	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getReportCategory() {
		return reportCategory;
	}

	public void setReportCategory(int reportCategory) {
		this.reportCategory = reportCategory;
	}
	public String getReportContents() {
		return reportContents;
	}
	public void setReportContents(String reportContents) {
		this.reportContents = reportContents;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}