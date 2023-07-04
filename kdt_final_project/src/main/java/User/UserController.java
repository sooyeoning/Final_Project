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
import org.springframework.web.bind.annotation.RequestMapping;
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
    
	@RequestMapping("/mypage")
	public String mypage(HttpSession session,Model model) {
		UserDTO dto = (UserDTO)session.getAttribute("user");
		if(dto == null) {
			return "redirect:/login";
		}
		model.addAttribute("user",dto);
		return "/user/mypage";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute UserDTO dto, Model model) {
		service.updateUser(dto);
		model.addAttribute("user",dto);
		return "/user/mypage";
	}

    @PostMapping("/withdrawUser")
    public ResponseEntity<String> withdrawUser(HttpSession session) {
        UserDTO user = (UserDTO) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        try {
            service.withdrawUser(user.getUserid());
            session.invalidate();
            return ResponseEntity.status(HttpStatus.OK).body("탈퇴되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원 탈퇴에 실패했습니다.");
        }
    }
}
