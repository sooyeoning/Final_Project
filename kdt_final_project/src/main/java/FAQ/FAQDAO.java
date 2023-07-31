package FAQ;

import java.util.List;

import User.UserDTO;
import community.BoardDTO;

public interface FAQDAO {
	void insertArticle(FAQDTO faqDTO);

	List<FAQDTO> selectAllFAQs(String writer);

	void deleteArticleById(int id);
	
	void updateFAQ(BoardDTO dto);
	
	BoardDTO getBoardById2(int id);

}
