package LotteTicketBox;

import java.util.ArrayList;

public class TicketSys {
	protected void ticketingSystem() { // main 에서 돌아갈 메인 시스템 함수
		// 각 class 정의 => static이 아니기에 정의 필수
		InputData input = new InputData(); // 입력용
		PrintUI pui = new PrintUI(); // ui 출력용
		CalTickets calc = new CalTickets(); // 계산용
		SaveVals save = new SaveVals(); // 데이터 저장 & 파일 저장용
		
		OrderData orderitem = new OrderData(); // 정의
		int isExit = 0; // 프로그램 종료를 위한 확인변수
		
		do { // main 간략화
			int totalSum = 0; // '한번에' 발급한 전체 티켓값 총합
			while (true) {
				orderitem.setTicketType(pui.ticketTypeAll()); // 종합 or 파크
				orderitem.setTicketDay(pui.ticketTypeDay()); // 종일 or 오후
				orderitem.setIDNumber(input.inputResidentNum()); // 주민번호 앞자리
				orderitem.setOrderCount(input.ticketsCount()); // 티켓수
				orderitem.setAdventageType(input.ticketSale(orderitem.getTicketType())); // 우대할인적용

				orderitem.setAge(calc.CalAge(orderitem.getIDNumber())); // 연령대계산
				int price = calc.checkTicketPrice(orderitem); // 티켓 정가
				orderitem.setPrice(calc.salePriceCal(price, orderitem.getAdventageType())); // 할인가 적용 티켓값
				orderitem.setSum(calc.ticketSum(price, orderitem.getAdventageType(), orderitem.getOrderCount(), orderitem.getPrice())); // 티켓값 총합
				save.saveOrder(orderitem); // 해당 데이터, arraylist에 저장
				totalSum += orderitem.getSum(); // 누적총합
				int check = pui.printReapeat(orderitem.getSum()); // 추가발권질문
				if (check == StaticValue.END) break; // 반복문 out
				orderitem = new OrderData(); // 초기화
			}
			pui.printTickets(totalSum); // 발권한 티켓 종류 & 수 & 가격등 출력
			save.inputFile(); // 해당 파일에 입력
			isExit = pui.inputEnd(); // 종료질문
			SaveVals.orderList = new ArrayList<>(); // 해당 배열 초기화
		} while (isExit == 1); // if isExit == 2 => program end
	}
}