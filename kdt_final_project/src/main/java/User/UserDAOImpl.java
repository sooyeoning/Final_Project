package User;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	public SqlSession sqlSession;

	@Override
	public void signup(UserDTO dto) {
		sqlSession.insert("signup",dto);
	}

	@Override
	public UserDTO login(String userid,String userpw) {
		HashMap<String,String> params = new HashMap<>();
		params.put("userid", userid);
		params.put("userpw", userpw);
		return  sqlSession.selectOne("login",params);
	}
	
	

}
