package User;

import java.net.PasswordAuthentication;
import java.util.Properties;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.server.RSocketServer.Transport;
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
//		System.out.println("Before Update - DTO: " + dto.toString());
		dao.updateUser(dto);
//		System.out.println("After Update - DTO: " + dto.toString());
	}

	@Override
	@Transactional
	public void withdrawUser(String userid) {
		dao.withdrawUser(userid);
	}

}