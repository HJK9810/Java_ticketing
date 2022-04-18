package LotteTicketBox;

public class PrintUI { // for print
	// ����, ���, ������, �ް��庴, �ӻ��, �ٵ���
	final int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;

	protected int ticketTypeAll() { // �����̿�� or ��ũ�̿�� ����
		System.out.println("  ������ �����ϼ���.");
		System.out.println("\t1. �����̿��\n\t2. ��ũ�̿��");
		InputData idata = new InputData();
		return idata.checkTwoChoice();
	}

	protected int ticketTypeDay() { // ���ϱ� or ���ı� ����
		System.out.println("  ������ �����ϼ���.");
		System.out.println("\t1. 1DAY\n\t2. After4(���� 4�� ���� ����)");
		InputData idata = new InputData();
		return idata.checkTwoChoice();
	}

	protected void printTickets(int sum, int lastline, int[][] orderList) { // �߱� ������, �߱��� ��� Ƽ�ϵ� ���
		System.out.println("  Ƽ�� �߱��� �����մϴ�. �����մϴ�.\n");
		System.out.println("===========================�Ե�����===========================");

		for (int idx = 0; idx < lastline; idx++) {
			int typeAll = orderList[idx][0];
			int typeDay = orderList[idx][1];
			int age = orderList[idx][2];
			int count = orderList[idx][3];
			int price = orderList[idx][4];
			int sales = orderList[idx][5];
			// ���� or ��ũ�̿��
			if (typeAll == 1) System.out.printf("%10s ", "�����̿��");
			else if (typeAll == 2) System.out.printf("%10s ", "��ũ�̿��");
			// ���ϱ� or ���ı�
			if (typeDay == 1) System.out.printf("%6s ", "1DAY");
			else if (typeDay == 2) System.out.printf("%6s ", "After4");
			// ����
			if (age == OLD) {
				System.out.printf("%6s ", "����");
			} else if (age == ADULT) { // �
				System.out.printf("%6s ", "�");
			} else if (age == TEEN) { // û�ҳ�
				System.out.printf("%6s ", "û�ҳ�");
			} else if (age == CHILD) { // ���
				System.out.printf("%6s ", "���");
			} else
				System.out.printf("%6s ", "���̺�");
			// Ƽ�ϼ�, Ƽ�ϰ���(��������)
			System.out.printf("X%-6d %-10d    ", count, price);
			// ���� ����
			if (sales == NONE) System.out.printf("*������� ����\n");
			else {
				if (sales == DISABLE) System.out.printf("*����� ");
				else if (sales == MERIT) System.out.printf("*���������� ");
				else if (sales == VACSOLD) System.out.printf("*�ް��庴 ");
				else if (sales == PREGNANT) System.out.printf("*�ӻ�� ");
				else if (sales == MULTICHILD) System.out.printf("*�ٵ��� ");

				System.out.printf("�������\n");
			}
		}

		System.out.println("\n\t����� �Ѿ��� " + sum + "�� �Դϴ�.");
		System.out.println(" ** �ӻ�ο� �ٵ����ູī�带 ������ �������� ���� 1�α��� ��밡 ����˴ϴ�.");
		System.out.println("==============================================================\n");
	}

	protected int printReapeat(int sum) { // �߱� ���ӿ���
		System.out.println("  ������ " + sum + " �� �Դϴ�.");
		System.out.println("  �����մϴ�.\n");

		System.out.println("  ��� �߱� �Ͻðڽ��ϱ�?");
		System.out.println("\t1. Ƽ�Ϲ߱�\n\t2. ����");

		InputData idata = new InputData();
		return idata.checkTwoChoice();
	}

	protected int inputEnd() { // ���α׷� ���� or �� �ֹ�
		System.out.println("  ��� ����(1: ���ο� �ֹ�, 2: ���α׷� ����) : ");
		InputData idata = new InputData();
		return idata.checkTwoChoice();
	}
}