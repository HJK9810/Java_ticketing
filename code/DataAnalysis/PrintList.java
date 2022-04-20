package DataAnalysis;

public class PrintList {
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
			str.append(String.format("%9d", line[5]));
			str.append(String.format("%6d", line[6]));
			System.out.println(str);
			
			str.setLength(0);
		}
		System.out.println("----------------------------------------------\n");
	}
	
	protected void PrintTicketType() {
		System.out.println("================= ���� �� �Ǹ���Ȳ =================");
		System.out.println("------------------------------------------------\n");
	}
	
	protected void PrintDayssum() {
		System.out.println("================= ���ں� ���� ��Ȳ =================");
		System.out.println("------------------------------------------------\n");
	}
	
	protected void PrintSaleType() {
		CheckTickets check = new CheckTickets();
		int[] tickets = check.CheckAdvantType();
		System.out.println("====== ���� �Ǹ� ��Ȳ ======");
		for(int idx = 0; idx < tickets.length; idx++) {
			if(idx == 0) System.out.printf("%s\t:%6d��\n", "�� �Ǹ� Ƽ�ϼ�", tickets[0]);
			else System.out.printf("%s\t\t:%6d��\n", StaticValue.SALE_ADVANTAGE[idx], tickets[idx]);
		}
		System.out.println("--------------------------\n");
	}
}