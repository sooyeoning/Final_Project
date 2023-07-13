package travelspot;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper 	//매퍼 파일이야, @MapperScan 필요 
@Repository //객체 생성, @ComponentScan 필요
public interface PlaceMapper {
	 public void insertPlaces(PlaceDTO placeDTO);
	 public List<PlaceDTO> listPlaces(HashMap<String, Object> param);
	 public PlaceDTO selectPlace(int contentId);
	 public int selectPlaceId(int contentId);
	 public int getTotalCnt(int areaCode);
	 public List<PlaceContentsDTO> listThemePlaces(HashMap<String, Object> param);
	 public int getTotalThemeCnt(String theme);
	 public void insertThemeBasicInfo(PlaceDTO placeDTO);
	 public void updateThemePlace(PlaceDTO placeDTO);
	 public void insertTheme12Detail(ContentsDTO contentsDTO);
	 public void insertTheme39Detail(ContentsDTO contentsDTO);
	 public void insertTheme14Detail(ContentsDTO contentsDTO);
	 public void insertTheme28Detail(ContentsDTO contentsDTO);
	 public PlaceContentsDTO getThemeDetail(int contentId);
}
