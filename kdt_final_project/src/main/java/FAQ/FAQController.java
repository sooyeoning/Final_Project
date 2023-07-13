package FAQ;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class FAQController {
	@RequestMapping("/FAQ")

	public String FAQ() {

		return "/FAQ/contactform";
		/* 아무거나 */
	}

	@RequestMapping("/FAQ01")

	public String FAQ01() {

		return "/FAQ/contactform_FAQ01";
		
	}
	@RequestMapping("/FAQ02")

	public String FAQ02() {

		return "/FAQ/contactform_FAQ02";
		
	}
	@RequestMapping("/FAQ03")

	public String FAQ03() {

		return "/FAQ/contactform_FAQ03";
		
	}
	
	@RequestMapping("/FAQ04")

	public String FAQ04() {

		return "/FAQ/contactform_FAQ04";
		
	}
}
