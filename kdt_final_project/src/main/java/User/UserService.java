package User;

public interface UserService {

	public void signup(UserDTO dto);
	public UserDTO login(String userid, String userpw);
	UserDTO getUserById(int id);
	void updateUser(UserDTO dto);
	void withdrawUser(String userid); // 회원 탈퇴
}
