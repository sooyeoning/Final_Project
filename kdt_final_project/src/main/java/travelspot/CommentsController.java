package travelspot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


	/*
	 * @GetMapping("/travelspot/comments/save") public void insertComments(String
	 * contents, @RequestParam int place_id) {
	 * //commentsservice.insertComments(contents, place_id);
	 * 
	 * //return "travelspot_comment"; }
	 */

}// controller
