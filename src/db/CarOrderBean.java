package db;

//렌트할 차량에 대한 정보를 저장하는 빈클래스
public class CarOrderBean {

	private int orderid; // 자동차 렌트(대여) 주문id 저장
	// 렌트할 차량 차번호 저장 : 차번호로 조인하여 검색하기위해..
	private int carno; // 렌트할 차량 차번호 저장
	private int carqty;// 렌트 차량 대여 수량 저장
	private int carreserveday;// 대여기간 저장
	private String carbegindate;// 자동차를 렌트(대여)할 시작날짜 저장.
	private int carins;// 렌트시 보험적용 일수 저장
	private int carwifi;// 렌트시 무선wifi적용 일수 저장
	private int carnave;// 렌트시 네비게이션 적용여부 저장 (무료로 적용하면1, 미적용이면0)
	private int carbabyseat;// 렌트시 베이비시트적용 일수 저장
	private String memberphone;// 비회원으로 렌트할 사람 폰번호 저장
	private String memberpass;// 비회원으로 렌트시 주문 패스워드 저장

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCarno() {
		return carno;
	}

	public void setCarno(int carno) {
		this.carno = carno;
	}

	public int getCarqty() {
		return carqty;
	}

	public void setCarqty(int carqty) {
		this.carqty = carqty;
	}

	public int getCarreserveday() {
		return carreserveday;
	}

	public void setCarreserveday(int carreserveday) {
		this.carreserveday = carreserveday;
	}

	public String getCarbegindate() {
		return carbegindate;
	}

	public void setCarbegindate(String carbegindate) {
		this.carbegindate = carbegindate;
	}

	public int getCarins() {
		return carins;
	}

	public void setCarins(int carins) {
		this.carins = carins;
	}

	public int getCarwifi() {
		return carwifi;
	}

	public void setCarwifi(int carwifi) {
		this.carwifi = carwifi;
	}

	public int getCarnave() {
		return carnave;
	}

	public void setCarnave(int carnave) {
		this.carnave = carnave;
	}

	public int getCarbabyseat() {
		return carbabyseat;
	}

	public void setCarbabyseat(int carbabyseat) {
		this.carbabyseat = carbabyseat;
	}

	public String getMemberphone() {
		return memberphone;
	}

	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}

	public String getMemberpass() {
		return memberpass;
	}

	public void setMemberpass(String memberpass) {
		this.memberpass = memberpass;
	}

}
