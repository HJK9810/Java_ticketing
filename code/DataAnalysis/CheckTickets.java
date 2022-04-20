package DataAnalysis;

import java.util.ArrayList;

public class CheckTickets {
	protected void CalType() {
		
	}
	
	protected String[] CalPerDay() {
		ArrayList<String> perDay = new ArrayList<>();
		int day = Analysis.orderList.get(0)[0];
		int sum = 0;
		
		for(int[] items:Analysis.orderList) {
			if(day != items[0]) {
				perDay.add(day+"-"+sum);
				
				day = items[0];
				sum = items[5];
			} else sum += items[5];
		}
		
		return perDay.toArray(new String[perDay.size()]);
	}
	
	protected int[] CheckAdvantType() {
		int[] countSum = new int[7];
		for(int[] items : Analysis.orderList) {
			countSum[items[6]] = items[4]; // items[4] : 티켓수량, items[6] : 우대사항
			countSum[0]++; // countSum[0] : 총 매수
		}
		
		return countSum;
	}
}