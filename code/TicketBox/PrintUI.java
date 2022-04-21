package TicketBox;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PrintUI { // for print
	InputData idata = new InputData();
	DecimalFormat df = new DecimalFormat("###,###,###"); // ���ݿ� , ����
	
	protected void PrintAnalysisAll() { // �м� UI ��� ���
		CheckTickets check = new CheckTickets();
		PrintUI pui = new PrintUI();
		SaveVals save = new SaveVals(); // ������ ���� & ���� �����
		
		check.TicketsAnalysis(); // ������ �з� & �м�
		pui.PrintCSV(); // csv ���� ��ü ���
		pui.PrintTicketType(); // ������ �Ǹ���Ȳ ���
		pui.PrintDaysSum(); // ���ں� ���� ��Ȳ ���
		pui.PrintSaleType(); // ���� �Ǹ���Ȳ ���
		
		save.InputCSVs(); // ��� ������ ���� ���Ͽ� ����
	}

	protected int ticketTypeAll() { // �����̿�� or ��ũ�̿�� ����
		System.out.println("  ������ �����ϼ���.");
		System.out.println("\t1. �����̿��\n\t2. ��ũ�̿��"); 
		return idata.checkTwoChoice(); // ���� �Է¹ް� ��ȿ Ȯ��
	}

	protected int ticketTypeDay() { // ���ϱ� or ���ı� ����
		System.out.println("  ������ �����ϼ���.");
		System.out.println("\t1. 1DAY\n\t2. After4(���� 4�� ���� ����)");
		return idata.checkTwoChoice();
	}

	protected void printTickets(int sum) { // �߱� ������, �߱��� ��� Ƽ�ϵ� ���
		StringBuilder str = new StringBuilder(); // �뷮�� ���� �����ϱ����� ������ string
		System.out.println("  Ƽ�� �߱��� �����մϴ�. �����մϴ�.\n");
		System.out.println("===========================�Ե�����===========================");
		for (OrderData item : SaveVals.orderList) { // forEach���� ���
			// ���� or ��ũ�̿��
			if (item.getTicketType() == StaticValue.ALL_TICKET) str.append(String.format("%10s", "�����̿��"));
			else if (item.getTicketType() == StaticValue.PARK_TICKET) str.append(String.format("%10s", "��ũ�̿��"));
			// ���ϱ� or ���ı�
			if (item.getTicketDay() == StaticValue.ALL_DAY) str.append(String.format("%8s", "1DAY"));
			else if (item.getTicketDay() == StaticValue.AFTER4) str.append(String.format("%8s", "After4"));
			// ����
			if (item.getAge() == StaticValue.OLD) { // ����
				str.append(String.format("%6s", "����"));
			} else if (item.getAge() == StaticValue.ADULT) { // �
				str.append(String.format("%6s", "�"));
			} else if (item.getAge() == StaticValue.TEEN) { // û�ҳ�
				str.append(String.format("%6s", "û�ҳ�"));
			} else if (item.getAge() == StaticValue.CHILD) { // ���
				str.append(String.format("%6s", "���"));
			} else // ���� - ���̺�
				str.append(String.format("%6s", "���̺�"));
			// Ƽ�ϼ�, Ƽ�ϰ���(��������)
			str.append(String.format("X%-6d %-10d    ", item.getOrderCount(), item.getPrice()));
			// ���� ����
			if (item.getAdventageType() == StaticValue.NONE) str.append("*������� ����");
			else {
				if (item.getAdventageType() == StaticValue.DISABLE) str.append("*����� ");
				else if (item.getAdventageType() == StaticValue.MERIT) str.append("*���������� ");
				else if (item.getAdventageType() == StaticValue.VACSOLD) str.append("*�ް��庴 ");
				else if (item.getAdventageType() == StaticValue.PREGNANT) str.append("*�ӻ�� ");
				else if (item.getAdventageType() == StaticValue.MULTICHILD) str.append("*�ٵ��� ");

				str.append("�������");
			}
			System.out.println(str); // console�� ���
			str.setLength(0); // stringbuilder �ʱ�ȭ
		}

		System.out.println("\n\t����� �Ѿ��� " + sum + "�� �Դϴ�."); // sum = totalSum
		System.out.println(" ** �ӻ�ο� �ٵ����ູī�带 ������ �������� ���� 1�α��� ��밡 ����˴ϴ�.");
		System.out.println("==============================================================\n");
	}

	protected int printReapeat(int sum) { // �߱� ���ӿ���
		System.out.println("  ������ " + sum + " �� �Դϴ�."); // �ش� Ƽ�� �� �� = Ƽ�Ϲ߱Ǽ� * ����
		System.out.println("  �����մϴ�.\n");

		System.out.println("  ��� �߱� �Ͻðڽ��ϱ�?"); // �߰� �߱ǿ��� ����
		System.out.println("\t1. Ƽ�Ϲ߱�\n\t2. ����");

		return idata.checkTwoChoice();
	}

	protected int inputEnd() { // ���α׷� ���� or �� �ֹ�
		System.out.println("  ��� ����(1: ���ο� �ֹ�, 2: ���α׷� ����) : "); // �ش� ���α׷� ���Ῡ��
		return idata.checkTwoChoice();
	}
	
	protected void PrintCSV() {
		String[] ary = SystemFunc.category;
		
		System.out.println("================= report.csv =================");
		System.out.printf("%7s%5s%4s%5s%4s%8s%4s\n", ary[0], ary[1], ary[2], ary[3], ary[4], ary[5], ary[6]);
		
		StringBuilder str = new StringBuilder();
		for(int[] line : SystemFunc.orderList) {
			str.append(String.format("%8d", line[0]));
			str.append(String.format("%6d", line[1]));
			str.append(String.format("%4d", line[2]));
			str.append(String.format("%6d", line[3]));
			str.append(String.format("%6d", line[4]));
			str.append(String.format("%9s", df.format(line[5])));
			str.append(String.format("%6d", line[6]));
			System.out.println(str);
			
			str.setLength(0);
		}
		System.out.println("----------------------------------------------\n");
	}
	
	protected void PrintTicketType() {
		int[][] tickets = CheckTickets.ticketType;
		System.out.println("======================= ���� �� �Ǹ���Ȳ =======================");
		for(int idx = 0; idx < tickets.length; idx++) {
			int checkType = idx % 2 + 1;
			int lastIdx = tickets[idx].length - 1;
			if(checkType == 1) System.out.printf("%s �� %d��\n", StaticValue.TICKET_TYPE[idx / 2 + 1], tickets[idx][0] + tickets[idx + 1][0]);
			
			for(int jdx = 0; jdx < lastIdx; jdx++) {
				if(jdx == 0) {
					System.out.printf("\t%s �� %d��\n", StaticValue.TICKET_TIME[checkType], tickets[idx][0]);
					continue;
				} else if(jdx == 1) System.out.print("\t\t");
				
				System.out.printf("%s %d��", StaticValue.AGE[jdx], tickets[idx][jdx]);
				if(jdx == lastIdx - 1) System.out.println();
				else System.out.print(", ");
			}
			System.out.printf(" => %s �Ѹ��� %s��\n\n", StaticValue.TICKET_TIME[checkType], df.format(tickets[idx][lastIdx]));
			
			if(checkType == 2) System.out.printf(" ==>> %s �� ���� %s��\n\n", StaticValue.TICKET_TYPE[idx / 2 + 1], df.format(tickets[idx - 1][lastIdx] + tickets[idx][lastIdx]));
		}
		System.out.println("------------------------------------------------------------\n");
	}
	
	protected void PrintDaysSum() {
		ArrayList<String> perDates = CheckTickets.pricePerDate;
		System.out.println("============= ���ں� ���� ��Ȳ =============");
		for(String line : perDates) {
			String[] ary = line.split("-");
			System.out.printf("%s�� %s�� %s�� : ", ary[0].substring(0, 4), ary[0].substring(4, 6), ary[0].substring(6));
			System.out.printf("�� ���� %14s��\n", df.format(Integer.parseInt(ary[1])));
		}
		
		System.out.println("----------------------------------------\n");
	}
	
	protected void PrintSaleType() {
		int[] tickets = CheckTickets.perAdvant;
		System.out.println("====== ���� �Ǹ� ��Ȳ ======");
		for(int idx = 0; idx < tickets.length; idx++) {
			if(idx == 0) System.out.printf("%s\t:%6d��\n", "�� �Ǹ� Ƽ�ϼ�", tickets[0]);
			else System.out.printf("%s\t\t:%6d��\n", StaticValue.SALE_ADVANTAGE[idx], tickets[idx]);
		}
		System.out.println("--------------------------\n");
	}
}