package User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO dao;

	@Override
	public void signup(UserDTO dto) {
		dao.signup(dto);
	}

	@Override
	public UserDTO login(String userid, String userpw) {
		return dao.login(userid, userpw);
	}

}
