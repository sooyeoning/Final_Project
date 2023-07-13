package community;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import User.UserDTO;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CommunityController {
	
	@Autowired
    private BoardService boardService;
	
	@RequestMapping("/community")
	public String community(Model model) {
	    List<BoardDTO> boardList = boardService.getAllBoards(); // Board 목록을 가져오는 메서드 호출
	    
	 // 좋아요 수에 따라 정렬
	    Collections.sort(boardList, Comparator.comparingInt(BoardDTO::getLikecount).reversed());

	    model.addAttribute("boardList", boardList); // boardList를 모델에 추가
	    
	    List<BoardDTO> top10List = boardService.getTop10Boards(); // Top 10 게시글 목록을 가져오는 메서드 호출
	    model.addAttribute("top10List", top10List); // top10List를 모델에 추가

	    return "community";
	}
	
	@RequestMapping("/writing")
	public String writingForm(HttpServletRequest request, Model model) {
		UserDTO user = (UserDTO) request.getSession().getAttribute("user");
	    if (user == null) {
	        // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
	        return "redirect:/login";
	    }else if (user != null) {
	        model.addAttribute("nickname", user.getNickname());
	    }
		return "writing";
	}
	
	@PostMapping("/boardwrite")
    public ModelAndView boardWritePro(@RequestParam("board_title") String board_title,
                                @RequestParam("place") String place,
                                //@RequestParam("hashtag") String hashtag,
                                @RequestParam("writer") String writer,
                                @RequestParam("title") String title,
                                @RequestParam("contents") String contents) {
        BoardDTO board = new BoardDTO();
        board.setBoard_title(board_title);
        board.setPlace(place);
        //board.setHashtag(hashtag);
        board.setWriter(writer);
        board.setTitle(title);
        board.setContents(contents);

        boardService.createBoard(board);

        // 게시글 저장 후 어떤 페이지로 이동할지 결정하여 반환
        //return "redirect:/board/" + board.getId(); // 게시글 상세 페이지로 이동
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("board", board); // 작성한 글을 모델에 추가

        mv.setViewName("board/detail"); // 작성한 글을 보여줄 페이지로 이동
        return mv;
	}
	
}
