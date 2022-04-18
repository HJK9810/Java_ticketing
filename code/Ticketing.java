package LotteTicketBox;

public class Ticketing { // main for ticketing programm
	// 없음, 장애, 유공자, 휴가장병, 임산부, 다둥이
	final int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;
	protected static int[][] orderList = new int[100][6];

	public static void main(String[] args) {
		InputData input = new InputData();
		PrintUI pui = new PrintUI();
		CalTickets calc = new CalTickets();
		SaveVals save = new SaveVals();

		int isExit = 0;

		do {
			int totalSum = 0;
			int position = 0;
			while (true) {
				int typeAll = pui.ticketTypeAll(); // 종합 or 파크
				int typeDay = pui.ticketTypeDay(); // 종일 or 오후
				int residentNum = input.inputResidentNum(); // 주민번호 앞자리
				int count = input.ticketsCount(); // 티켓수
				int forsales = input.ticketSale(typeAll); // 우대할인적용

				int age = calc.checkAge(calc.CalAge(residentNum));
				int price = calc.checkTicketPrice(typeAll, typeDay, age);
				int saleprice = calc.salePriceCal(price, forsales); // 할인가 적용 티켓값
				int sum = calc.ticketSum(price, forsales, count, saleprice);
				position = save.saveOrder(typeAll, typeDay, age, count, saleprice, forsales, position);
				totalSum += sum;
				int check = pui.printReapeat(sum);
				if (check == 2) break;
			}
			pui.printTickets(totalSum, position, orderList);
			save.inputFile(position);
			isExit = pui.inputEnd();
		} while (isExit == 1);
	}
}