package LotteTicketBox;

public class Ticketing { // main for ticketing programm
	// ����, ���, ������, �ް��庴, �ӻ��, �ٵ���
	final static int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	final static int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;
	protected static int[][] orderList = new int[100][6]; // Ƽ�Ϲ߱ǿ� �迭

	public static void main(String[] args) {
		CalTickets calc = new CalTickets();

		int isExit = 0;

		do { // main ����ȭ
			isExit = calc.repeatFunc(); // �ݺ��� while �Լ��и�
		} while (isExit == 1);
	}
}