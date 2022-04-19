package LotteTicketBox;

import java.util.ArrayList;

public class Ticketing { // main for ticketing programm
	protected static ArrayList<OrderData> orderList = new ArrayList<>(); // 티켓발권용 배열
	
	public static void main(String[] args) {
		InputData input = new InputData();
		input.ticketingSystem(); // 주 시스템 함수
	}
}