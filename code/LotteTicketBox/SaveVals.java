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
}