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
	protected int getTicketType() {
		return ticketType;
	}
	protected void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	// 이용권 getter/setter
	protected int getTicketDay() {
		return ticketDay;
	}
	protected void setTicketDay(int ticketDay) {
		this.ticketDay = ticketDay;
	}
	// 주민번호 getter/setter
	protected String getIDNumber() {
		return IDNumber;
	}
	protected void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	// 연령대 getter/setter
	protected int getAge() {
		return age;
	}
	protected void setAge(int age) {
		this.age = age;
	}
	// 티켓수 getter/setter
	protected int getOrderCount() {
		return orderCount;
	}
	protected void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	// 할인된 개당 티겟값 getter/setter
	protected int getPrice() {
		return price;
	}
	protected void setPrice(int price) {
		this.price = price;
	}
	// 해당 지불 총합 getter/setter
	protected int getSum() {
		return sum;
	}
	protected void setSum(int sum) {
		this.sum = sum;
	}
	// 우대사항 getter/setter
	protected int getAdventageType() {
		return adventageType;
	}
	protected void setAdventageType(int adventageType) {
		this.adventageType = adventageType;
	}
}