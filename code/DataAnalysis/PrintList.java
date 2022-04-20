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
		System.out.println("================= 권종 별 판매현황 =================");
		System.out.println("------------------------------------------------\n");
	}
	
	protected void PrintDaysSum() {
		CheckTickets check = new CheckTickets();
		String[] perDates = check.CalPerDay();
		System.out.println("============= 일자별 매출 현황 =============");
		for(String line : perDates) {
			String[] ary = line.split("-");
			System.out.printf("%s년 %s월 %s일 : ", ary[0].substring(0, 4), ary[0].substring(4, 6), ary[0].substring(6));
			System.out.printf("총 매출 %14s원\n", ary[1]);
		}
		
		System.out.println("----------------------------------------\n");
	}
	
	protected void PrintSaleType() {
		CheckTickets check = new CheckTickets();
		int[] tickets = check.CheckAdvantType();
		System.out.println("====== 우대권 판매 현황 ======");
		for(int idx = 0; idx < tickets.length; idx++) {
			if(idx == 0) System.out.printf("%s\t:%6d매\n", "총 판매 티켓수", tickets[0]);
			else System.out.printf("%s\t\t:%6d매\n", StaticValue.SALE_ADVANTAGE[idx], tickets[idx]);
		}
		System.out.println("--------------------------\n");
	}
}