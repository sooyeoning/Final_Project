package travelspot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@GetMapping("/travelspot/main")
	public String showMain() {
		return "travelspot_main";
	}
	
	@RequestMapping("/travelspot/list")
	public ModelAndView showList(@RequestParam int areaCode,
			@RequestParam(required = true, defaultValue = "1") int page) throws Exception {
		//데이터 저장: apiservice.getBasicInfo(areaCode);
		//테마별 info 저장: apiservice.getThemeInfo();
		
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
	
	@GetMapping("/travelspot/post/images")
	@ResponseBody
	public PlaceDTO showPostImages(@RequestParam int contentId) {
		PlaceDTO placedto = placeservice.selectPlace(contentId);
		return placedto;
	}
	
	@GetMapping("/travelspot/post/info")
	@ResponseBody
	public PlaceDTO showPostInfo(@RequestParam int contentId) {
		PlaceDTO placedto = placeservice.selectPlace(contentId);
		//PlaceContentsDTO contentsdto = placeservice.getThemeDetail(contentId);
		return placedto;
	}
	
	@RequestMapping("/travelspot/list_theme")
	public ModelAndView showThemeMain(@RequestParam String theme,
			@RequestParam(required = true, defaultValue = "1") int page) throws Exception{
		//정보 저장: apiservice.getThemeBasicInfo(); 
		ModelAndView mv = new ModelAndView();
		
		HashMap<String, Object> param = new HashMap<>();
		param.put("theme", theme); // 지역코드
		int pageindex = (page - 1) * 9; // 페이징처리 - 시작인덱스
		param.put("page", pageindex);

		mv.addObject("placelist", placeservice.listThemePlaces(param));
		mv.addObject("totalCnt", placeservice.getTotalThemeCnt(theme));
		mv.addObject("theme", theme);
		mv.setViewName("travelspot_list_theme");
		return mv;
	}
	
	
}// controller
