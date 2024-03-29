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
		
		do { // main 간략화
			int totalSum = 0; // '한번에' 발급한 전체 티켓값 총합
			while (true) {
				input.startinput(orderitem); // 시스템 총 input부분
				calc.sysCal(orderitem); // 시스템 총 계산부분

				save.saveOrder(orderitem); // 해당 데이터, arraylist에 저장
 				totalSum += orderitem.getSum(); // 누적총합
				if (pui.printReapeat(orderitem.getSum()) == StaticValue.END) break; // 추가발권질문 => 반복문 out
				orderitem = new OrderData(); // 초기화
			}
			pui.printTickets(totalSum); // 발권한 티켓 종류 & 수 & 가격등 출력
			save.inputFile(); // 해당 파일에 입력
			SaveVals.orderList = new ArrayList<>(); // 해당 배열 초기화
		} while (pui.inputEnd() == StaticValue.CONTINUE); // if isExit == 2 => program end
	}
}