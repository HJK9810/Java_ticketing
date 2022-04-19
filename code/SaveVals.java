package LotteTicketBox;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveVals { // save & make csv files
	
	protected int saveOrder(int all, int day, int age, int count, int price, int sales, int lastline) {
		Ticketing.orderList[lastline][0] = all;
		Ticketing.orderList[lastline][1] = day;
		Ticketing.orderList[lastline][2] = age;
		Ticketing.orderList[lastline][3] = count;
		Ticketing.orderList[lastline][4] = price;
		Ticketing.orderList[lastline][5] = sales;
		return ++lastline;
	}

	protected void inputFile(int lastline) {
		SimpleDateFormat dateformat = new SimpleDateFormat("YYYYMMdd");
		Date date = new Date();
		String today = dateformat.format(date); // ���ó�¥
		try {
			FileWriter fw = new FileWriter("C:\\Users\\A_013\\Documents\\C�ڵ�\\ticketing\\report.csv", true);
			StringBuilder str = new StringBuilder(); // �뷮�� ���� �����ϱ����� ������ string
			for (int idx = 0; idx < lastline; idx++) {
				int[] list = Ticketing.orderList[idx]; // ������ �������� �ʱ� ���� �迭 ������
				int typeAll = list[0];
				int typeDay = list[1];
				int age = list[2];
				int count = list[3];
				int price = list[4];
				int sales = list[5];

				str.append(today + ","); // ���ó�¥ �Է�
				// �̿��
				if (typeAll == 1) str.append(String.format("%-7s,", "�����̿��"));
				else if (typeAll == 2) str.append(String.format("%-7s,", "��ũ�̿��"));
				// ����
				if (typeDay == 1) str.append(String.format("%-6s,", "1DAY"));
				else if (typeDay == 2) str.append(String.format("%-6s,", "After4"));
				// ����
				if (age == StaticValue.OLD) str.append(String.format("%-4s,", "����"));
				else if (age == StaticValue.ADULT) str.append(String.format("%-4s,", "�")); // �
				else if (age == StaticValue.TEEN) str.append(String.format("%-4s,", "û�ҳ�")); // û�ҳ�
				else if (age == StaticValue.CHILD) str.append(String.format("%-4s,", "���")); // ���
				else str.append(String.format("%-4s,", "���̺�"));
				// ���� & ����
				str.append(String.format("%d,%d,", count, price));
				// ������
				if (sales == StaticValue.NONE) str.append("����\n");
				else if (sales == StaticValue.DISABLE) str.append("�����\n");
				else if (sales == StaticValue.MERIT) str.append("����������\n");
				else if (sales == StaticValue.VACSOLD) str.append("�ް��庴\n");
				else if (sales == StaticValue.PREGNANT) str.append("�ӻ��\n");
				else if (sales == StaticValue.MULTICHILD) str.append("�ٵ���\n");
				
				fw.write(str.toString()); // �ش� ���� string��ȯ & ���� �Է�
				str.setLength(0); // stringbuilder �ʱ�ȭ
			}

			fw.close(); // ���ϴݱ�
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}