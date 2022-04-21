package DataAnalysis;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PrintList {
	DecimalFormat df = new DecimalFormat("###,###,###"); // ���ݿ� , ����
	protected void PrintAll() {
		CheckTickets check = new CheckTickets();
		PrintList print = new PrintList();
		PrintFile pf = new PrintFile();
		
		check.TicketsAnalysis(); // ������ �з� & �м�
		print.PrintCSV(); // csv ���� ��ü ���
		print.PrintTicketType(); // ������ �Ǹ���Ȳ ���
		print.PrintDaysSum(); // ���ں� ���� ��Ȳ ���
		print.PrintSaleType(); // ���� �Ǹ���Ȳ ���
		
		pf.PrintCSV(); // ��� ������ ���� ���Ͽ� ����
	}
	
	protected void PrintCSV() {
		String[] ary = Analysis.category;
		
		System.out.println("================= report.csv =================");
		System.out.printf("%7s%5s%4s%5s%4s%8s%4s\n", ary[0], ary[1], ary[2], ary[3], ary[4], ary[5], ary[6]);
		
		StringBuilder str = new StringBuilder();
		for(int[] line : Analysis.orderList) {
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