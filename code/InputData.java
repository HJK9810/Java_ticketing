package LotteTicketBox;

import java.util.Scanner;

public class InputData { // for inputs
	Scanner scanner = new Scanner(System.in);

	protected int checkTwoChoice() {
		int input;
		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
		} while (input != 1 && input != 2);
		return input;
	}

	protected int inputResidentNum() { // �����Է�
		int input;
		System.out.println("  �ֹι�ȣ�� �Է��ϼ���. (6�ڸ�����)");

		while (true) {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
			int year = input / 10000;
			int month = input % 10000 / 100;
			int day = input % 100;

			if (year < 100 && (month < 13 && month > 0) && (day < 32 && day > 0)) break;
		}
		return input;
	}

	protected int ticketsCount() { // Ƽ�� ����
		int input;
		System.out.println("  ��� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)");

		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
		} while (input > 11 || input < 1);
		return input;
	}

	protected int ticketSale(int type) { // �����׼���
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