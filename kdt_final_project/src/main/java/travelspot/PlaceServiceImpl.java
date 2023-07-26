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
	public void insertTheme12Detail(ContentsDTO contentsDTO) {
		placemapper.insertTheme12Detail(contentsDTO);
	}

	@Override
	public void insertTheme14Detail(ContentsDTO contentsDTO) {
		placemapper.insertTheme14Detail(contentsDTO);
	}

	@Override
	public void insertTheme39Detail(ContentsDTO contentsDTO) {
		placemapper.insertTheme39Detail(contentsDTO);
	}

	@Override
	public void insertTheme28Detail(ContentsDTO contentsDTO) {
		placemapper.insertTheme28Detail(contentsDTO);

	}

	@Override
	public int selectPlaceId(int contentId) {
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

	/*
	 * @Override public List<PlaceContentsDTO> searchThemePlace(HashMap<String,
	 * Object> map) { return placemapper.searchThemePlace(map); }
	 * 
	 * @Override public int searchThemePlaceCnt(HashMap<String, Object> map) {
	 * return placemapper.searchThemePlaceCnt(map); }
	 */

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
	public int selectContentId(int contentId) {
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
	public void insertTheme12Detail2(ContentsDTO contentsDTO) {
		placemapper.insertTheme12Detail2(contentsDTO);
	}

	@Override
	public void insertTheme39Detail2(ContentsDTO contentsDTO) {
		placemapper.insertTheme39Detail2(contentsDTO);
	}

	@Override
	public void insertTheme14Detail2(ContentsDTO contentsDTO) {
		placemapper.insertTheme14Detail2(contentsDTO);
	}

	@Override
	public void insertTheme28Detail2(ContentsDTO contentsDTO) {
		placemapper.insertTheme28Detail2(contentsDTO);
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
	public void CopyTheme12Detail(ContentsDTO contentsDTO) {
		placemapper.CopyTheme12Detail(contentsDTO);
	}

	@Override
	public void CopyTheme39Detail(ContentsDTO contentsDTO) {
		placemapper.CopyTheme39Detail(contentsDTO);
	}

	@Override
	public void CopyTheme14Detail(ContentsDTO contentsDTO) {
		placemapper.CopyTheme14Detail(contentsDTO);
	}

	@Override
	public void CopyTheme28Detail(ContentsDTO contentsDTO) {
		placemapper.CopyTheme28Detail(contentsDTO);
	}

	@Override
	public int getContentTypeId(int contentId) {
		return placemapper.getContentTypeId(contentId);
	}



}