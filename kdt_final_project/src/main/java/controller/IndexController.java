package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	HomeService service;
	
	@RequestMapping("/")
	public String Index(Model model) {
		
		 List<HomeDTO> getTop5Record = service.getTop5Record();
		 model.addAttribute("getTop5Record",getTop5Record);
		  
		 List<HomeDTO> getTop5Recommend = service.getTop5Recommend();
		 model.addAttribute("getTop5Recommend",getTop5Recommend);
		 
		return "index"; 
	}
	
	
	@RequestMapping("/index(Eng)")
	public String EngIndex() {
		return "index(Eng)"; 
	}
	
}
