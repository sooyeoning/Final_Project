package User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import community.BoardDTO;
import travelspot.CommentsDTO;
import travelspot.PlaceDTO;;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	public SqlSession sqlSession;
	
	@Autowired
	public PlaceDAO placeDAO;

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
	public List<BoardDTO> getBoardListByWriter(String writer) {
		return sqlSession.selectList("getBoardListByWriter", writer);
	}

	@Override
	public List<CommentsDTO> getCommentListByWriter(String writer) {
		return sqlSession.selectList("getCommentListByWriter", writer);
	}

	@Override
	public List<LikesDTO> getLikesByUserId(int user_id) {
	    List<LikesDTO> likesList = sqlSession.selectList("getLikesByUserId", user_id);
	    
	    // 각 LikesDTO에 해당하는 PlaceDTO를 가져와서 설정
	    for (LikesDTO likes : likesList) {
	        int place_id = likes.getPlace_id();
	        PlaceDTO place = placeDAO.getPlaceById(place_id);
	        likes.setPlaceDTO(place);
	    }
	    
	    return likesList;
	}

	
}
