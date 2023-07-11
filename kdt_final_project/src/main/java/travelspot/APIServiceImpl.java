package travelspot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service("apiservice")
public class APIServiceImpl {

	//상세정보 가져오기
	String serviceKey = "A7Izc9O8PXKHKY%2FsWnQUYwt5u6dujTuf3unurHLSOEIfHLv%2F7waxlcZgPnRqpsKUO60J64lzoZ%2FYO3wW5sH1rw%3D%3D";
	StringBuilder urlBuilder;
	
	@Autowired
	PlaceMapper placemapper;

	//전체 관광지 추천용: 테마 없는 기본 장소 불러오기(지역코드 이용)
	public void getBasicInfo(int areaCode) throws Exception {

		String totalurl = "http://apis.data.go.kr/B551011/KorService1/areaBasedList1?ServiceKey=V5T49DK1YRF29Mu4k6Fkn%2BXzVJry5UAPEVgaM0XM5ZvqYo3aoOyvLFFRgxdZ0KtsLJoXAx%2BswJPxcjmoxm8JYg%3D%3D&pageNo=1&numOfRows=100&MobileOS=ETC&arrange=O&areaCode="
				+ areaCode + "&contentTypeId=12&MobileApp=test";

		urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");

		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("test", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("O", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(areaCode), "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"));
		url(urlBuilder);

		DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
		Document doc = dBuilder.parse(totalurl);

		NodeList nList = doc.getElementsByTagName("item");

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				int contentId = Integer.valueOf(getValue("contentid", eElement));
				String title = getValue("title", eElement);
				int areaCode1 = Integer.valueOf(getValue("areacode", eElement));
				String image1 = getValue("firstimage", eElement);
				String address = getValue("addr1", eElement);
				double mapx = Double.valueOf(getValue("mapx", eElement));
				double mapy = Double.valueOf(getValue("mapy", eElement));
				// String contents = getValue("", eElement);

				PlaceDTO placeDTO = new PlaceDTO(contentId, title, areaCode1, image1, address, mapx, mapy);
				System.out.println(placeDTO.toString());

				placemapper.insertPlaces(placeDTO);
			} // if
		} // for
	}// test method
		
	//캠핑(친구) http://apis.data.go.kr/B551011/KorService1/areaBasedList1?numOfRows=12&pageNo=1&MobileOS=ETC&MobileApp=AppTest&ServiceKey=인증키&listYN=Y&arrange=A&contentTypeId=&areaCode=&sigunguCode=&cat1=C01&cat2=C0116&cat3=C01160001
	//힐링(연인) http://apis.data.go.kr/B551011/KorService1/areaBasedList1?numOfRows=12&pageNo=1&MobileOS=ETC&MobileApp=AppTest&ServiceKey=인증키&listYN=Y&arrange=A&contentTypeId=&areaCode=&sigunguCode=&cat1=C01&cat2=C0114&cat3=C01140001
	//혼자 http://apis.data.go.kr/B551011/KorService1/areaBasedList1?numOfRows=12&pageNo=1&MobileOS=ETC&MobileApp=AppTest&ServiceKey=인증키&listYN=Y&arrange=A&contentTypeId=&areaCode=&sigunguCode=&cat1=C01&cat2=C0113&cat3=C01130001
	//가족 http://apis.data.go.kr/B551011/KorService1/areaBasedList1?numOfRows=12&pageNo=1&MobileOS=ETC&MobileApp=AppTest&ServiceKey=인증키&listYN=Y&arrange=A&contentTypeId=&areaCode=&sigunguCode=&cat1=C01&cat2=C0112&cat3=C01120001

	//테마별 게시글 contentId 불러오기
	public void getThemeBasicInfo() throws Exception {
		//(36)String friendUrl = "http://apis.data.go.kr/B551011/KorService1/areaBasedList1?numOfRows=12&pageNo=1&MobileOS=ETC&MobileApp=AppTest&ServiceKey="+serviceKey+"&listYN=Y&arrange=A&contentTypeId=&areaCode=&sigunguCode=&cat1=C01&cat2=C0116&cat3=C01160001";
		//(147)	String coupleUrl = "http://apis.data.go.kr/B551011/KorService1/areaBasedList1?numOfRows=12&pageNo=1&MobileOS=ETC&MobileApp=AppTest&ServiceKey="+serviceKey+"&listYN=Y&arrange=A&contentTypeId=&areaCode=&sigunguCode=&cat1=C01&cat2=C0114&cat3=C01140001";
		//(54)String aloneUrl = "http://apis.data.go.kr/B551011/KorService1/areaBasedList1?numOfRows=12&pageNo=1&MobileOS=ETC&MobileApp=AppTest&ServiceKey="+serviceKey+"&listYN=Y&arrange=A&contentTypeId=&areaCode=&sigunguCode=&cat1=C01&cat2=C0113&cat3=C01130001";
		//(36)String familyUrl = "http://apis.data.go.kr/B551011/KorService1/areaBasedList1?numOfRows=12&pageNo=1&MobileOS=ETC&MobileApp=AppTest&ServiceKey="+serviceKey+"&listYN=Y&arrange=A&contentTypeId=&areaCode=&sigunguCode=&cat1=C01&cat2=C0112&cat3=C01120001";
		
		String[] themeList = new String[] {"friends","couple","alone","family"};
		//String[] urlList = new String[] {friendUrl, coupleUrl, aloneUrl, familyUrl };
		String[] numOfRowsList = new String[] {"10", "10", "10", "10"};
		String[] cat2List = new String[] {"C0116", "C0114", "C0113", "C0112"};
		String[] cat3List = new String[] {"C01160001", "C01140001", "C01130001", "C01120001"};

		for(int i=0; i<themeList.length; i++) {
		urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");

		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(numOfRowsList[i], "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("A", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("cat1", "UTF-8") + "=" + URLEncoder.encode("C01", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("cat2", "UTF-8") + "=" + URLEncoder.encode(cat2List[i], "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("cat3", "UTF-8") + "=" + URLEncoder.encode(cat3List[i], "UTF-8"));

		url(urlBuilder);

		DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
		Document doc = dBuilder.parse(String.valueOf(urlBuilder));
		
		NodeList nList = doc.getElementsByTagName("item");
		ArrayList<Integer> contentIdList = new ArrayList<Integer>();
		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				int contentId = Integer.valueOf(getValue("contentid", eElement));
				contentIdList.add(contentId);
												
			} // if
			//	System.out.println(contentIdList.get(i));
		} // for
		// arraylist 잘 들어갔는지 확인용: System.out.println(contentIdList.size());
		
		getThemeInfo(contentIdList, themeList[i]); //기본 정보 DB 등록 - 장소명, 테마, id
		
		}//url for
	}// test method
	
	//테마 장소 불러오기 -> 장소 arrayList 가져와서 상세정보 insert(for문)
	public void getThemeInfo(ArrayList<Integer> contentIdList, String theme) throws Exception {

		for (int i = 0; i < contentIdList.size(); i++) {
			urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/detailInfo1");
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
			urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=" + URLEncoder.encode("25", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("contentId", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(contentIdList.get(i)), "UTF-8"));

			url(urlBuilder);
					
			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder(); 
			Document doc = dBuilder.parse(urlBuilder.toString());
			ArrayList<Integer> placeContentIds = new ArrayList<Integer>();
			
			NodeList nList = doc.getElementsByTagName("item");
			
			for (int temp = 0; temp < nList.getLength(); temp++) { 
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) { 
					Element eElement = (Element)nNode;
					
					//null 체크
					int contentId = Integer.valueOf(getValue("subcontentid", eElement)); 
					String title = getValue("subname", eElement); 
					
					PlaceDTO placeDTO = new PlaceDTO(contentId, title, theme); 
					//DB 저장 확인용: System.out.println(placeDTO.toString());
					placeContentIds.add(contentId);
					
					//DB 해당 content 존재하는지 확인
					if(placemapper.selectPlace(placeDTO.contentId) == null) {			
						placemapper.insertThemeBasicInfo(placeDTO); //contentId, title만 저장
					}
					
				}//if 
			}//for
			getThemePlaceDetail(placeContentIds);
			
		}//contentIdList for

	}// test method

	//장소별 정보 불러오기**
	public void getThemePlaceDetail(ArrayList<Integer> placeContentIds) throws Exception {
		
		for (int i = 0; i < placeContentIds.size(); i++) {

		urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/detailCommon1");
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("test", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("contentId", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(placeContentIds.get(i)), "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("overviewYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); //개요
		urlBuilder.append("&" + URLEncoder.encode("addrinfoYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); //주소
		urlBuilder.append("&" + URLEncoder.encode("mapinfoYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); //좌표
		urlBuilder.append("&" + URLEncoder.encode("areacodeYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); //지역코드
		urlBuilder.append("&" + URLEncoder.encode("firstImageYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); //대표이미지
		urlBuilder.append("&" + URLEncoder.encode("defaultYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); //기본정보

		url(urlBuilder);

		DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
		Document doc = dBuilder.parse(String.valueOf(urlBuilder));

		NodeList nodeList = doc.getElementsByTagName("item"); //xml 태그 이름 중 <item>인 부분을 전부 가져온다(NodeList 타입)
		Node node = nodeList.item(0); //모든 <item> 태그 중 첫번째 node
		Element e = (Element)node; //태그 안에 있는 요소를 가져오기 위해 Element로 형변환 해야한다
		
		if(e != null) {
		System.out.println(getValue("contentid", e));
		
		PlaceDTO placedto = new PlaceDTO();
		
		//null체크
		placedto.contentId = Integer.parseInt(getValue("contentid", e));
		placedto.title = getValue("title", e);
		placedto.areaCode = Integer.parseInt(getValue("areacode", e));
		placedto.image1 = getValue("firstimage", e);
		placedto.address = getValue("addr1", e).concat(getValue("addr2",e));
		placedto.mapx = Double.parseDouble(getValue("mapx", e));
		placedto.mapy = Double.parseDouble(getValue("mapy", e));
		placedto.contents = getValue("overview", e);
		placedto.homepage = getValue("homepage", e);
		
		placemapper.updateThemePlace(placedto);
		}
		
		}//바깥 for문
	}//method
	
	public void url(StringBuilder urlBuilder) throws Exception{
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		StringBuilder sb = new StringBuilder(); // 변경 가능한 문자열: StringBuilder
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();

		String result = sb.toString();
		System.out.println(result);
	}

	private static String getValue(String tag, Element element) {
		//태그 이름이 매개변수인 노드를 찾아 > 찾은 노드에서 n번째 노드에 접근 > n번째 노드 안에 정보에 접근할 수 있는 nodelist
		String result;
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		if(node == null) {
			result = "null";
		} else {
			result = node.getNodeValue();
		}
		 
		return result;
	}
	
}// class
