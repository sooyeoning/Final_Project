package community;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import User.LikesDTO;

@Repository
public class LikeDAOImpl implements LikeDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public LikesDTO getLikeByUserAndBoard(int user_id, int board_id) {
        return sqlSession.selectOne("getLikeByUserAndBoard", new LikesDTO(user_id, 0, 0, 0, board_id));
    }

    @Override
    public void insertLikes(LikesDTO like) {
        sqlSession.insert("insertLikes", like);
    }

    @Override
    public void cancelLikes(LikesDTO like) {
        sqlSession.update("cancelLikes", like);
    }
}

