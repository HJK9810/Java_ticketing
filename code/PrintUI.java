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
		StringBuilder str = new StringBuilder(); // �뷮�� ���� �����ϱ����� ������ string
		System.out.println("  Ƽ�� �߱��� �����մϴ�. �����մϴ�.\n");
		System.out.println("===========================�Ե�����===========================");
		for (OrderData item : Ticketing.orderList) {
			// ���� or ��ũ�̿��
			if (item.ticketType == 1) str.append(String.format("%10s", "�����̿��"));
			else if (item.ticketType == 2) str.append(String.format("%10s", "��ũ�̿��"));
			// ���ϱ� or ���ı�
			if (item.ticketDay == 1) str.append(String.format("%6s", "1DAY"));
			else if (item.ticketDay == 2) str.append(String.format("%6s", "After4"));
			// ����
			if (item.age == StaticValue.OLD) {
				str.append(String.format("%6s", "����"));
			} else if (item.age == StaticValue.ADULT) { // �
				str.append(String.format("%6s", "�"));
			} else if (item.age == StaticValue.TEEN) { // û�ҳ�
				str.append(String.format("%6s", "û�ҳ�"));
			} else if (item.age == StaticValue.CHILD) { // ���
				str.append(String.format("%6s", "���"));
			} else
				str.append(String.format("%6s", "���̺�"));
			// Ƽ�ϼ�, Ƽ�ϰ���(��������)
			str.append(String.format("X%-6d %-10d    ", item.orderCount, item.price));
			// ���� ����
			if (item.adventageType == StaticValue.NONE) str.append("*������� ����\n");
			else {
				if (item.adventageType == StaticValue.DISABLE) str.append("*����� ");
				else if (item.adventageType == StaticValue.MERIT) str.append("*���������� ");
				else if (item.adventageType == StaticValue.VACSOLD) str.append("*�ް��庴 ");
				else if (item.adventageType == StaticValue.PREGNANT) str.append("*�ӻ�� ");
				else if (item.adventageType == StaticValue.MULTICHILD) str.append("*�ٵ��� ");

				str.append("�������\n");
			}
			System.out.println(str);
		}

		System.out.println("\t����� �Ѿ��� " + sum + "�� �Դϴ�.");
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