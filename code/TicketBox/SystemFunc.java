package TicketBox;

import java.util.ArrayList;

public class SystemFunc {
	protected static String[] category; 
	protected static ArrayList<int[]> orderList = new ArrayList<>(); // Ƽ�Ϲ߱ǿ� �迭
	
	protected void ticketingSystem() { // main ���� ���ư� ���� �ý��� �Լ�
		// �� class ���� => static�� �ƴϱ⿡ ���� �ʼ�
		InputData input = new InputData(); // �Է¿�
		PrintUI pui = new PrintUI(); // ui ��¿�
		CalTickets calc = new CalTickets(); // ����
		SaveVals save = new SaveVals(); // ������ ���� & ���� �����
		
		OrderData orderitem = new OrderData(); // ����
		
		do { // main ����ȭ
			int totalSum = 0; // '�ѹ���' �߱��� ��ü Ƽ�ϰ� ����
			while (true) {
				input.startinput(orderitem); // �ý��� �� input�κ�
				calc.sysCal(orderitem); // �ý��� �� ���κ�

				save.saveOrder(orderitem); // �ش� ������, arraylist�� ����
 				totalSum += orderitem.getSum(); // ��������
				if (pui.printReapeat(orderitem.getSum()) == StaticValue.END) break; // �߰��߱����� => �ݺ��� out
				orderitem = new OrderData(); // �ʱ�ȭ
			}
			pui.printTickets(totalSum); // �߱��� Ƽ�� ���� & �� & ���ݵ� ���
			save.inputFile(); // �ش� ���Ͽ� �Է�
			SaveVals.orderList = new ArrayList<>(); // �ش� �迭 �ʱ�ȭ
		} while (pui.inputEnd() == StaticValue.CONTINUE); // if isExit == 2 => program end
	}
	
	protected void AnalySys() { // �м��� �����Լ�
		ReadFile rf = new ReadFile();
		PrintUI pui = new PrintUI();
		
		rf.ReadCSV(); // ���� �б�
		pui.PrintAnalysisAll(); // �ֿܼ� ���
	}
}