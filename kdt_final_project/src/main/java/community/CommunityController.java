package community;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// 커뮤니티 페이지 매핑
	@RequestMapping("/community")
	public String community(HttpServletRequest request, Model model) {
	    String order = request.getParameter("order");
	    if (order == null) {
	        order = "like";
	    }

	    List<BoardDTO> boardList;
	    if (order.equals("like")) {
	        boardList = boardService.getAllBoardsOrderedByLike();
	    } else if (order.equals("newest")) {
	        boardList = boardService.getAllBoardsOrderedByNewest(); // 최신순으로 정렬
	    } else {
	        // order 값이 'like' 또는 'newest'가 아닌 경우 기본적으로 'like'로 처리
	        boardList = boardService.getAllBoardsOrderedByLike();
	    }

	    List<BoardDTO> top10List = boardService.getTop10Boards();
	    model.addAttribute("top10List", top10List);
	    model.addAttribute("boardList", boardList);

	    return "community";
	}


	// 새글쓰기 화면 writing.jsp 매핑
	@RequestMapping("/writing")
	public String writingForm(HttpServletRequest request, Model model) {
	    UserDTO user = (UserDTO) request.getSession().getAttribute("user");
	    if (user == null) {
	        return "redirect:/login";
	    } else if (user != null) {
	        model.addAttribute("nickname", user.getNickname());
	    }
	    return "writing";
	}

	// 글쓰기 누르면 DB에 저장
	@PostMapping("/boardwrite")
	public ModelAndView boardWritePro(HttpServletRequest request) {
	    BoardDTO board = new BoardDTO();
	    board.setBoard_title(request.getParameter("board_title"));
	    board.setPlace(request.getParameter("place"));
	    board.setWriter(request.getParameter("writer"));
	    board.setTitle(request.getParameter("title"));
	    board.setContents(request.getParameter("contents"));
	    
	    //System.out.println("contents = "+request.getParameter("contents"));

	    boardService.createBoard(board);

	    ModelAndView mv = new ModelAndView();
	    mv.addObject("board", board);
	    mv.setViewName("board/detail");
	    return mv;
	}

	// detail.jsp로 이동
	@GetMapping("/detail")
	public ModelAndView showBoardDetail(HttpServletRequest request) {
	    ModelAndView mv = new ModelAndView();
	    int boardId = Integer.parseInt(request.getParameter("boardId"));
	    
	    // 게시글 조회수 증가
	    boardService.increaseViewCount(boardId);
	    
	    BoardDTO board = boardService.getBoardById(boardId);
	    mv.addObject("board", board);

	    UserDTO user = (UserDTO) request.getSession().getAttribute("user");
	    if (user != null) {
	        mv.addObject("nickname", user.getNickname());
	    }

	    mv.setViewName("board/detail");
	    return mv;
	}

	// update.jsp로 이동
	@GetMapping("/update")
	public ModelAndView showBoardUpdateForm(HttpServletRequest request) {
	    ModelAndView mv = new ModelAndView();
	    int boardId = Integer.parseInt(request.getParameter("boardId"));
	    BoardDTO board = boardService.getBoardById(boardId);
	    mv.addObject("board", board);
	    mv.setViewName("board/update");
	    return mv;
	}
	
	//수정 완료 눌렀을 때
	@PostMapping("/update")
	public String updateBoard(HttpServletRequest request) {
	    int boardId = Integer.parseInt(request.getParameter("id"));
	    String boardTitle = request.getParameter("board_title");
	    String place = request.getParameter("place");
	    String title = request.getParameter("title");
	    String contents = request.getParameter("contents");

	    BoardDTO board = boardService.getBoardById(boardId);
	    board.setBoard_title(boardTitle);
	    board.setPlace(place);
	    board.setTitle(title);
	    board.setContents(contents);
	    boardService.updateBoard(board);

	    // 수정된 글을 보여줄 detail 페이지로 리다이렉트
	    return "redirect:/detail?boardId=" + boardId;
	}
	
	// 삭제버튼 눌렀을 때 게시글 삭제
	@GetMapping("/delete")
	public String deleteBoard(HttpServletRequest request, Model model) {
	    int boardId = Integer.parseInt(request.getParameter("boardId"));
	    BoardDTO board = boardService.getBoardById(boardId);
	    boardService.deleteBoard(board);

	    model.addAttribute("boardId", boardId);
	    return "board/delete"; // delete.jsp로 이동
	}

	
	@RequestMapping("/delete")
	public String showDeletePage(HttpServletRequest request) {
	    return "board/delete";
	}

	


}
