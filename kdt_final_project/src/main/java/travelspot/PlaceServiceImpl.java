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
	public List<PlaceDTO> listThemePlaces(HashMap<String, Object> param) {
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
	public void insertTheme12Detail(PlaceContentsDTO placecontentsDTO) {
		placemapper.insertTheme12Detail(placecontentsDTO);
	}

	@Override
	public void insertTheme14Detail(PlaceContentsDTO placecontentsDTO) {
		placemapper.insertTheme14Detail(placecontentsDTO);
	}
	
	@Override
	public void insertTheme39Detail(PlaceContentsDTO placecontentsDTO) {
		placemapper.insertTheme39Detail(placecontentsDTO);
	}

	@Override
	public void insertTheme28Detail(PlaceContentsDTO placecontentsDTO) {
		placemapper.insertTheme28Detail(placecontentsDTO);
		
	}

	@Override
	public int selectPlaceId(int contentId) {
		return placemapper.selectPlaceId(contentId);
	}

	@Override
	public PlaceContentsDTO getThemeDetail(int contentId) {
		return placemapper.getThemeDetail(contentId);
	}

}
