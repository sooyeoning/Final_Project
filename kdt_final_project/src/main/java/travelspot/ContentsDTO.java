package travelspot;

public class ContentsDTO {
	int contentId; //
	String infocenter; // 안내소
	String chkbabycarriage; // 유모차 대여
	String chkcreditcard; // 신용카드 사용가능 유무
	String chkpet; // 애완동물 가능 여부
	String kidsfacility; // 놀이방 여부
	String restdate; // 쉬는날
	String usetime; // 이용시간
	String discountinfo; // 할인정보
	String firstmenu; // 대표메뉴
	String reservationinfo; // 예약정보
	String takeout; // 포장여부
	String parking; // 주차시설
	String parkingfee; // 주차비용
	String accomcount; // 수용인원
	String usefee; // 입장비용

	public ContentsDTO() {
	};

	public ContentsDTO(int contentId, String infocenter, String chkbabycarriage, String chkcreditcard, String chkpet,
			String kidsfacility, String restdate, String usetime, String discountinfo, String firstmenu,
			String reservationinfo, String takeout, String parking, String parkingfee, String accomcount,
			String usefee) {
		this.contentId = contentId;
		this.infocenter = infocenter;
		this.chkbabycarriage = chkbabycarriage;
		this.chkcreditcard = chkcreditcard;
		this.chkpet = chkpet;
		this.kidsfacility = kidsfacility;
		this.restdate = restdate;
		this.usetime = usetime;
		this.discountinfo = discountinfo;
		this.firstmenu = firstmenu;
		this.reservationinfo = reservationinfo;
		this.takeout = takeout;
		this.parking = parking;
		this.parkingfee = parkingfee;
		this.accomcount = accomcount;
		this.usefee = usefee;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getInfocenter() {
		return infocenter;
	}

	public void setInfocenter(String infocenter) {
		this.infocenter = infocenter;
	}

	public String getChkbabycarriage() {
		return chkbabycarriage;
	}

	public void setChkbabycarriage(String chkbabycarriage) {
		this.chkbabycarriage = chkbabycarriage;
	}

	public String getChkcreditcard() {
		return chkcreditcard;
	}

	public void setChkcreditcard(String chkcreditcard) {
		this.chkcreditcard = chkcreditcard;
	}

	public String getChkpet() {
		return chkpet;
	}

	public void setChkpet(String chkpet) {
		this.chkpet = chkpet;
	}

	public String getKidsfacility() {
		return kidsfacility;
	}

	public void setKidsfacility(String kidsfacility) {
		this.kidsfacility = kidsfacility;
	}

	public String getRestdate() {
		return restdate;
	}

	public void setRestdate(String restdate) {
		this.restdate = restdate;
	}

	public String getUsetime() {
		return usetime;
	}

	public void setUsetime(String usetime) {
		this.usetime = usetime;
	}

	public String getDiscountinfo() {
		return discountinfo;
	}

	public void setDiscountinfo(String discountinfo) {
		this.discountinfo = discountinfo;
	}

	public String getFirstmenu() {
		return firstmenu;
	}

	public void setFirstmenu(String firstmenu) {
		this.firstmenu = firstmenu;
	}

	public String getReservationinfo() {
		return reservationinfo;
	}

	public void setReservationinfo(String reservationinfo) {
		this.reservationinfo = reservationinfo;
	}

	public String getTakeout() {
		return takeout;
	}

	public void setTakeout(String takeout) {
		this.takeout = takeout;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getParkingfee() {
		return parkingfee;
	}

	public void setParkingfee(String parkingfee) {
		this.parkingfee = parkingfee;
	}

	public String getAccomcount() {
		return accomcount;
	}

	public void setAccomcount(String accomcount) {
		this.accomcount = accomcount;
	}

	public String getUsefee() {
		return usefee;
	}

	public void setUsefee(String usefee) {
		this.usefee = usefee;
	}

}