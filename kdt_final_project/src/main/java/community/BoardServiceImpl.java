package community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
