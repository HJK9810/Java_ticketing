package LotteTicketBox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InputData { // for inputs
	Scanner scanner = new Scanner(System.in); // �ش� Ŭ������ ��� �Լ��� ��������� ���⿡ ����

	protected int checkTwoChoice() { // 2���� �ϳ��� �����ϴ� ���
		int input;
		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
		} while (input != 1 && input != 2);
		return input;
	}

	protected String inputResidentNum() { // �����Է�
		String input;
		System.out.println("  �ֹι�ȣ�� �Է��ϼ���. (6�ڸ�����)");

		while (true) {
			System.out.print("\t\t => ");
			input = scanner.nextLine(); // �⵵ 2�ڸ� + �� 2�ڸ� + ��¥ 2�ڸ�
			try {
				SimpleDateFormat  dateFormat = new  SimpleDateFormat("yyMMdd");
				dateFormat.setLenient(false); // ���� Ȯ�� �����ϰ�
				dateFormat.parse(input);
			} catch (ParseException  e) {
				continue;
			}
			break;
		}
		return input;
	}

	protected int ticketsCount() { // Ƽ�� ����
		int input;
		System.out.println("  ��� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)");

		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
		} while (input > 11 || input < 1); // Ƽ�� �ֹ����ɼ��� �ִ� 10��
		return input;
	}

	protected int ticketSale(int type) { // �����׼��� - ���ϱ��� ������ ���� �����ϱ⿡ �Ķ���� �Է�
		int input;
		System.out.println("  �������� �����ϼ���.");
		System.out.println("\t1. ����(���� ���� �ڵ�ó��)");
		System.out.println("\t2. �����");
		System.out.println("\t3. ����������");
		if (type == 1) { // �ش� �������� ���ϱǿ��� �ش�
			System.out.println("\t4. �ް��庴");
			System.out.println("\t5. �ӻ��");
			System.out.println("\t6. �ٵ����ູī��");
			do {
				System.out.print("\t\t => ");
				input = scanner.nextInt();
			} while (input < 1 || input > 6);
		} else {
			do {
				System.out.print("\t\t => ");
				input = scanner.nextInt();
			} while (input < 1 || input > 3);
		}

		return input;
	}
}