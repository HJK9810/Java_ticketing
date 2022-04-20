package LotteTicketBox;

import java.util.ArrayList;

public class TicketSys {
	protected void ticketingSystem() { // main ���� ���ư� ���� �ý��� �Լ�
		// �� class ���� => static�� �ƴϱ⿡ ���� �ʼ�
		InputData input = new InputData(); // �Է¿�
		PrintUI pui = new PrintUI(); // ui ��¿�
		CalTickets calc = new CalTickets(); // ����
		SaveVals save = new SaveVals(); // ������ ���� & ���� �����
		
		OrderData orderitem = new OrderData(); // ����
		int isExit = 0; // ���α׷� ���Ḧ ���� Ȯ�κ���
		
		do { // main ����ȭ
			int totalSum = 0; // '�ѹ���' �߱��� ��ü Ƽ�ϰ� ����
			while (true) {
				orderitem.setTicketType(pui.ticketTypeAll()); // ���� or ��ũ
				orderitem.setTicketDay(pui.ticketTypeDay()); // ���� or ����
				orderitem.setIDNumber(input.inputResidentNum()); // �ֹι�ȣ ���ڸ�
				orderitem.setOrderCount(input.ticketsCount()); // Ƽ�ϼ�
				orderitem.setAdventageType(input.ticketSale(orderitem.getTicketType())); // �����������

				orderitem.setAge(calc.CalAge(orderitem.getIDNumber())); // ���ɴ���
				int price = calc.checkTicketPrice(orderitem); // Ƽ�� ����
				orderitem.setPrice(calc.salePriceCal(price, orderitem.getAdventageType())); // ���ΰ� ���� Ƽ�ϰ�
				orderitem.setSum(calc.ticketSum(price, orderitem.getAdventageType(), orderitem.getOrderCount(), orderitem.getPrice())); // Ƽ�ϰ� ����
				save.saveOrder(orderitem); // �ش� ������, arraylist�� ����
				totalSum += orderitem.getSum(); // ��������
				int check = pui.printReapeat(orderitem.getSum()); // �߰��߱�����
				if (check == StaticValue.END) break; // �ݺ��� out
				orderitem = new OrderData(); // �ʱ�ȭ
			}
			pui.printTickets(totalSum); // �߱��� Ƽ�� ���� & �� & ���ݵ� ���
			save.inputFile(); // �ش� ���Ͽ� �Է�
			isExit = pui.inputEnd(); // ��������
			SaveVals.orderList = new ArrayList<>(); // �ش� �迭 �ʱ�ȭ
		} while (isExit == 1); // if isExit == 2 => program end
	}
}