package TicketBox;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SaveVals { // save & make csv files
	FileWriter fw; // ���� �޼ҵ忡�� ��� �ݺ��Ǳ⿡ class���� ����
	protected static ArrayList<OrderData> orderList = new ArrayList<>(); // Ƽ�Ϲ߱ǿ� �迭
	
	protected void saveOrder(OrderData orderItem) {
		orderList.add(orderItem); // arraylist�� �ش� ���� input
	}
	
	protected void InputCSVs() { // �м� ������ �� ���Ͽ� ����
		SaveVals pf = new SaveVals();
		pf.PerDate(); // ���ں� ������ ���Ͽ� ����
		pf.PerType(); // ������ ������ ���Ͽ� ����
		pf.PerAdvate(); // ���Ǻ� ������ ���Ͽ� ����
	}

	protected void inputFile() { // ���Ͽ� �Է��� ���� �̾��
		SimpleDateFormat dateformat = new SimpleDateFormat("YYYYMMdd"); // ��¥ �� ����
		Date date = new Date();
		String today = dateformat.format(date); // ���ó�¥
		try {
			fw = new FileWriter(StaticValue.PATH + "report.csv", true);
			StringBuilder str = new StringBuilder(); // �뷮�� ���� �����ϱ����� ������ string
			for (OrderData item : orderList) { // forEach ���
				str.append(today + ","); // ���ó�¥ �Է�
				// �̿��
				if (item.getTicketType() == StaticValue.ALL_TICKET) str.append(String.format("%-7s,", "�����̿��"));
				else if (item.getTicketType() == StaticValue.PARK_TICKET) str.append(String.format("%-7s,", "��ũ�̿��"));
				// ����
				if (item.getTicketDay() == StaticValue.ALL_DAY) str.append(String.format("%-6s,", "1DAY"));
				else if (item.getTicketDay() == StaticValue.AFTER4) str.append(String.format("%-6s,", "After4"));
				// ����
				if (item.getAge() == StaticValue.OLD) str.append(String.format("%-4s,", "����"));
				else if (item.getAge() == StaticValue.ADULT) str.append(String.format("%-4s,", "�")); // �
				else if (item.getAge() == StaticValue.TEEN) str.append(String.format("%-4s,", "û�ҳ�")); // û�ҳ�
				else if (item.getAge() == StaticValue.CHILD) str.append(String.format("%-4s,", "���")); // ���
				else str.append(String.format("%-4s,", "���̺�"));
				// ���� & ����
				str.append(String.format("%d,%d,", item.getOrderCount(), item.getSum()));
				// ������
				if (item.getAdventageType() == StaticValue.NONE) str.append("����\n");
				else if (item.getAdventageType() == StaticValue.DISABLE) str.append("�����\n");
				else if (item.getAdventageType() == StaticValue.MERIT) str.append("����������\n");
				else if (item.getAdventageType() == StaticValue.VACSOLD) str.append("�ް��庴\n");
				else if (item.getAdventageType() == StaticValue.PREGNANT) str.append("�ӻ��\n");
				else if (item.getAdventageType() == StaticValue.MULTICHILD) str.append("�ٵ���\n");
				
				fw.write(str.toString()); // �ش� ���� string��ȯ & ���� �Է�
				str.setLength(0); // stringbuilder �ʱ�ȭ
			}

			fw.close(); // ���ϴݱ�
		} catch (IOException e) { // �����а� ���µ����� ����üũ��
			e.printStackTrace();
		}
	}
	
	protected void PerDate() { // ���ں� ���� �м� ���� ���
		try {
			fw = new FileWriter(StaticValue.PATH + "perDate.csv", false); // �������, ����� ���
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
	
	protected void PerType() { // ������ �Ǹ� �м� �������
		try {
			fw = new FileWriter(StaticValue.PATH + "perType.csv", false);
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
	
	protected void PerAdvate() { // ���� �Ǹź� �м� ���� ���
		try {
			fw = new FileWriter(StaticValue.PATH + "perAdvant.csv", false);
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