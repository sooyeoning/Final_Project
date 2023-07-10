package travelspot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import User.UserDTO;

@org.springframework.stereotype.Controller
public class CommentsController {

	@Autowired
	APIServiceImpl apiservice;

	@Autowired
	PlaceServiceImpl placeservice;

	@Autowired
	CommentsServiceImpl commentsservice;

	@GetMapping("/travelspot/post/comments")
	@ResponseBody
	public List<CommentsDTO> getComments(@RequestParam int contentId){
 
		List<CommentsDTO> commentsList = commentsservice.getComments(contentId);
		return commentsList;
	}
	/*
	 * @RequestMapping("/travelspot/comments/save")
	 * 
	 * @ResponseBody public String saveComments(@RequestParam int
	 * contentId,@RequestParam String content) { //request
	 * 
	 * //response dto return "yes"; }
	 */
}// controller
