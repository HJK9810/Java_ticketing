package LotteTicketBox;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveVals { // save & make csv files
	// ����, ���, ������, �ް��庴, �ӻ��, �ٵ���
	final int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;
	
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
				if (age == OLD) str.append(String.format("%-4s,", "����"));
				else if (age == ADULT) str.append(String.format("%-4s,", "�")); // �
				else if (age == TEEN) str.append(String.format("%-4s,", "û�ҳ�")); // û�ҳ�
				else if (age == CHILD) str.append(String.format("%-4s,", "���")); // ���
				else str.append(String.format("%-4s,", "���̺�"));
				// ���� & ����
				str.append(String.format("%d,%d,", count, price));
				// ������
				if (sales == NONE) str.append("����\n");
				else if (sales == DISABLE) str.append("�����\n");
				else if (sales == MERIT) str.append("����������\n");
				else if (sales == VACSOLD) str.append("�ް��庴\n");
				else if (sales == PREGNANT) str.append("�ӻ��\n");
				else if (sales == MULTICHILD) str.append("�ٵ���\n");
				
				fw.write(str.toString()); // �ش� ���� string��ȯ & ���� �Է�
				str.setLength(0); // stringbuilder �ʱ�ȭ
			}

			fw.close(); // ���ϴݱ�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}