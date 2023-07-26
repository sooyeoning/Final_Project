package travelspot;

import java.util.HashMap;
import java.util.List;


public interface PlaceService {
	 public List<PlaceDTO> listPlaces(HashMap<String, Object> param);
	 public PlaceDTO selectPlace(int contentId);
	 public int selectPlaceId(int contentId);
	 public int selectContentId(int contentId);//contents 테이블 정보 유무 조회
	 public void plusViewCount(int contentId); //조회수 증가
	 public int getTotalCnt(int areaCode);
	 public int getTotalThemeCnt(String theme);
	 public void insertThemeBasicInfo(PlaceDTO placeDTO);
	 public void updateThemePlace(PlaceDTO placeDTO);
	 public void insertTheme12Detail(ContentsDTO contentsDTO);
	 public void insertTheme39Detail(ContentsDTO contentsDTO);
	 public void insertTheme14Detail(ContentsDTO contentsDTO);
	 public void insertTheme28Detail(ContentsDTO contentsDTO);
	 public List<PlaceContentsDTO> listThemePlaces(HashMap<String, Object> param);
	 public PlaceContentsDTO getPlaceContentThemeDetail(int contentId);
	 public PlaceDTO getPlaceThemeDetail(int id);
	 public void likePlace(int contentId);
	 public Integer CheckPlaceLikes(HashMap<String, Integer> map);
	 public void insertLikes(HashMap<String, Integer> map);
	 public List<PlaceDTO> searchPlace(HashMap<String, Object> map);
	public int searchPlaceCnt(HashMap<String, Object> map);
	 public List<PlaceContentsDTO> searchThemePlaces(HashMap<String, Object> map);//테마검색
	 public int searchThemePlacesCnt(HashMap<String, Object> map);
	 public void cancelLikes(HashMap<String, Integer> map);
	 public Integer cancelPlaceLike(int contentId);
	 //
	 public void insertPlaces2(PlaceDTO placeDTO);
	 public void insertThemeBasicInfo2(PlaceDTO placeDTO);
	 public void updateThemePlace2(PlaceDTO placeDTO);
	 public void insertTheme12Detail2(ContentsDTO contentsDTO);
	 public void insertTheme39Detail2(ContentsDTO contentsDTO);
	 public void insertTheme14Detail2(ContentsDTO contentsDTO);
	 public void insertTheme28Detail2(ContentsDTO contentsDTO);
	 public String selectPlaceId2(int contentId);
	 public String selectContentId2(int contentId);//contents 테이블 정보 유무 조회
	 public void copyTablePlace2(PlaceDTO placeDTO);
	 public List<PlaceDTO> selectAllPlace();
	 public List<ContentsDTO> selectAllContents();
	 public void updatePlace2(PlaceDTO placeDTO);
	 public void CopyTheme12Detail(ContentsDTO contentsDTO);
	 public void CopyTheme39Detail(ContentsDTO contentsDTO);
	 public void CopyTheme14Detail(ContentsDTO contentsDTO);
	 public void CopyTheme28Detail(ContentsDTO contentsDTO);
	 public int getContentTypeId(int contentId);

}