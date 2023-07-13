package User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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
		sqlSession.delete("withdrawUser", userid);

	}

	@Override
	public UserDTO selectfindid(String email, String phone) {
		Map<String, String> params = new HashMap<>();
		params.put("email", email);
		params.put("phone", phone);
		return sqlSession.selectOne("selectfindid", params);
	}

	@Override
	public UserDTO selectfindpw(String userid, String email) {
		Map<String, String> params = new HashMap<>();
		params.put("userid", userid);
		params.put("email", email);
		return sqlSession.selectOne("selectfindpw", params);
	}

	@Override
	public void updatePassword(UserDTO dto) {
		sqlSession.update("updatePassword", dto);

	}

	@Override
	public List<String> getRecentPages(int userId) {
		return sqlSession.selectList("getRecentPages",userId);
	}

}
