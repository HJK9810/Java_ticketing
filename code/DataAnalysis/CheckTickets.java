package DataAnalysis;

public class CheckTickets {
	protected void CalType() {
		
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