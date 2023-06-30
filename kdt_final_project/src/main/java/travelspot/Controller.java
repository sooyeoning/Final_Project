package travelspot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping("/travelspot/main")
	public String showMain() {
		return "travelspot_main";
	}
	
	@RequestMapping("/travelspot/list")
	public String showList(String selectedPlace) {
		return "travelspot_list";
	}
	
	@RequestMapping("/travelspot/post")
	public String showPost(){
		return "travelspot_post";
	}
	
	@RequestMapping("/travelspot/post/images")
	@ResponseBody
	public void showPostImages(){
		
	}
	
	@RequestMapping("/travelspot/post/info")
	@ResponseBody
	public void showPostInfo(){
		
	}
	
	@RequestMapping("/travelspot/post/comments")
	@ResponseBody
	public void showPostComments(){
		
	}
}
