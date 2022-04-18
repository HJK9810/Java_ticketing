package LotteTicketBox;

public class Ticketing { // main for ticketing programm
	// 없음, 장애, 유공자, 휴가장병, 임산부, 다둥이
	final int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;
	protected static int[][] orderList = new int[100][6]; // 티켓발권용 배열

	public static void main(String[] args) {
		InputData input = new InputData();
		PrintUI pui = new PrintUI();
		CalTickets calc = new CalTickets();
		SaveVals save = new SaveVals();

		int isExit = 0;

		do {
			int totalSum = 0; // 모든 티켓값 총합
			int position = 0;
			while (true) {
				int typeAll = pui.ticketTypeAll(); // 종합 or 파크
				int typeDay = pui.ticketTypeDay(); // 종일 or 오후
				int residentNum = input.inputResidentNum(); // 주민번호 앞자리
				int count = input.ticketsCount(); // 티켓수
				int forsales = input.ticketSale(typeAll); // 우대할인적용

				int age = calc.checkAge(calc.CalAge(residentNum)); // 연령대계산
				int price = calc.checkTicketPrice(typeAll, typeDay, age); // 티켓 정가
				int saleprice = calc.salePriceCal(price, forsales); // 할인가 적용 티켓값
				int sum = calc.ticketSum(price, forsales, count, saleprice); // 티켓값 총합
				position = save.saveOrder(typeAll, typeDay, age, count, saleprice, forsales, position);
				totalSum += sum;
				int check = pui.printReapeat(sum); // 추가발권질문
				if (check == 2) break;
			}
			pui.printTickets(totalSum, position, orderList); // 발권한 티켓 종류 & 수 & 가격등 출력
			save.inputFile(position); // 해당 파일에 입력
			isExit = pui.inputEnd(); // 종료질문
		} while (isExit == 1);
	}
}