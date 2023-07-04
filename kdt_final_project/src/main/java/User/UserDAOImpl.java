package User;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	public SqlSession sqlSession;

	@Override
	public void signup(UserDTO dto) {
		sqlSession.insert("signup", dto);
	}

	@Override
	public UserDTO findByUserId(String userid) {
		UserDTO user = sqlSession.selectOne("findByUserId", userid);
		if (user != null) {
			return user;
		}
		return null;
	}

	@Override
	public UserDTO getUserById(int id) {
		return sqlSession.selectOne("getUserById", id);
	}

	@Override
	public void updateUser(UserDTO dto) {
		sqlSession.update("updateUser", dto);

	}

	@Override
	public void withdrawUser(String userid) {
		sqlSession.delete("withdrawUser",userid);
		
	}
	

}
