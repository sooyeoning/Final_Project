package community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;

	@Override
	public int insertBoard(BoardDTO dto) {
		return dao.insertBoard(dto);
	}

}
