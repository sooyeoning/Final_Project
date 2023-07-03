package travelspot;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	APIServiceImpl apiservice;
	
	@Autowired
	PlaceServiceImpl placeservice;
	
	@RequestMapping("/travelspot/main")
	public String showMain() {
		return "travelspot_main";
	}
	
	@RequestMapping("/travelspot/list")
	public ModelAndView showList(@RequestParam int areaCode, @RequestParam(required=true, defaultValue="1") int page) throws Exception {
		// 데이터 저장: apiservice.test(areaCode);
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> param = new HashMap<>();
		param.put("areaCode", areaCode);
		param.put("page", page);
		mv.addObject("totalCnt", placeservice.getTotalCnt(areaCode));
		mv.addObject("placelist", placeservice.listPlaces(param));
		mv.setViewName("travelspot_list");
		return mv;
	}
	
	@RequestMapping("/travelspot/post")
	public ModelAndView showPost(@RequestParam int contentId){
		PlaceDTO placedto = placeservice.selectPlace(contentId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("travelspot_post");
		mv.addObject("placedto", placedto);
		return mv;
	}
	
	@RequestMapping("/travelspot/post/images")
	@ResponseBody
	public PlaceDTO showPostImages(@RequestParam int contentId){
		
		 PlaceDTO placedto = placeservice.selectPlace(contentId); 
		 return placedto;
		 
	}
	
	@RequestMapping("/travelspot/post/info")
	@ResponseBody
	public PlaceDTO showPostInfo(@RequestParam int contentId){

		 PlaceDTO placedto = placeservice.selectPlace(contentId); 
		 return placedto;
		 
	}
	
	@RequestMapping("/travelspot/post/comments")
	@ResponseBody
	public void showPostComments(){
		
	}
	
	
}
