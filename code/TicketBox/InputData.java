package TicketBox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InputData { // for inputs
	Scanner scanner = new Scanner(System.in); // �ش� Ŭ������ ��� �Լ��� ��������� ���⿡ ����
	
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
		int input;
		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
		} while (input != 1 && input != 2); // 1�̳� 2�� �ƴҰ�� �ݺ�
		return input;
	}
	
	protected int checkEnd() {
		SystemFunc sys = new SystemFunc();
		int input;
		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
			if(input == 0) { // �м����α׷����� �Ѿ�� ��ȣ 0
				sys.AnalySys(); // �м����α׷� open
				break; // ��ݺ� ����
			}
		} while (input != 1 && input != 2); // 1�̳� 2�� �ƴҰ�� �ݺ�
		return input;
	}

	protected String inputResidentNum() { // �����Է�
		String input;
		System.out.println("  �ֹι�ȣ�� �Է��ϼ���. (6�ڸ�����)");

		while (true) {
			System.out.print("\t\t => ");
			input = scanner.next(); // �⵵ 2�ڸ� + �� 2�ڸ� + ��¥ 2�ڸ�
			try {
				SimpleDateFormat  dateFormat = new  SimpleDateFormat("yyMMdd");
				dateFormat.setLenient(false); // ���� Ȯ�� �����ϰ�
				dateFormat.parse(input); // �Է��� ��¥, ���信 �´��� Ȯ��
			} catch (ParseException  e) { // => �Է��� ��¥�� ��ȿ���� ���� ���
				continue;
			}
			break; // �Է��Ѱ��� ��ȿ�� try-catch �������°�� -> while stop
		}
		return input;
	}

	protected int ticketsCount() { // Ƽ�� ����
		int input;
		System.out.println("  ��� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)");

		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
		} while (input > StaticValue.MAX_COUNT || input < StaticValue.MIN_COUNT); // Ƽ�� �ֹ����ɼ��� �ִ� 10��
		return input;
	}

	protected int ticketSale(int type) { // �����׼��� - �����̿���� ������ ���� �����ϱ⿡ �Ķ���� �Է�
		int input;
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
			} while (input < StaticValue.NONE || input > StaticValue.MULTICHILD); // �����̿���ϰ��, �������� 6������ ����
		} else {
			do {
				System.out.print("\t\t => ");
				input = scanner.nextInt();
			} while (input < StaticValue.NONE || input > StaticValue.MERIT); // ��ũ�̿���ϰ��, �������� 3������ ����
		}

		return input;
	}
}