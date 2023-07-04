package travelspot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	CommentsMapper commentsmapper;

	@Override
	public List<CommentsDTO> getComments(int place_id) {
		return commentsmapper.getComments(place_id);
	}



}
