package travelspot;

import java.util.HashMap;
import java.util.List;


public interface PlaceService {
	 public List<PlaceDTO> listPlaces(HashMap<String, Object> param);
	 public PlaceDTO selectPlace(int contentId);
	 public int getTotalCnt(int areaCode);
	 public List<PlaceDTO> listThemePlaces(HashMap<String, Object> param);
	 public int getTotalThemeCnt(String theme);
	 public void insertThemeBasicInfo(PlaceDTO placeDTO);
	 public void updateThemePlace(PlaceDTO placeDTO);

}
