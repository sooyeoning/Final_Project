package travelspot;

import org.springframework.stereotype.Component;

@Component
public class ReportDTO {
	private int id; //신고번호
	private int commentId; //신고당하는 댓글 번호
	private String reportedId;//신고당한 사람 아이디
	private String userNickname; //신고자 닉네임
	private String userId; //신고자 아이디
	private String reportCategory; //신고 카테고리 - String
	private String reportContents; //신고 내용
	private String regDate; //신고날짜
	private int contentId; //신고당하는 댓글이 있는 게시글 번호
	private int boardId;

	public ReportDTO() {}

	public ReportDTO(int id, int commentId, String userNickname, String userId, String reportCategory,
			String reportContents, String regDate, int contentId, String reportedId,int boardId) {
		this.id = id;
		this.commentId = commentId;
		this.userNickname = userNickname;
		this.userId = userId;
		this.reportCategory = reportCategory;
		this.reportContents = reportContents;
		this.regDate = regDate;
		this.contentId = contentId;
		this.reportedId = reportedId;
		this.boardId = boardId;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
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
	public String getReportCategory() {
		return reportCategory;
	}

	public void setReportCategory(String reportCategory) {
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
	

	public String getReportedId() {
		return reportedId;
	}

	public void setReportedId(String reportedId) {
		this.reportedId = reportedId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	
}