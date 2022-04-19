package LotteTicketBox;

import java.util.ArrayList;

public class Ticketing { // main for ticketing programm
	protected static ArrayList<OrderData> orderList = new ArrayList<>(); // 티켓발권용 배열
	
	public static void main(String[] args) {
		CalTickets calc = new CalTickets();

		int isExit = 0;

		do { // main 간략화
			isExit = calc.repeatFunc(); // 반복용 while 함수분리
			orderList = new ArrayList<>(); // 해당 배열 초기화
		} while (isExit == 1); // if isExit == 2 => program end
	}
}