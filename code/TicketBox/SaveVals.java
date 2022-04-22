package TicketBox;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveVals { // save & make csv files
	FileWriter fw; // 이하 메소드에서 계속 반복되기에 class에서 선언
	protected static ArrayList<OrderData> orderList = new ArrayList<>(); // 티켓발권용 배열
	
	protected void saveOrder(OrderData orderItem) {
		orderList.add(orderItem); // arraylist에 해당 값들 input
	}
	
	protected void InputCSVs() { // 분석 데이터 각 파일에 저장
		SaveVals pf = new SaveVals();
		pf.PerDate(); // 일자별 데이터 파일에 저장
		pf.PerType(); // 권종별 데이터 파일에 저장
		pf.PerAdvate(); // 우대권별 데이터 파일에 저장
	}

	protected void inputFile() { // 파일에 입력한 값들 이어쓰기
		String today = StaticValue.getToday(); // 오늘날짜
		try {
			fw = new FileWriter(StaticValue.PATH + "report.csv", true);
			StringBuilder str = new StringBuilder(); // 용량을 적게 차지하기위한 가변성 string
			for (OrderData item : orderList) { // forEach 사용
				str.append(today + ","); // 오늘날짜 입력
				// 종합 or 파크이용권 - ticketType[] -> 해당 문자열이 담긴 배열, index값 == item.getTicketType()
				str.append(String.format("%-7s,", StaticValue.TICKET_TYPE[item.getTicketType()]));
				// 종일권 or 오후권 - ticketTime[] -> 해당 문자열이 담긴 배열, index값 == item.getTicketDay()
				str.append(String.format("%-6s,", StaticValue.TICKET_TIME[item.getTicketDay()]));
				// 연령
				str.append(String.format("%-6s,", StaticValue.AGE[item.getAge()]));
				// 티켓수, 티켓가격(할인적용)
				str.append(String.format("%d,%d,", item.getOrderCount(), item.getSum()));
				// 우대권 종류
				if (item.getAdventageType() == StaticValue.NONE) str.append("없음\n");
				else { // 출력 : *[우대사항] 우대적용
					str.append(StaticValue.SALE_ADVANTAGE[item.getAdventageType()] + "\n");
				}
				
				fw.write(str.toString()); // 해당 문장 string전환 & 파일 입력
				str.setLength(0); // stringbuilder 초기화
			}

			fw.close(); // 파일닫기
		} catch (IOException e) { // 파일읽고 쓰는동안의 에러체크용
			e.printStackTrace();
		}
	}
	
	protected void PerDate() { // 일자별 매출 분석 파일 출력
		try {
			fw = new FileWriter(StaticValue.PATH + "perDate.csv", false); // 경로지정, 덮어쓰기 허용
			StringBuilder str = new StringBuilder();
			for(String line : CheckTickets.pricePerDate) {
				String[] ary = line.split("-"); // 입력된 구성 : 날짜-총판매액
				// 날짜 분리 : 년도-월-일
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
	
	protected void PerType() { // 권종별 판매 분석 파일출력
		try {
			fw = new FileWriter(StaticValue.PATH + "perType.csv", false);
			StringBuilder str = new StringBuilder();
			int[][] tickets = CheckTickets.ticketType;
			
			fw.write("구분 ,"); // 첫줄 - 카테고리부분 => 종합이용권, 파크이용권 입력부분을 종합1DAY, 파크1DAY로 짧게 붙여쓰기
			for(int idx = 1; idx < StaticValue.TICKET_TYPE.length; idx++) {
				str.append(StaticValue.TICKET_TYPE[idx].substring(0, 2) + StaticValue.TICKET_TIME[1] + " ,");
				str.append(StaticValue.TICKET_TYPE[idx].substring(0, 2) + StaticValue.TICKET_TIME[2]);
				if(idx == 1) str.append(" ,"); // 마지막라인은 줄바꿈이 필요하기에 쉼표구분 제외
				
				fw.write(str.toString());
				str.setLength(0);
			}
			fw.write("\n");
			
			int leng = tickets[0].length - 1;
			for(int idx = 1; idx < leng; idx ++) {
				str.append(StaticValue.AGE[idx] + " ,"); // 연령구별
				str.append(tickets[0][idx] + ","); // 종합-1DAY
				str.append(tickets[1][idx] + ","); // 종합-After4
				str.append(tickets[2][idx] + ","); // 파크-1DAY
				str.append(tickets[3][idx] + "\n"); // 파크-After4
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
	
	protected void PerAdvate() { // 우대권 판매별 분석 파일 출력
		try {
			fw = new FileWriter(StaticValue.PATH + "perAdvant.csv", false);
			StringBuilder str = new StringBuilder();
			for(int idx = 0; idx < CheckTickets.perAdvant.length; idx++) {
				if(idx == 0) str.append("총 판매 티켓수" + ", " + CheckTickets.perAdvant[0]);
				else str.append(StaticValue.SALE_ADVANTAGE[idx] + ", " + CheckTickets.perAdvant[idx]);

				fw.write(str.toString() + "\n"); // 마지막에 줄바꿈 필수
				str.setLength(0);
			}
			fw.close(); // 파일닫기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}