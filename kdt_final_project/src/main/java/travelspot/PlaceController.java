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

	//기본 관광지
	@RequestMapping("/travelspot/list")
	public ModelAndView showList(
			@RequestParam(required = true, defaultValue = "32") int areaCode,
			@RequestParam(required = true, defaultValue = "1") int page,
			HttpSession session) throws Exception {
		//데이터 저장: apiservice.getBasicInfo(areaCode);
		//테마별 info 저장: apiservice.getThemeInfo();
		
		ModelAndView mv = new ModelAndView();

		HashMap<String, Object> param = new HashMap<>();
		param.put("areaCode", areaCode); // 지역코드
		int pageindex = (page - 1) * 9; // 페이징처리 - 시작인덱스
		param.put("page", pageindex);

		UserDTO userdto = (UserDTO)session.getAttribute("user");
		
		mv.addObject("userdto", userdto);
		mv.addObject("placelist", placeservice.listPlaces(param));
		mv.addObject("totalCnt", placeservice.getTotalCnt(areaCode));
		mv.addObject("areaCode", areaCode);
		mv.setViewName("travelspot_list");
		return mv;
	}

	@RequestMapping("/travelspot/post")
	public ModelAndView showPost(@RequestParam int contentId) {
		PlaceDTO placedto = placeservice.selectPlace(contentId);
		//조회수 증가
		placeservice.plusViewCount(contentId);
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
		PlaceDTO placeDTO = placeservice.getPlaceThemeDetail(contentId);
		return placeDTO;
	}
	
	// 테마 관광지 
	@RequestMapping("/travelspot/list_theme")
	public ModelAndView showThemeMain(@RequestParam String theme,
			@RequestParam(required = true, defaultValue = "1") int page) throws Exception{
		//정보 저장: apiservice.getThemeBasicInfo(); 
		ModelAndView mv = new ModelAndView();
		
		HashMap<String, Object> param = new HashMap<>();
		param.put("theme", theme); // 지역코드
		int pageindex = (page - 1) * 9; // 페이징처리 - 시작인덱스
		param.put("page", pageindex);

		mv.addObject("placelist", placeservice.listThemePlaces(param)); //PlaceContentsDTO
		mv.addObject("totalCnt", placeservice.getTotalThemeCnt(theme));
		mv.addObject("theme", theme);
		mv.setViewName("travelspot_list_theme");
		return mv;
	}
	
	@RequestMapping("/travelspot/themepost")
	public ModelAndView showThemePost(@RequestParam int contentId) {
		PlaceDTO placedto = placeservice.selectPlace(contentId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("travelspot_post_theme");
		mv.addObject("placedto", placedto);
		return mv;		
	}
	
	@GetMapping("/travelspot/post/themeimages")
	@ResponseBody
	public PlaceDTO showPostThemeImages(@RequestParam int contentId) {
		PlaceDTO placedto = placeservice.selectPlace(contentId);
		return placedto;
	}
	
	@GetMapping("/travelspot/post/themeinfo")
	@ResponseBody
	public PlaceContentsDTO showPostThemeInfo(@RequestParam int contentId) {
		PlaceContentsDTO placeContentsDTO = placeservice.getPlaceContentThemeDetail(contentId);
		return placeContentsDTO;
	}
	
	
}// controller
