package User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("signin")
	public String signup() {
		return "/user/signin";
	}

	@PostMapping("signin")
	public String signup(UserDTO dto) {
		service.signup(dto);
		return "/user/signin";
	}

	@GetMapping("login")
	public String login() {
		return "/user/login";
	}

	@PostMapping("login")
	public ModelAndView login(@RequestParam String userid, @RequestParam String userpw, HttpSession session) {
		UserDTO dto = service.login(userid,userpw);
		if (dto != null) {
			session.setAttribute("user", dto);
			ModelAndView mv = new ModelAndView("/user/login_success");
			mv.addObject("message","로그인 성공");
			return mv;			
		}
		else {
			ModelAndView mv = new ModelAndView("/user/login_fail");
			mv.addObject("message","로그인 실패");
			return mv;
		}
    }
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
    @PostMapping("/logout")
    public ResponseEntity<String> logoutPost(HttpSession session) {
    	session.invalidate(); // 세션 무효화
        return ResponseEntity.status(HttpStatus.OK).body("로그아웃 성공");
    }
    
	@GetMapping("/mypage")
	public String mypage(HttpSession session,Model model) {
		UserDTO dto = (UserDTO)session.getAttribute("user");
		if(dto == null) {
			return "redirect:/login";
		}
		model.addAttribute("user",dto);
		return "/user/mypage";
	}
	
	@PostMapping("/mypage")
	@Transactional
	public ModelAndView updateMypage(@ModelAttribute("user")UserDTO updatedUser, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		try {
			service.updateUser(updatedUser);
			
			session.invalidate();
			UserDTO updateUserInSession = service.getUserById(updatedUser.getId());
			session.setAttribute("user", updateUserInSession);
			
			mv.setViewName("redirect:/mypage");
			mv.addObject("alertMessage","회원 정보가 성공적으로 수정되었습니다.");
		}catch (Exception e) {
            mv.setViewName("/user/mypage"); // 실패 시 수정 폼 페이지로 다시 이동
            mv.addObject("errorMessage", "회원 정보 수정에 실패했습니다. 다시 시도해주세요.");
        }
		return mv;
	}
}
