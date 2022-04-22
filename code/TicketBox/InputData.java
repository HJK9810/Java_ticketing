package TicketBox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InputData { // for inputs
	Scanner scanner = new Scanner(System.in); // �ش� Ŭ������ ��� �Լ��� ��������� ���⿡ ����
	int input = 0; // int�� �Է¹�����
	String line = ""; // String���� �Է¹�����
	
	protected void startinput(OrderData orderitem) {
		PrintUI pui = new PrintUI();
		InputData input = new InputData();
		
		orderitem.setTicketType(pui.ticketTypeAll()); // ���� or ��ũ
		orderitem.setTicketDay(pui.ticketTypeDay()); // ���� or ����
		orderitem.setIDNumber(input.inputResidentNum()); // �ֹι�ȣ ���ڸ�
		orderitem.setOrderCount(input.ticketsCount()); // Ƽ�ϼ�
		orderitem.setAdventageType(input.ticketSale(orderitem.getTicketType())); // �����������
	}

	protected int checkTwoChoice() { // 2���� �ϳ��� �����ϴ� ���
		SystemFunc sys = new SystemFunc();
		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
			if(input == 33) break;
		} while (input != 1 && input != 2); // 1�̳� 2�� �ƴҰ�� �ݺ�
		if(input == 33) sys.sysEnd();
		return input;
	}
	
	protected int checkEnd() {
		SystemFunc sys = new SystemFunc();
		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt(); // 1�̳� 2�� �ƴҰ�� �ݺ�
			if(input == 33) break;
		} while (input != StaticValue.CONTINUE && input != StaticValue.END && input != StaticValue.ANALYSIS); 
		if(input == 33) sys.sysEnd();
		if(input == StaticValue.ANALYSIS) sys.AnalySys(); // StaticValue.ANALYSIS = 0 �� ��� �м����α׷� ��ȯ
		return input;
	}

	protected String inputResidentNum() { // �����Է�
		SystemFunc sys = new SystemFunc();
		System.out.println("  �ֹι�ȣ�� �Է��ϼ���. (6�ڸ�����)");

		while (true) {
			System.out.print("\t\t => ");
			line = scanner.next(); // �⵵ 2�ڸ� + �� 2�ڸ� + ��¥ 2�ڸ�
			if(line.equals("33")) break;
			try {
				SimpleDateFormat  dateFormat = new  SimpleDateFormat("yyMMdd");
				dateFormat.setLenient(false); // ���� Ȯ�� �����ϰ�
				dateFormat.parse(line); // �Է��� ��¥, ���信 �´��� Ȯ��
			} catch (ParseException  e) { // => �Է��� ��¥�� ��ȿ���� ���� ���
				continue;
			}
			break; // �Է��Ѱ��� ��ȿ�� try-catch �������°�� -> while stop
		}
		if(line.equals("33")) sys.sysEnd();
		return line;
	}

	protected int ticketsCount() { // Ƽ�� ����
		SystemFunc sys = new SystemFunc();
		System.out.println("  ��� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)");

		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
			if(input == 33) break;
		} while (input > StaticValue.MAX_COUNT || input < StaticValue.MIN_COUNT); // Ƽ�� �ֹ����ɼ��� �ִ� 10��
		if(input == 33) sys.sysEnd();
		return input;
	}

	protected int ticketSale(int type) { // �����׼��� - �����̿���� ������ ���� �����ϱ⿡ �Ķ���� �Է�
		SystemFunc sys = new SystemFunc();
		System.out.println("  �������� �����ϼ���.");
		System.out.println("\t1. ����(���� ���� �ڵ�ó��)");
		System.out.println("\t2. �����");
		System.out.println("\t3. ����������");
		if (type == 1) { // �ش� �������� �����̿�ǿ��� �ش�
			System.out.println("\t4. �ް��庴");
			System.out.println("\t5. �ӻ��");
			System.out.println("\t6. �ٵ����ູī��");
			do {
				System.out.print("\t\t => ");
				input = scanner.nextInt();
				if(input == 33) break;
			} while (input < StaticValue.NONE || input > StaticValue.MULTICHILD); // �����̿���ϰ��, �������� 6������ ����
		} else {
			do {
				System.out.print("\t\t => ");
				input = scanner.nextInt();
				if(input == 33) break;
			} while (input < StaticValue.NONE || input > StaticValue.MERIT); // ��ũ�̿���ϰ��, �������� 3������ ����
		}
		if(input == 33) sys.sysEnd();
		return input;
	}
}