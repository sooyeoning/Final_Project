package travelspot;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	PlaceMapper placemapper;

	@Override
	public PlaceDTO selectPlace(int contentId) {
		return placemapper.selectPlace(contentId);
	}

	@Override
	public List<PlaceDTO> listPlaces(HashMap<String, Object> param) {
		return placemapper.listPlaces(param);
	}

	@Override
	public int getTotalCnt(int areaCode) {
		return placemapper.getTotalCnt(areaCode);
	}

	@Override
	public List<PlaceContentsDTO> listThemePlaces(HashMap<String, Object> param) {
		return placemapper.listThemePlaces(param);
	}

	@Override
	public int getTotalThemeCnt(String theme) {
		return placemapper.getTotalThemeCnt(theme);
	}

	@Override
	public void insertThemeBasicInfo(PlaceDTO placeDTO) {
		placemapper.insertThemeBasicInfo(placeDTO);
	}

	@Override
	public void updateThemePlace(PlaceDTO placeDTO) {
		placemapper.updateThemePlace(placeDTO);
	}

	@Override
	public String selectPlaceId(int contentId) {
		return placemapper.selectPlaceId(contentId);
	}

	@Override
	public PlaceContentsDTO getPlaceContentThemeDetail(int contentId) {
		return placemapper.getPlaceContentThemeDetail(contentId);
	}

	@Override
	public PlaceDTO getPlaceThemeDetail(int id) {
		return placemapper.getPlaceThemeDetail(id);
	}

	@Override
	public void plusViewCount(int contentId) {
		placemapper.plusViewCount(contentId);
	}

	@Override
	public void likePlace(int contentId) {
		placemapper.likePlace(contentId);
	}

	@Override
	public Integer CheckPlaceLikes(HashMap<String, Integer> map) {
		return placemapper.CheckPlaceLikes(map);
	}

	@Override
	public void insertLikes(HashMap<String, Integer> map) {
		placemapper.insertLikes(map);
	}

	@Override
	public List<PlaceDTO> searchPlace(HashMap<String, Object> map) {
		return placemapper.searchPlace(map);
	}

	@Override
	public int searchPlaceCnt(HashMap<String, Object> map) {
		return placemapper.searchPlaceCnt(map);
	}

	@Override
	public List<PlaceContentsDTO> searchThemePlaces(HashMap<String, Object> map) {
		return placemapper.searchThemePlaces(map);
	}

	@Override
	public int searchThemePlacesCnt(HashMap<String, Object> map) {
		return placemapper.searchThemePlacesCnt(map);
	}

	@Override
	public void cancelLikes(HashMap<String, Integer> map) {
		placemapper.cancelLikes(map);
	}

	@Override
	public Integer cancelPlaceLike(int contentId) {
		return placemapper.cancelPlaceLike(contentId);
	}

	@Override
	public String selectContentId(int contentId) {
		return placemapper.selectContentId(contentId);
	}

	@Override
	public void insertPlaces2(PlaceDTO placeDTO) {
		placemapper.insertPlaces2(placeDTO);
	}

	@Override
	public void insertThemeBasicInfo2(PlaceDTO placeDTO) {
		placemapper.insertThemeBasicInfo2(placeDTO);
	}

	@Override
	public void updateThemePlace2(PlaceDTO placeDTO) {
		placemapper.updateThemePlace2(placeDTO);
	}

	@Override
	public String selectPlaceId2(int contentId) {
		return placemapper.selectPlaceId2(contentId);
	}

	@Override
	public String selectContentId2(int contentId) {
		return placemapper.selectContentId2(contentId);
	}

	@Override
	public void copyTablePlace2(PlaceDTO placeDTO) {
		placemapper.copyTablePlace2(placeDTO);
	}

	@Override
	public List<PlaceDTO> selectAllPlace() {
		return placemapper.selectAllPlace();
	}

	@Override
	public List<ContentsDTO> selectAllContents() {
		return placemapper.selectAllContents();
	}

	@Override
	public void updatePlace2(PlaceDTO placeDTO) {
		placemapper.updatePlace2(placeDTO);
	}

	@Override
	public int getContentTypeId(int contentId) {
		return placemapper.getContentTypeId(contentId);
	}

	@Override
	public int updateThemeDetail(ContentsDTO contentsDTO2) {
		return placemapper.updateThemeDetail(contentsDTO2);
	}

	@Override
	public int insertThemeDetail(ContentsDTO contentDTO2) {
		return placemapper.insertThemeDetail(contentDTO2);
	}

	@Override
	public int copyThemeDetail(ContentsDTO contentDTO2) {
		return placemapper.copyThemeDetail(contentDTO2);
	}

	@Override
	public void insertPlaces(PlaceDTO placeDTO) {
		placemapper.insertPlaces(placeDTO);
	}

	@Override
	public int updateThemeDetail2(ContentsDTO contentsDTO2) {
		return placemapper.updateThemeDetail2(contentsDTO2);
	}

	@Override
	public int insertThemeDetail2(ContentsDTO contentDTO2) {
		return placemapper.insertThemeDetail2(contentDTO2);
	}

}