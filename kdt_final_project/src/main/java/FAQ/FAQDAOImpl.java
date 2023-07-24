package FAQ;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import community.BoardDTO;

@Repository
public class FAQDAOImpl implements FAQDAO {
	private final SqlSession sqlSession;

	@Autowired
	public FAQDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void insertArticle(FAQDTO faqDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert("FAQ.FAQDAO.insertArticle", faqDTO);

	}

	@Override
	public List<FAQDTO> selectAllFAQs(String writer) {
		return sqlSession.selectList("selectAllFAQs",writer); // SQL 매핑된 쿼리를 실행하여 Board 목록을 가져옴
	}


	/*
	 * @Override public String getWriterById(int id) { // 게시물 작성자 정보를 가져오는 SQL 쿼리를
	 * 실행하여 결과 반환 return sqlSession.selectOne("getWriterById", id); }
	 */
	@Override
    public void deleteArticleById(int id) {
        // 게시물 삭제를 위한 SQL 쿼리를 실행
        sqlSession.delete("FAQ.FAQDAO.deleteArticleById", id);
    }
	
	@Override
    public void updateFAQ(BoardDTO dto) {
        // 게시물 삭제를 위한 SQL 쿼리를 실행
        sqlSession.update("updateFAQ", dto);
    }
	
	@Override
	public BoardDTO getBoardById2(int id) {
		// id에 따라 값을 받아와 board객체에 저장?
		return sqlSession.selectOne("getBoardById",id);
	}

}
