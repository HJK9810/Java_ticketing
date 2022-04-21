package DataAnalysis;

import java.io.FileWriter;
import java.io.IOException;

public class PrintFile {
	protected void PrintCSV() {
		PrintFile pf = new PrintFile();
		pf.PerDate(); // ���ں� ������ ���Ͽ� ����
		pf.PerType(); // ������ ������ ���Ͽ� ����
		pf.PerAdvate(); // ���Ǻ� ������ ���Ͽ� ����
	}
	
	protected void PerDate() {
		try {
			FileWriter fw = new FileWriter(StaticValue.PATH + "perDate.csv", false); // �������, ����� ���
			StringBuilder str = new StringBuilder();
			for(String line : CheckTickets.pricePerDate) {
				String[] ary = line.split("-"); // �Էµ� ���� : ��¥-���Ǹž�
				// ��¥ �и� : �⵵-��-��
				str.append(ary[0].substring(0, 4) + "-" + ary[0].substring(4, 6) + "-" + ary[0].substring(6) + " ,");
				str.append(ary[1] + "\n");

				fw.write(str.toString());
				str.setLength(0);
			}
			fw.close(); // ���ϴݱ�
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void PerType() {
		try {
			FileWriter fw = new FileWriter(StaticValue.PATH + "perType.csv", false);
			StringBuilder str = new StringBuilder();
			int[][] tickets = CheckTickets.ticketType;
			
			fw.write("���� ,"); // ù�� - ī�װ��κ� => �����̿��, ��ũ�̿�� �Էºκ��� ����1DAY, ��ũ1DAY�� ª�� �ٿ�����
			for(int idx = 1; idx < StaticValue.TICKET_TYPE.length; idx++) {
				str.append(StaticValue.TICKET_TYPE[idx].substring(0, 2) + StaticValue.TICKET_TIME[1] + " ,");
				str.append(StaticValue.TICKET_TYPE[idx].substring(0, 2) + StaticValue.TICKET_TIME[2]);
				if(idx == 1) str.append(" ,"); // ������������ �ٹٲ��� �ʿ��ϱ⿡ ��ǥ���� ����
				
				fw.write(str.toString());
				str.setLength(0);
			}
			fw.write("\n");
			
			int leng = tickets[0].length - 1;
			for(int idx = 1; idx < leng; idx ++) {
				str.append(StaticValue.AGE[idx] + " ,"); // ���ɱ���
				str.append(tickets[0][idx] + ","); // ����-1DAY
				str.append(tickets[1][idx] + ","); // ����-After4
				str.append(tickets[2][idx] + ","); // ��ũ-1DAY
				str.append(tickets[3][idx] + "\n"); // ��ũ-After4
				fw.write(str.toString());
				str.setLength(0);
			}
			fw.write("�հ� ," + tickets[0][0] + "," + tickets[1][0] + "," + tickets[2][0] + "," + tickets[3][0] + "\n");
			fw.write("���� ," + tickets[0][leng] + "," + tickets[1][leng] + "," + tickets[2][leng] + "," + tickets[3][leng] + "\n");
			
			fw.close(); // ���ϴݱ�
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void PerAdvate() {
		try {
			FileWriter fw = new FileWriter(StaticValue.PATH + "perAdvant.csv", false);
			StringBuilder str = new StringBuilder();
			for(int idx = 0; idx < CheckTickets.perAdvant.length; idx++) {
				if(idx == 0) str.append("�� �Ǹ� Ƽ�ϼ�" + ", " + CheckTickets.perAdvant[0]);
				else str.append(StaticValue.SALE_ADVANTAGE[idx] + ", " + CheckTickets.perAdvant[idx]);

				fw.write(str.toString() + "\n"); // �������� �ٹٲ� �ʼ�
				str.setLength(0);
			}
			fw.close(); // ���ϴݱ�
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}