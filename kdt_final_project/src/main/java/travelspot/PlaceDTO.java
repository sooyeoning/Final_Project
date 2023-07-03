package travelspot;

public class PlaceDTO {
	int seq;
	int contentId;
	String title;
	int areaCode;
	String image1;
	String image2;
	String address;
	double mapx;
	double mapy;
	String contents;
	int viewcount;
	String writingtime;
	
	public PlaceDTO(int seq, int contentId, String title, int areaCode, String image1, String image2, String address,
			double mapx, double mapy, String contents, int viewcount, String writingtime) {
		this.seq = seq;
		this.contentId = contentId;
		this.title = title;
		this.areaCode = areaCode;
		this.image1 = image1;
		this.image2 = image2;
		this.address = address;
		this.mapx = mapx;
		this.mapy = mapy;
		this.contents = contents;
		this.viewcount = viewcount;
		this.writingtime = writingtime;
	}

	public PlaceDTO(int contentId, String title, int areaCode, String image1, String image2, String address,
			double mapx, double mapy) {
		this.contentId = contentId;
		this.title = title;
		this.areaCode = areaCode;
		this.image1 = image1;
		this.image2 = image2;
		this.address = address;
		this.mapx = mapx;
		this.mapy = mapy;
		//this.contents = contents;
	}

	public PlaceDTO(int contentId, String title, int areaCode, String image1, String address, double mapx,
			double mapy) {
		this.contentId = contentId;
		this.title = title;
		this.areaCode = areaCode;
		this.image1 = image1;
		this.address = address;
		this.mapx = mapx;
		this.mapy = mapy;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}
	
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getMapx() {
		return mapx;
	}
	public void setMapx(double mapx) {
		this.mapx = mapx;
	}
	public double getMapy() {
		return mapy;
	}
	public void setMapy(double mapy) {
		this.mapy = mapy;
	}
	/*
	 * public String getContents() { return contents; } public void
	 * setContents(String contents) { this.contents = contents; }
	 */
	
}
