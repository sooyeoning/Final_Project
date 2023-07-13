package User;

import java.util.List;

public interface UserService {

	public void signup(UserDTO dto);

	public UserDTO login(String userid, String userpw);

	UserDTO getUserById(int id);

	void updateUser(UserDTO dto);

	void withdrawUser(String userid); // 회원 탈퇴

	UserDTO findUserId(String email, String phone);

	UserDTO findUserPw(String userid, String email);

	void resetPassword(String userid, String email, String temporaryPassword);

	String generateTemporaryPassword();

	List<String> getRecentPages(int userId);
}
