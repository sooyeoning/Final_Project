package User;

public interface UserDAO {

	public void signup(UserDTO dto); // 회원가입
	UserDTO findByUserId(String userid);
	UserDTO getUserById(int id);
	void updateUser(UserDTO dto);
}
