package FAQ;

import java.util.List;

import community.BoardDTO;

public interface FAQService {
	void createArticle(FAQDTO faqDTO);

	List<FAQDTO> selectAllFAQs(String writer); // 모든 Board 목록을 가져오는 메서드

	void deleteArticleById(int id);

	void updateFAQ(BoardDTO dto);

	BoardDTO getBoardById2(int id);
}