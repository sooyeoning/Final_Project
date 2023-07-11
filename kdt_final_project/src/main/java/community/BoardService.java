package community;

import org.springframework.stereotype.Service;

@Service
public interface BoardService {
	public int insertBoard(BoardDTO dto);
}
