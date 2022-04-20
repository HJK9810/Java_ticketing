package DataAnalysis;

import java.util.ArrayList;

public class CheckTickets {
	// ����-1day, ����-after4, ��ũ-1day, ��ũ-after4
	protected static int[][] ticketType = new int[4][7]; // 0 = �� �ż�, 1~6 = �ش� �ε��� ��ȣ�� ��ġ�ϴ� ���ɴ�, 7 = �ѱݾ�
	protected static ArrayList<String> pricePerDate = new ArrayList<>();
	protected static int[] perAdvant = new int[7];
	
	protected void TicketsAnalysis() {
		int day = Analysis.orderList.get(0)[0]; // �Էµ� ù��
		int sum = 0;
		
		for(int[] items : Analysis.orderList) {
			if(day != items[0]) { // ��¥�� �� �����
				pricePerDate.add(day+"-"+sum);
				
				day = items[0]; // ��¥
				sum = items[5]; // ����
			} else sum += items[5];
			// �̿�� & ���ɴ뺰 Ƽ�ϼ�, �̿�Ǻ� �� �����
			int idx = -1;
			if (items[1] == 1) idx = items[2] - 1;
			else if (items[1] == 2) idx = items[2] + 1;
			
			ticketType[idx][items[3]]++;
			ticketType[idx][0]++;
			ticketType[idx][6] += items[5];
			// ������ �� Ƽ�ϼ�
			perAdvant[items[6]] = items[4]; // items[4] : Ƽ�ϼ���, items[6] : ������
			perAdvant[0]++; // countSum[0] : �� �ż�
		}
		pricePerDate.add(day+"-"+sum); // ������ �����Ͱ� ��µ��� �ʱ� ����
	}
}