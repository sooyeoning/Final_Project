package travelspot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIControllerTest {

	private final APIServiceImpl apiServiceImpl;
	
	@Autowired
	PlaceMapper placemapper;
	
	public APIControllerTest(APIServiceImpl apiServiceImpl) {
		this.apiServiceImpl = apiServiceImpl;
	}
	
	@PostMapping("/api/test")
	public String apiCallTest() throws Exception {
		
		int[] areaCodes = {32,6,2,5,7,31};
		for(int i=0; i<areaCodes.length; i++) {
			apiServiceImpl.getBasicInfo(areaCodes[i]);
		}
		
		apiServiceImpl.getThemeBasicInfo();

		/*List<PlaceDTO> placelist = placemapper.selectAllPlace();
		
		for (PlaceDTO one : placelist) {
			placemapper.copyTablePlace2(one);
		}
		apiServiceImpl.getThemeBasicInfo();
		

		
		List<ContentsDTO> contentlist = placemapper.selectAllContents();

		for (ContentsDTO one : contentlist) {
			System.out.println(one.toString());
			int result = placemapper.copyThemeDetail(one);
			System.out.println("변화된 행의 갯수: "+result);
			*/
			/*
			if (PlaceContentType.TOUR.getCode() == contentTypeId) {
				System.out.println(one.toString());
				int result = placemapper.CopyThemeDetail(one);
				System.out.println("변화된 행의 갯수: "+result);
			}
			*/

		return "ok";
	}
	
	@PostMapping("/api/test/place/detail")
	public String apiTestPlaceDetail(@RequestParam("contentId") int contentId) throws Exception {
		apiServiceImpl.getThemePlaceDetail(contentId);
		return "ok";
	}
	
	
	
}
