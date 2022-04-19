package LotteTicketBox;

public class PrintUI { // for print

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

	protected void printTickets(int sum) { // �߱� ������, �߱��� ��� Ƽ�ϵ� ���
		System.out.println("  Ƽ�� �߱��� �����մϴ�. �����մϴ�.\n");
		System.out.println("===========================�Ե�����===========================");
		for (OrderData item : Ticketing.orderList) {
			// ���� or ��ũ�̿��
			if (item.ticketType == 1) System.out.printf("%10s ", "�����̿��");
			else if (item.ticketType == 2) System.out.printf("%10s ", "��ũ�̿��");
			// ���ϱ� or ���ı�
			if (item.ticketDay == 1) System.out.printf("%6s ", "1DAY");
			else if (item.ticketDay == 2) System.out.printf("%6s ", "After4");
			// ����
			if (item.age == StaticValue.OLD) {
				System.out.printf("%6s ", "����");
			} else if (item.age == StaticValue.ADULT) { // �
				System.out.printf("%6s ", "�");
			} else if (item.age == StaticValue.TEEN) { // û�ҳ�
				System.out.printf("%6s ", "û�ҳ�");
			} else if (item.age == StaticValue.CHILD) { // ���
				System.out.printf("%6s ", "���");
			} else
				System.out.printf("%6s ", "���̺�");
			// Ƽ�ϼ�, Ƽ�ϰ���(��������)
			System.out.printf("X%-6d %-10d    ", item.orderCount, item.price);
			// ���� ����
			if (item.adventageType == StaticValue.NONE) System.out.printf("*������� ����\n");
			else {
				if (item.adventageType == StaticValue.DISABLE) System.out.printf("*����� ");
				else if (item.adventageType == StaticValue.MERIT) System.out.printf("*���������� ");
				else if (item.adventageType == StaticValue.VACSOLD) System.out.printf("*�ް��庴 ");
				else if (item.adventageType == StaticValue.PREGNANT) System.out.printf("*�ӻ�� ");
				else if (item.adventageType == StaticValue.MULTICHILD) System.out.printf("*�ٵ��� ");

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