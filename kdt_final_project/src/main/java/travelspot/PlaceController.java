package travelspot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import User.UserDTO;

@org.springframework.stereotype.Controller
public class PlaceController {

	@Autowired
	APIServiceImpl apiservice;

	@Autowired
	PlaceServiceImpl placeservice;

	@Autowired
	CommentsServiceImpl commentsservice;

	@RequestMapping("/travelspot/main")
	public String showMain() {
		return "travelspot_main";
	}

	@RequestMapping("/travelspot/list")
	public ModelAndView showList(@RequestParam int areaCode,
			@RequestParam(required = true, defaultValue = "1") int page) throws Exception {
		// 데이터 저장: apiservice.test(areaCode);
		ModelAndView mv = new ModelAndView();

		HashMap<String, Object> param = new HashMap<>();
		param.put("areaCode", areaCode); // 지역코드
		int pageindex = (page - 1) * 9; // 페이징처리 - 시작인덱스
		param.put("page", pageindex);

		mv.addObject("placelist", placeservice.listPlaces(param));
		mv.addObject("totalCnt", placeservice.getTotalCnt(areaCode));
		mv.addObject("areaCode", areaCode);
		mv.setViewName("travelspot_list");
		return mv;
	}

	@RequestMapping("/travelspot/post")
	public ModelAndView showPost(@RequestParam int contentId) {
		PlaceDTO placedto = placeservice.selectPlace(contentId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("travelspot_post");
		mv.addObject("placedto", placedto);
		return mv;
	}

	@RequestMapping("/travelspot/post/images")
	@ResponseBody
	public PlaceDTO showPostImages(@RequestParam int contentId) {

		PlaceDTO placedto = placeservice.selectPlace(contentId);
		return placedto;

	}
	
	@RequestMapping("/travelspot/post/info")
	@ResponseBody
	public PlaceDTO showPostInfo(@RequestParam int contentId) {

		PlaceDTO placedto = placeservice.selectPlace(contentId);
		return placedto;

	}
	
	@RequestMapping("/travelspot/post/comments")
	@ResponseBody
	public List<CommentsDTO> getComments(@RequestParam int contentId){
 
		List<CommentsDTO> commentsList = commentsservice.getComments(contentId);
		return commentsList;
	}

	@RequestMapping("/travelspot/post/comments/save")
	public void saveComments(int content_id, String content) {
		//request 
		//response dto
	}
}// controller
