package community;

import User.LikesDTO;

public interface LikeDAO {
	LikesDTO getLikeByUserAndBoard(int user_id, int board_id);
    void insertLikes(LikesDTO like);
    void cancelLikes(LikesDTO like);
}

