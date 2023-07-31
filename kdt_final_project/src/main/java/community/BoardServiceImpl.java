package community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void createBoard(BoardDTO board) {
		boardDAO.insertBoard(board);
	}
	
	@Override
	public List<BoardDTO> getAllBoards() {
	    return boardDAO.getAllBoards(); // BoardDAO의 getAllBoards() 메서드를 호출하여 결과 반환
	}
	
	@Override
	public List<BoardDTO> getTop10Boards() {
	    return boardDAO.getTop10Boards(); // BoardDAO의 getTop10Boards() 메서드를 호출하여 결과 반환
	}
	
	@Override
    public BoardDTO getBoardById(int boardId) {
        return boardDAO.getBoardById(boardId);
    }

	@Override
	public void updateBoard(BoardDTO board) {
		boardDAO.updateBoard(board);
	}

	@Override
	public void deleteBoard(BoardDTO board) {
		boardDAO.deleteBoard(board);
	}

	@Transactional
    @Override
    public void increaseViewCount(int boardId) {
        boardDAO.increaseViewCount(boardId);
    }
	
	@Override
    public List<BoardDTO> getNewestBoards() {
        return boardDAO.getNewestBoards();
    }

	@Override
	public int insertComment(CommentsDTO commentsdto) {
		return boardDAO.insertComment(commentsdto);
	}

	@Override
	public List<CommentsDTO> getComments(int content_id) {
		return boardDAO.getComments(content_id);
	}

	@Override
	public int deleteComments(int id) {
		return boardDAO.deleteComments(id);
	}

	@Override
	public CommentsDTO getOneComment(int id) {
		return boardDAO.getOneComment(id);
	}

	@Override
	public int updateComments(CommentsDTO commentsdto) {
		return boardDAO.updateComments(commentsdto);
	}

	@Override
	public int insertReport(travelspot.ReportDTO reportdto) {
		return boardDAO.insertReport(reportdto);
	}

	@Override
	public List<String> selectUserId(int commentId) {
		return boardDAO.selectUserId(commentId);
	}

	@Override
	public String selectReportedId(int id) {
		return boardDAO.selectReportedId(id);
	}

}