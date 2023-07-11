package community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import User.UserDTO;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CommunityController {
	
	@Autowired
    private BoardService boardService;
	
	@RequestMapping("/community")
	public String community() {
		return "community";
	}
	
	@RequestMapping("/writing")
	public String writingForm(HttpServletRequest request, Model model) {
		UserDTO user = (UserDTO) request.getSession().getAttribute("user");
	    if (user != null) {
	        model.addAttribute("nickname", user.getNickname());
	    }
		return "writing";
	}
	
	@PostMapping("/boardwrite")
    public String boardWritePro(@RequestParam("board_title") String boardTitle,
                                @RequestParam("place") String place,
                                //@RequestParam("hashtag") String hashtag,
                                @RequestParam("writer") String writer,
                                @RequestParam("title") String title,
                                @RequestParam("contents") String contents) {
        BoardDTO board = new BoardDTO();
        board.setTitle(boardTitle);
        board.setPlace(place);
        //board.setHashtag(hashtag);
        board.setWriter(writer);
        board.setTitle(title);
        board.setContents(contents);

        boardService.createBoard(board);

        // 게시글 저장 후 어떤 페이지로 이동할지 결정하여 반환
        return "redirect:/"; // 예시: 메인 페이지로 이동
	}
}
