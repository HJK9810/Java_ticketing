package LotteTicketBox;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SaveVals { // save & make csv files
	protected static ArrayList<OrderData> orderList = new ArrayList<>(); // Ƽ�Ϲ߱ǿ� �迭
	
	protected void saveOrder(OrderData orderItem) {
		orderList.add(orderItem); // arraylist�� �ش� ���� input
	}

	protected void inputFile() { // ���Ͽ� �Է��� ���� �̾��
		SimpleDateFormat dateformat = new SimpleDateFormat("YYYYMMdd"); // ��¥ �� ����
		Date date = new Date();
		String today = dateformat.format(date); // ���ó�¥
		try {
			FileWriter fw = new FileWriter("C:\\javatest\\ticketing\\report.csv", true);
			StringBuilder str = new StringBuilder(); // �뷮�� ���� �����ϱ����� ������ string
			for (OrderData item : orderList) { // forEach ���
				str.append(today + ","); // ���ó�¥ �Է�
				// �̿��
				if (item.getTicketType() == StaticValue.getAllTicket()) str.append(String.format("%-7s,", "�����̿��"));
				else if (item.getTicketType() == StaticValue.getParkTicket()) str.append(String.format("%-7s,", "��ũ�̿��"));
				// ����
				if (item.getTicketDay() == StaticValue.getAllDay()) str.append(String.format("%-6s,", "1DAY"));
				else if (item.getTicketDay() == StaticValue.getAfter4()) str.append(String.format("%-6s,", "After4"));
				// ����
				if (item.getAge() == StaticValue.getOld()) str.append(String.format("%-4s,", "����"));
				else if (item.getAge() == StaticValue.getAdult()) str.append(String.format("%-4s,", "�")); // �
				else if (item.getAge() == StaticValue.getTeen()) str.append(String.format("%-4s,", "û�ҳ�")); // û�ҳ�
				else if (item.getAge() == StaticValue.getChild()) str.append(String.format("%-4s,", "���")); // ���
				else str.append(String.format("%-4s,", "���̺�"));
				// ���� & ����
				str.append(String.format("%d,%d,", item.getOrderCount(), item.getSum()));
				// ������
				if (item.getAdventageType() == StaticValue.getNone()) str.append("����\n");
				else if (item.getAdventageType() == StaticValue.getDisable()) str.append("�����\n");
				else if (item.getAdventageType() == StaticValue.getMerit()) str.append("����������\n");
				else if (item.getAdventageType() == StaticValue.getVacsold()) str.append("�ް��庴\n");
				else if (item.getAdventageType() == StaticValue.getPregnant()) str.append("�ӻ��\n");
				else if (item.getAdventageType() == StaticValue.getMultichild()) str.append("�ٵ���\n");
				
				fw.write(str.toString()); // �ش� ���� string��ȯ & ���� �Է�
				str.setLength(0); // stringbuilder �ʱ�ȭ
			}

			fw.close(); // ���ϴݱ�
		} catch (IOException e) { // �����а� ���µ����� ����üũ��
			e.printStackTrace();
		}
	}
}