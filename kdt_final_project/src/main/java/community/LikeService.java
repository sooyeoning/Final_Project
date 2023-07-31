package community;

import User.LikesDTO;

public interface LikeService {
    LikesDTO getLikeByUserAndBoard(int userId, int boardId);
    void createLike(int userId, int boardId);
    void deleteLike(LikesDTO like);
}

