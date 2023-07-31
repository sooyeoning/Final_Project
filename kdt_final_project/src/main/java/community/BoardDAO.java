package community;

import java.util.List;

public interface BoardDAO {
	void insertBoard(BoardDTO board);
	List<BoardDTO> getAllBoards(); // 모든 Board 목록을 가져오는 메서드
	List<BoardDTO> getTop10Boards(); // Top 10 Board 목록을 가져오는 메서드
	BoardDTO getBoardById(int boardId);
	void updateBoard(BoardDTO board);
	void deleteBoard(BoardDTO board);
	void increaseViewCount(int boardId);
	// 최신순으로 게시글 가져오기
    List<BoardDTO> getNewestBoards();
    int insertComment(CommentsDTO commentsdto);
    List<CommentsDTO> getComments(int content_id);
	int deleteComments(int id);
	CommentsDTO getOneComment(int id);
	int updateComments(CommentsDTO commentsdto);
	int insertReport(travelspot.ReportDTO reportdto);
	List<String> selectUserId(int commentId);
	String selectReportedId(int id);
}