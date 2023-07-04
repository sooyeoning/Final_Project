package User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;

	@Override
	public void signup(UserDTO dto) {
		dao.signup(dto);
	}

	@Override
	public UserDTO login(String userid, String userpw) {
		UserDTO dto = dao.findByUserId(userid);
		if (dto != null && dto.getUserpw().equals(userpw)) {
			return dto;
		} else {
			return null;
		}
	}

	@Override
	public UserDTO getUserById(int id) {
		return dao.getUserById(id);
	}

	@Override
	@Transactional
	public void updateUser(UserDTO dto) {
		dao.updateUser(dto);
	}
	
	
}