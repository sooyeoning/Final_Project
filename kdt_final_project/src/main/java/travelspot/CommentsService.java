package travelspot;

import java.util.List;

public interface CommentsService {

	public List<CommentsDTO> getComments(int place_id);
	}
