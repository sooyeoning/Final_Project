package User;

public interface UserDAO {

	public void signup(UserDTO dto); // 회원가입
	public UserDTO login(String userid,String userpw); // 로그인
}
