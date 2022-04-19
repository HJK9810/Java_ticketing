package LotteTicketBox;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveVals { // save & make csv files
	
	protected void saveOrder(OrderData orderItem) {
		Ticketing.orderList.add(orderItem); // arraylist�� �ش� ���� input
	}

	protected void inputFile() {
		SimpleDateFormat dateformat = new SimpleDateFormat("YYYYMMdd");
		Date date = new Date();
		String today = dateformat.format(date); // ���ó�¥
		try {
			FileWriter fw = new FileWriter("C:\\Users\\A_013\\Documents\\C�ڵ�\\ticketing\\report.csv", true);
			StringBuilder str = new StringBuilder(); // �뷮�� ���� �����ϱ����� ������ string
			for (OrderData item : Ticketing.orderList) {
				str.append(today + ","); // ���ó�¥ �Է�
				// �̿��
				if (item.ticketType == StaticValue.ALL_TICKET) str.append(String.format("%-7s,", "�����̿��"));
				else if (item.ticketType == StaticValue.PARK_TICKET) str.append(String.format("%-7s,", "��ũ�̿��"));
				// ����
				if (item.ticketDay == StaticValue.ALL_DAY) str.append(String.format("%-6s,", "1DAY"));
				else if (item.ticketDay == StaticValue.AFTER4) str.append(String.format("%-6s,", "After4"));
				// ����
				if (item.age == StaticValue.OLD) str.append(String.format("%-4s,", "����"));
				else if (item.age == StaticValue.ADULT) str.append(String.format("%-4s,", "�")); // �
				else if (item.age == StaticValue.TEEN) str.append(String.format("%-4s,", "û�ҳ�")); // û�ҳ�
				else if (item.age == StaticValue.CHILD) str.append(String.format("%-4s,", "���")); // ���
				else str.append(String.format("%-4s,", "���̺�"));
				// ���� & ����
				str.append(String.format("%d,%d,", item.orderCount, item.price));
				// ������
				if (item.adventageType == StaticValue.NONE) str.append("����\n");
				else if (item.adventageType == StaticValue.DISABLE) str.append("�����\n");
				else if (item.adventageType == StaticValue.MERIT) str.append("����������\n");
				else if (item.adventageType == StaticValue.VACSOLD) str.append("�ް��庴\n");
				else if (item.adventageType == StaticValue.PREGNANT) str.append("�ӻ��\n");
				else if (item.adventageType == StaticValue.MULTICHILD) str.append("�ٵ���\n");
				
				fw.write(str.toString()); // �ش� ���� string��ȯ & ���� �Է�
				str.setLength(0); // stringbuilder �ʱ�ȭ
			}

			fw.close(); // ���ϴݱ�
		} catch (IOException e) { // �����а� ���µ����� ����üũ��
			e.printStackTrace();
		}
	}
}