package TicketBox;

public class OrderData {
	private int ticketType; // 권종 - 종합 or 파크
	private int ticketDay; // 이용권 - 1day or after4
	private String IDNumber; // 주민번호 앞자리
	private int age; // 나이타입
	private int orderCount; // 티켓수 - max = 10
	private int price; // 할인 미적용 티켓값
	private int sum; // 티켓값
	private int adventageType; // 우대사항
	
	// 권종 getter/setter
	public int getTicketType() {
		return ticketType;
	}
	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	// 이용권 getter/setter
	public int getTicketDay() {
		return ticketDay;
	}
	public void setTicketDay(int ticketDay) {
		this.ticketDay = ticketDay;
	}
	// 주민번호 getter/setter
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	// 연령대 getter/setter
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// 티켓수 getter/setter
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	// 할인된 개당 티겟값 getter/setter
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	// 해당 지불 총합 getter/setter
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	// 우대사항 getter/setter
	public int getAdventageType() {
		return adventageType;
	}
	public void setAdventageType(int adventageType) {
		this.adventageType = adventageType;
	}
}