package community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WritingController {
	
	@Autowired
	@Qualifier("boardServiceImpl")
	BoardService service;

	@RequestMapping("/writing")
	public String test() {
		return "writing";
	}
	
	@PostMapping("/boardwrite")
	public ModelAndView writeprocess(BoardDTO dto){
		int insertcount = service.insertBoard(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("insertcount", insertcount);
		//mv.setViewName("board/writeresult");
		//mv.setViewName("redirect:/boardlist");//모델2개 전달받는 리스트뷰  
		mv.setViewName("board/start");
		return mv;
	}
}
