package LotteTicketBox;

import java.util.ArrayList;

public class Ticketing { // main for ticketing programm
//	protected static int[][] orderList = new int[100][6];
	protected static ArrayList<OrderData> orderList = new ArrayList<>(); // Ƽ�Ϲ߱ǿ� �迭
	
	public static void main(String[] args) {
		CalTickets calc = new CalTickets();

		int isExit = 0;

		do { // main ����ȭ
			isExit = calc.repeatFunc(); // �ݺ��� while �Լ��и�
		} while (isExit == 1);
	}
}