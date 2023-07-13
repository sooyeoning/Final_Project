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


}
