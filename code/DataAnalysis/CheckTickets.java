package DataAnalysis;

public class CheckTickets {
	protected void CalType() {
		
	}
	
	protected int[] CheckAdvantType() {
		int[] countSum = new int[7];
		for(int[] items : Analysis.orderList) {
			countSum[items[6]] = items[4]; // items[4] : Ƽ�ϼ���, items[6] : ������
			countSum[0]++; // countSum[0] : �� �ż�
		}
		
		return countSum;
	}
}