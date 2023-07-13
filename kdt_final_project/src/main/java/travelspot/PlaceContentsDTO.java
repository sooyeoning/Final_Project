package travelspot;

public class PlaceContentsDTO {
	int contentId;
	
	/*관광지=12*/
	String infocenter; //문의 및 안내
	String chkbabycarriage; //유모차 대여
	String chkcreditcard; //신용카드
	String chkpet;	//애완동물
	String restdate; //쉬는날
	String usetime; //이용시간

	/*식당=39*/
	String infocenterfood; //문의 및 안내
	String kidsfacility; //어린이놀이방여부
	String chkcreditcardfood; //신용카드 가능정보
	String restdatefood; //쉬는날
	String opentimefood; //오픈시간
	String discountinfofood; //할인정보
	String firstmenu; //대표메뉴
	String reservationfood; //예약안내
	String packing; //포장가능
	String parkingfood; //주차시설
	
	/*문화시설=14*/
	String infocenterculture; //문의 및 안내
	String chkbabycarriageculture; //유모차대여
	String chkcreditcardculture; //신용카드가능정보
	String chkpetculture; //애완동물동반 가능정보
	String accomcountculture; //수용인원
	String parkingculture; //주차시설
	String parkingfee; //주차요금
	String restdateculture; //쉬는날
	String usefee; //이용요금
	String discountinfo; //할인정보
	String usetimeculture; //이용시간
	
	/*contentTypeId=28 (레포츠)	*/
	String infocenterleports; //문의 및 안내
	String chkbabycarriageleports; //유모차대여정보
	String chkcreditcardleports; //신용카드
	String chkpetleports; //애완동물
	String restdateleports; //쉬는날
	String usetimeleports;//이용시간
	String accomcountleports; //수용인원
	String openperiod; //개장기간
	String usefeeleports;//입장료
	String parkingleports; //주차시설
	String parkingfeeleports; //주차요금
	String reservation; //예약안내
	
	public PlaceContentsDTO() {	}

	//관광지 정보
	public PlaceContentsDTO(int contentId, String infocenter, String chkbabycarriage, String chkcreditcard,
			String chkpet, String restdate, String usetime) {
		this.contentId = contentId;
		this.infocenter = infocenter;
		this.chkbabycarriage = chkbabycarriage;
		this.chkcreditcard = chkcreditcard;
		this.chkpet = chkpet;
		this.restdate = restdate;
		this.usetime = usetime;
	}

	//식당 정보
	public PlaceContentsDTO(int contentId, String infocenterfood, String chkcreditcardfood, String discountinfofood,
			String firstmenu, String reservationfood, String restdatefood, String packing, String parkingfood,
			String kidsfacility, String opentimefood) {
		this.contentId = contentId;
		this.infocenterfood = infocenterfood;
		this.chkcreditcardfood = chkcreditcardfood;
		this.discountinfofood = discountinfofood;
		this.firstmenu = firstmenu;
		this.reservationfood = reservationfood;
		this.restdatefood = restdatefood;
		this.packing = packing;
		this.parkingfood = parkingfood;
		this.kidsfacility = kidsfacility;
		this.opentimefood = opentimefood;
	}

	//문화시설 정보
	public PlaceContentsDTO(int contentId, String accomcountculture, String chkbabycarriageculture,
			String chkcreditcardculture, String chkpetculture, String infocenterculture, String parkingculture,
			String parkingfee, String restdateculture, String usefee, String discountinfo, String usetimeculture) {
		this.contentId = contentId;
		this.accomcountculture = accomcountculture;
		this.chkbabycarriageculture = chkbabycarriageculture;
		this.chkcreditcardculture = chkcreditcardculture;
		this.chkpetculture = chkpetculture;
		this.infocenterculture = infocenterculture;
		this.parkingculture = parkingculture;
		this.parkingfee = parkingfee;
		this.restdateculture = restdateculture;
		this.usefee = usefee;
		this.discountinfo = discountinfo;
		this.usetimeculture = usetimeculture;
	}

	//레포츠시설 정보
	public PlaceContentsDTO(int contentId, String infocenterleports, String chkbabycarriageleports,
			String chkcreditcardleports, String chkpetleports, String restdateleports, String usetimeleports,
			String accomcountleports, String openperiod, String usefeeleports, String parkingleports,
			String parkingfeeleports, String reservation) {
		this.contentId = contentId;
		this.infocenterleports = infocenterleports;
		this.chkbabycarriageleports = chkbabycarriageleports;
		this.chkcreditcardleports = chkcreditcardleports;
		this.chkpetleports = chkpetleports;
		this.restdateleports = restdateleports;
		this.usetimeleports = usetimeleports;
		this.accomcountleports = accomcountleports;
		this.openperiod = openperiod;
		this.usefeeleports = usefeeleports;
		this.parkingleports = parkingleports;
		this.parkingfeeleports = parkingfeeleports;
		this.reservation = reservation;
	}

	

	
	
}