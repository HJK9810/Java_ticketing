package DataAnalysis;

import java.util.ArrayList;

public class CheckTickets {
	protected int[][] CalType() {
		int[][] tickets = new int[4][7]; // ����-1day, ����-after4, ��ũ-1day, ��ũ-after4
		for(int[] items : Analysis.orderList) {
			int idx = -1;
			if (items[1] == 1) idx = items[2] - 1;
			else if (items[1] == 2) idx = items[2] + 1;
			
			tickets[idx][items[3]]++;
			tickets[idx][0]++;
			tickets[idx][6] += items[5];
		}
		return tickets;
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
		perDay.add(day+"-"+sum); // ������ �����Ͱ� ��µ��� �ʱ� ����
		
		return perDay.toArray(new String[perDay.size()]);
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