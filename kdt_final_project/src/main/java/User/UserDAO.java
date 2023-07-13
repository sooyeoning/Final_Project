package User;

import java.util.List;

public interface UserDAO {

	public void signup(UserDTO dto); // 회원가입

	UserDTO findByUserId(String userid);

	UserDTO getUserById(int id);

	void updateUser(UserDTO dto);

	void withdrawUser(String userid);

	UserDTO selectfindid(String email, String phone);

	UserDTO selectfindpw(String userid, String email);

	void updatePassword(UserDTO dto);

	List<String> getRecentPages(int userId);
}
