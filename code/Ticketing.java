package LotteTicketBox;

import java.util.ArrayList;

public class Ticketing { // main for ticketing programm
	protected static ArrayList<OrderData> orderList = new ArrayList<>(); // Ƽ�Ϲ߱ǿ� �迭
	
	public static void main(String[] args) {
		CalTickets calc = new CalTickets();

		int isExit = 0;

		do { // main ����ȭ
			isExit = calc.repeatFunc(); // �ݺ��� while �Լ��и�
			orderList = new ArrayList<>(); // �ش� �迭 �ʱ�ȭ
		} while (isExit == 1); // if isExit == 2 => program end
	}
}