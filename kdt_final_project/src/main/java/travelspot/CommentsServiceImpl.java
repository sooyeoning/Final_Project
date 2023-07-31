package travelspot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	CommentsMapper commentsmapper;

	@Override
	public List<CommentsDTO> getComments(int place_id) {
		return commentsmapper.getComments(place_id);
	}

	@Override
	public void insertComments(CommentsDTO CommentsDTO) {
		commentsmapper.insertComments(CommentsDTO);
	}

	@Override
	public void deleteComments(int id) {
		commentsmapper.deleteComments(id);
	}

	@Override
	 public CommentsDTO getOneContent(int id) {
		return commentsmapper.getOneContent(id);
	}

	@Override
	public void updateComments(CommentsDTO CommentsDTO) {
		commentsmapper.updateComments(CommentsDTO);
	}

	@Override
	public void insertReply(CommentsDTO CommentsDTO) {
		commentsmapper.insertReply(CommentsDTO);
	}

	@Override
	public List<CommentsUserDTO> getCommentsProfile(int place_id){
		return commentsmapper.getCommentsProfile(place_id) ;
	}

	@Override
	public void insertReport(ReportDTO ReportDTO) {
		commentsmapper.insertReport(ReportDTO);
	}

	@Override
	 public List<String> selectUserId(int commentId){
		return commentsmapper.selectUserId(commentId);
	}

	@Override
	public String selectReportedId(int id) {
		return commentsmapper.selectReportedId(id);
	}
	

	


	


}
