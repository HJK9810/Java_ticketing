package LotteTicketBox;

public class OrderData {
	protected int ticketType; // 권종 - 종합 or 파크
	protected int ticketDay; // 이용권 - 1day or after4
	protected String IDNumber; // 주민번호 앞자리
	protected int age; // 나이타입
	protected int orderCount; // 티켓수 - max = 10
	protected int price; // 할인 미적용 티켓값
	protected int adventageType; // 우대사항
}