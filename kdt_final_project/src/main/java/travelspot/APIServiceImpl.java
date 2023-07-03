package travelspot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

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
	
	 @Autowired 
	 PlaceMapper placemapper;
	 
	 public void test(int areaCode) throws Exception{
		
		String totalurl = "http://apis.data.go.kr/B551011/KorService1/areaBasedList1?ServiceKey=V5T49DK1YRF29Mu4k6Fkn%2BXzVJry5UAPEVgaM0XM5ZvqYo3aoOyvLFFRgxdZ0KtsLJoXAx%2BswJPxcjmoxm8JYg%3D%3D&pageNo=1&numOfRows=100&MobileOS=ETC&arrange=O&areaCode="+areaCode+"&contentTypeId=12&MobileApp=test";
		
		  String serviceKey = "V5T49DK1YRF29Mu4k6Fkn%2BXzVJry5UAPEVgaM0XM5ZvqYo3aoOyvLFFRgxdZ0KtsLJoXAx%2BswJPxcjmoxm8JYg%3D%3D";
		  
		  StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");
		  
		  urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" +serviceKey); 
		  urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); 
		  urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); 
		  urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") +"=" + URLEncoder.encode("ETC", "UTF-8")); 
		  urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") +"=" + URLEncoder.encode("test", "UTF-8")); 
		  urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("O","UTF-8")); 
		  urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(areaCode), "UTF-8")); 
		  urlBuilder.append("&" +URLEncoder.encode("contentTypeId", "UTF-8") + "=" + URLEncoder.encode("12","UTF-8"));
		  
		  URL url = new URL(urlBuilder.toString()); 
		  HttpURLConnection conn =(HttpURLConnection) url.openConnection(); 
		  conn.setRequestMethod("GET");
		  conn.setRequestProperty("Content-type", "application/json");
		  
		  System.out.println("Response code: " + conn.getResponseCode());
		  BufferedReader rd; 
		  if (conn.getResponseCode() >= 200 &&conn.getResponseCode() <= 300) { 
			  rd = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
	     } else { 
	    	 rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); } 
		  StringBuilder sb = new StringBuilder(); //변경 가능한 문자열 
		  String line; 
		  while ((line =rd.readLine()) != null) { sb.append(line); } rd.close(); conn.disconnect();
		  String result = sb.toString(); 
		  System.out.println(sb.toString());
		  
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
			}//if
		}//for
	 }//test method
	 
	private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}

}//class

