package travelspot;

import java.util.List;

public interface CommentsService {

	public List<CommentsDTO> getComments(int place_id);
	public void insertComments(CommentsDTO CommentsDTO);
	public void deleteComments(int id);
	public CommentsDTO getOneContent(int id);
	public void updateComments(CommentsDTO CommentsDTO);
	public void insertReply(CommentsDTO CommentsDTO);
	public List<CommentsUserDTO> getCommentsProfile(int place_id);
	 public void insertReport(ReportDTO ReportDTO);
	 public List<String> selectUserId(int commentId);
	 public String selectReportedId(int id);

}
