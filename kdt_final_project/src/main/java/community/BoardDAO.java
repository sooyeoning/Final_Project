package community;

import java.util.List;

import User.LikesDTO;

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
    
    // 좋아요 테이블 정보 저장
    void insertLikes(LikesDTO like);

    // 좋아요 테이블 정보 삭제
    void cancelLikes(LikesDTO like);

    // 좋아요 여부 확인
    LikesDTO getLikeByUserAndBoard(int userId, int boardId);
}