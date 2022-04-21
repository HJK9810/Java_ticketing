package DataAnalysis;

import java.io.FileWriter;
import java.io.IOException;

public class PrintFile {
	protected void PrintCSV() {
		PrintFile pf = new PrintFile();
		pf.PerDate();
		pf.PerType();
		pf.PerAdvate();
	}
	
	protected void PerDate() {
		try {
			FileWriter fw = new FileWriter(StaticValue.PATH + "perDate.csv", false);
			StringBuilder str = new StringBuilder();
			for(String line : CheckTickets.pricePerDate) {
				String[] ary = line.split("-");
				
				str.append(ary[0].substring(0, 4) + "-" + ary[0].substring(4, 6) + "-" + ary[0].substring(6) + " ,");
				str.append(ary[1] + "\n");

				fw.write(str.toString());
				str.setLength(0);
			}
			fw.close(); // 파일닫기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void PerType() {
		try {
			FileWriter fw = new FileWriter(StaticValue.PATH + "perType.csv", false);
			StringBuilder str = new StringBuilder();
			int[][] tickets = CheckTickets.ticketType;
			
			fw.write("구분 ,");
			for(int idx = 1; idx < StaticValue.TICKET_TYPE.length; idx++) {
				str.append(StaticValue.TICKET_TYPE[idx].substring(0, 2) + StaticValue.TICKET_TIME[1] + " ,");
				str.append(StaticValue.TICKET_TYPE[idx].substring(0, 2) + StaticValue.TICKET_TIME[2]);
				if(idx == 1) str.append(" ,");
				
				fw.write(str.toString());
				str.setLength(0);
			}
			fw.write("\n");
			
			int leng = tickets[0].length - 1;
			for(int idx = 1; idx < leng; idx ++) {
				str.append(StaticValue.AGE[idx] + " ,");
				str.append(tickets[0][idx] + ",");
				str.append(tickets[1][idx] + ",");
				str.append(tickets[2][idx] + ",");
				str.append(tickets[3][idx] + "\n");
				fw.write(str.toString());
				str.setLength(0);
			}
			fw.write("합계 ," + tickets[0][0] + "," + tickets[1][0] + "," + tickets[2][0] + "," + tickets[3][0] + "\n");
			fw.write("매출 ," + tickets[0][leng] + "," + tickets[1][leng] + "," + tickets[2][leng] + "," + tickets[3][leng] + "\n");
			
			fw.close(); // 파일닫기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void PerAdvate() {
		try {
			FileWriter fw = new FileWriter(StaticValue.PATH + "perAdvant.csv", false);
			StringBuilder str = new StringBuilder();
			for(int idx = 0; idx < CheckTickets.perAdvant.length; idx++) {
				if(idx == 0) str.append("총 판매 티켓수" + ", " + CheckTickets.perAdvant[0]);
				else str.append(StaticValue.SALE_ADVANTAGE[idx] + ", " + CheckTickets.perAdvant[idx]);

				fw.write(str.toString() + "\n");
				str.setLength(0);
			}
			fw.close(); // 파일닫기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}