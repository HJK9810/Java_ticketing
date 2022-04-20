package DataAnalysis;

import java.util.ArrayList;

public class CheckTickets {
	// 종합-1day, 종합-after4, 파크-1day, 파크-after4
	protected static int[][] ticketType = new int[4][7]; // 0 = 총 매수, 1~6 = 해당 인덱스 번호와 일치하는 연령대, 7 = 총금액
	protected static ArrayList<String> pricePerDate = new ArrayList<>();
	protected static int[] perAdvant = new int[7];
	
	protected void TicketsAnalysis() {
		int day = Analysis.orderList.get(0)[0]; // 입력된 첫날
		int sum = 0;
		
		for(int[] items : Analysis.orderList) {
			if(day != items[0]) { // 날짜별 총 매출액
				pricePerDate.add(day+"-"+sum);
				
				day = items[0]; // 날짜
				sum = items[5]; // 가격
			} else sum += items[5];
			// 이용권 & 연령대별 티켓수, 이용권별 총 매출수
			int idx = -1;
			if (items[1] == 1) idx = items[2] - 1;
			else if (items[1] == 2) idx = items[2] + 1;
			
			ticketType[idx][items[3]]++;
			ticketType[idx][0]++;
			ticketType[idx][6] += items[5];
			// 우대사항 별 티켓수
			perAdvant[items[6]] = items[4]; // items[4] : 티켓수량, items[6] : 우대사항
			perAdvant[0]++; // countSum[0] : 총 매수
		}
		pricePerDate.add(day+"-"+sum); // 마지막 데이터가 출력되지 않기 때문
	}
}