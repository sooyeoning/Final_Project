package community;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertBoard(BoardDTO board) {
		sqlSession.insert("insertBoard", board);
	}
	
	@Override
	public List<BoardDTO> getAllBoards() {
	    return sqlSession.selectList("getAllBoards"); // SQL 매핑된 쿼리를 실행하여 Board 목록을 가져옴
	}
	
	@Override
	public List<BoardDTO> getTop10Boards() {
	    return sqlSession.selectList("getTop10Boards"); // SQL 매핑된 쿼리를 실행하여 Top 10 Board 목록을 가져옴
	}

	@Override
    public BoardDTO getBoardById(int boardId) {
        return sqlSession.selectOne("getBoardById", boardId);
    }

	@Override
	public void updateBoard(BoardDTO board) {
		sqlSession.update("updateBoard", board);
		
	}

	@Override
	public void deleteBoard(BoardDTO board) {
		sqlSession.delete("deleteBoard", board);
	}

	@Override
	public void increaseViewCount(int boardId) {
		sqlSession.update("increaseViewCount", boardId);
	}
	
	@Override
    public List<BoardDTO> getNewestBoards() {
        return sqlSession.selectList("getNewestBoards");
    }

	@Override
	public int insertComment(CommentsDTO commentsdto) {
		return sqlSession.insert("insertComment", commentsdto);
	}

	@Override
	public List<CommentsDTO> getComments(int content_id) {
		return sqlSession.selectList("board.spring.mybatis.BoardDAO.getComments", content_id);
	}

	@Override
	public int deleteComments(int id) {
		return sqlSession.delete("board.spring.mybatis.BoardDAO.deleteComments", id);
	}

	@Override
	public CommentsDTO getOneComment(int id) {
		return sqlSession.selectOne("board.spring.mybatis.BoardDAO.getOneComment",id);
	}

	@Override
	public int updateComments(CommentsDTO commentsdto) {
		return sqlSession.update("board.spring.mybatis.BoardDAO.updateComments", commentsdto);
	}


}