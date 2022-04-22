package TicketBox;

public class OrderData {
	private int ticketType; // ���� - ���� or ��ũ
	private int ticketDay; // �̿�� - 1day or after4
	private String IDNumber; // �ֹι�ȣ ���ڸ�
	private int age; // ����Ÿ��
	private int orderCount; // Ƽ�ϼ� - max = 10
	private int price; // ���� ������ Ƽ�ϰ�
	private int sum; // Ƽ�ϰ�
	private int adventageType; // ������
	
	// ���� getter/setter
	protected int getTicketType() {
		return ticketType;
	}
	protected void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	// �̿�� getter/setter
	protected int getTicketDay() {
		return ticketDay;
	}
	protected void setTicketDay(int ticketDay) {
		this.ticketDay = ticketDay;
	}
	// �ֹι�ȣ getter/setter
	protected String getIDNumber() {
		return IDNumber;
	}
	protected void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	// ���ɴ� getter/setter
	protected int getAge() {
		return age;
	}
	protected void setAge(int age) {
		this.age = age;
	}
	// Ƽ�ϼ� getter/setter
	protected int getOrderCount() {
		return orderCount;
	}
	protected void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	// ���ε� ���� Ƽ�ٰ� getter/setter
	protected int getPrice() {
		return price;
	}
	protected void setPrice(int price) {
		this.price = price;
	}
	// �ش� ���� ���� getter/setter
	protected int getSum() {
		return sum;
	}
	protected void setSum(int sum) {
		this.sum = sum;
	}
	// ������ getter/setter
	protected int getAdventageType() {
		return adventageType;
	}
	protected void setAdventageType(int adventageType) {
		this.adventageType = adventageType;
	}
}