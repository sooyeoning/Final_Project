package User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("/main")
	public String main() {
	    return "main";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(UserDTO dto) {
		service.signup(dto);
		return "redirect:main";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<?> login(@RequestParam String userid, @RequestParam String userpw) {
	    UserDTO dto = service.login(userid, userpw);

	    if (dto != null) {
	        return ResponseEntity.ok().body(new ApiResponse(true, "로그인이 완료되었습니다."));
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, "로그인 중 오류가 발생했습니다. 다시 시도해주세요."));
	    }
	}


	@GetMapping("mypage")
	public String mypage() {
		return "mypage";
	}
}
