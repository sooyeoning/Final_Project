package community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import User.LikesDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
    private LikeService likeService;
	
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
    public LikesDTO getLikeByUserAndBoard(int userId, int boardId) {
        return boardDAO.getLikeByUserAndBoard(userId, boardId);
    }

    @Override
    public void insertLikes(LikesDTO like) {
        boardDAO.insertLikes(like);
    }

    @Override
    public void cancelLikes(LikesDTO like) {
        boardDAO.cancelLikes(like);
    }

}