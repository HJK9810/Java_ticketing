package LotteTicketBox;

public class Ticketing { // main for ticketing programm
	// 없음, 장애, 유공자, 휴가장병, 임산부, 다둥이
	final static int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	final static int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;
	protected static int[][] orderList = new int[100][6]; // 티켓발권용 배열

	public static void main(String[] args) {
		CalTickets calc = new CalTickets();

		int isExit = 0;

		do { // main 간략화
			isExit = calc.repeatFunc(); // 반복용 while 함수분리
		} while (isExit == 1);
	}
}