package community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import User.LikesDTO;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDAOImpl likeDAO;

    @Override
    public LikesDTO getLikeByUserAndBoard(int userId, int boardId) {
        return likeDAO.getLikeByUserAndBoard(userId, boardId);
    }

    @Override
    public void createLike(int userId, int boardId) {
        LikesDTO like = new LikesDTO(0, userId, 1, 0, boardId);
        likeDAO.insertLikes(like);
    }

    @Override
    public void deleteLike(LikesDTO like) {
        likeDAO.cancelLikes(like);
    }
}
