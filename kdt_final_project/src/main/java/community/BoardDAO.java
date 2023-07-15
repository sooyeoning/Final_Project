package community;

import java.util.List;

public interface BoardDAO {
	void insertBoard(BoardDTO board);
	List<BoardDTO> getAllBoards(); // 모든 Board 목록을 가져오는 메서드
	List<BoardDTO> getTop10Boards(); // Top 10 Board 목록을 가져오는 메서드
	BoardDTO getBoardById(int boardId);
	void updateBoard(BoardDTO board);
}
