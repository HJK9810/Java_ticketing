package LotteTicketBox;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalTickets { // calculate all
	protected int CalAge(String residentNum) { // calculate how old
		SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
		Date date = new Date();
		String today = format.format(date);
		
		// for calculate to change int
		int todayYear = Integer.parseInt(today.substring(0, 4));
		int todayMonth = Integer.parseInt(today.substring(4, 6));
		int tdate = Integer.parseInt(today.substring(6));
		// �ֹι�ȣ�� �� 6�ڸ�
		int yourYear = Integer.parseInt(residentNum.substring(0, 2));
		int yourMonth = Integer.parseInt(residentNum.substring(2, 4));
		int yourDay = Integer.parseInt(residentNum.substring(4));

		if (todayYear % 100 < yourYear) yourYear += 1900; // ���� �⵵ ���� ���ڸ����� ũ��? 1900����
		else yourYear += 2000; // �۰ų� ����? 2000����

		int age = todayYear - yourYear; // ���� ��� �ش�

		if (todayMonth < yourMonth) age -= 1; // ���� ���� ������ �ʾ������
		else if (todayMonth == yourMonth && tdate >= yourDay) age -= 1; // ���� ��������, ��¥�� ������ �������

		return checkAge(age); // �� ���̷� ���մ� üũ
	}

	protected int checkAge(int age) { // ���� üũ
		if (age < StaticValue.getMinChild() && age >= StaticValue.getMinBaby()) age = StaticValue.getBaby();
		else if (age > StaticValue.getMaxAdult()) age = StaticValue.getOld();
		else if (age > StaticValue.getMaxTeen()) age = StaticValue.getAdult();
		else if (age < StaticValue.getMinAdult() && age > StaticValue.getMaxChild()) age = StaticValue.getTeen();
		else if (age < StaticValue.getMinTeen() && age >= StaticValue.getMinChild()) age = StaticValue.getChild();

		return age;
	}

	protected int checkTicketPrice(OrderData orderitem) { // �̿�� ������ ���̿� ���� Ƽ������
		int price = 0; // Ƽ�ϰ�
		int idx = 0; // ����Ȯ�ο�

		if (orderitem.getTicketType() == StaticValue.getAllTicket()) idx = orderitem.getTicketDay() - 1; // index�� 0, 1
		else if (orderitem.getTicketType() == StaticValue.getParkTicket()) idx = orderitem.getTicketDay() + 1; // index�� 2, 3
		// BABY_FEE�� ������ ��ݵ��� �迭�� ����Ȼ���
		if (orderitem.getAge() == StaticValue.getBaby()) price = StaticValue.getBabyFee();
		else if (orderitem.getAge() == StaticValue.getOld()) price = StaticValue.getChildFee()[idx]; // 65�� �̻� = ��̿��
		else if (orderitem.getAge() == StaticValue.getAdult()) price = StaticValue.getAdultFee()[idx];
		else if (orderitem.getAge() == StaticValue.getTeen()) price = StaticValue.getTeenFee()[idx];
		else if (orderitem.getAge() == StaticValue.getChild()) price = StaticValue.getChildFee()[idx];

		return price;
	}

	protected int salePriceCal(int price, int type) { // ������ ������ Ƽ�ϰ�
		return (int) (price * StaticValue.getPercent()[type] / 100) * 100; // /100 * 100 ���� : �Ե����� ���ΰ� �ּҴ����� 100���̱� ����
	}

	protected int ticketSum(int price, int type, int count, int saleprice) { // Ƽ�ϰ� �� ��
		int sum = 0;

		if (type == StaticValue.getNone()) sum = price * count; // ���� ������
		else if ((type != StaticValue.getPregnant() || type != StaticValue.getMultichild()) && count > StaticValue.getNone()) { // �ӻ�� & �ٵ��̴� ���θ� �� �ܴ� ���� 1�� ����
			sum = saleprice * 2 + price * (count - 2); // �������� �������
		} else sum = saleprice + price * (count - 1); // �������

		return sum;
	}
}