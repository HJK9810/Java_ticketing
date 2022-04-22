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
	public int getTicketType() {
		return ticketType;
	}
	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	// �̿�� getter/setter
	public int getTicketDay() {
		return ticketDay;
	}
	public void setTicketDay(int ticketDay) {
		this.ticketDay = ticketDay;
	}
	// �ֹι�ȣ getter/setter
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	// ���ɴ� getter/setter
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// Ƽ�ϼ� getter/setter
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	// ���ε� ���� Ƽ�ٰ� getter/setter
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	// �ش� ���� ���� getter/setter
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	// ������ getter/setter
	public int getAdventageType() {
		return adventageType;
	}
	public void setAdventageType(int adventageType) {
		this.adventageType = adventageType;
	}
}