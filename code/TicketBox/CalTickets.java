package TicketBox;

public class CalTickets { // calculate all
	protected void sysCal(OrderData orderitem) {
		CalTickets calc = new CalTickets();
		
		orderitem.setAge(calc.calAge(orderitem.getIDNumber())); // ���ɴ���
		int price = calc.checkTicketPrice(orderitem); // Ƽ�� ����
		orderitem.setPrice(calc.salePriceCal(price, orderitem.getAdventageType())); // ���ΰ� ���� Ƽ�ϰ�
		orderitem.setSum(calc.ticketSum(price, orderitem.getAdventageType(), orderitem.getOrderCount(), orderitem.getPrice())); // Ƽ�ϰ� ����
	}
	
	protected int calAge(String residentNum) { // calculate how old
		String today = StaticValue.getToday();
		
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
		if (age < StaticValue.MIN_CHILD && age >= StaticValue.MIN_BABY) age = StaticValue.BABY;
		else if (age > StaticValue.MAX_ADULT) age = StaticValue.OLD;
		else if (age > StaticValue.MAX_TEEN) age = StaticValue.ADULT;
		else if (age < StaticValue.MIN_ADULT && age > StaticValue.MAX_CHILD) age = StaticValue.TEEN;
		else if (age < StaticValue.MIN_TEEN && age >= StaticValue.MIN_CHILD) age = StaticValue.CHILD;

		return age;
	}

	protected int checkTicketPrice(OrderData orderitem) { // �̿�� ������ ���̿� ���� Ƽ������
		int price = 0; // Ƽ�ϰ�
		int idx = 0; // ����Ȯ�ο�

		if (orderitem.getTicketType() == StaticValue.ALL_TICKET) idx = orderitem.getTicketDay() - 1; // index�� 0, 1
		else if (orderitem.getTicketType() == StaticValue.PARK_TICKET) idx = orderitem.getTicketDay() + 1; // index�� 2, 3
		// BABY_FEE�� ������ ��ݵ��� �迭�� ����Ȼ���
		if (orderitem.getAge() == StaticValue.BABY) price = StaticValue.BABY_FEE;
		else if (orderitem.getAge() == StaticValue.OLD) price = StaticValue.CHILD_FEE[idx]; // 65�� �̻� = ��̿��
		else if (orderitem.getAge() == StaticValue.ADULT) price = StaticValue.ADULT_FEE[idx];
		else if (orderitem.getAge() == StaticValue.TEEN) price = StaticValue.TEEN_FEE[idx];
		else if (orderitem.getAge() == StaticValue.CHILD) price = StaticValue.CHILD_FEE[idx];

		return price;
	}

	protected int salePriceCal(int price, int type) { // ������ ������ Ƽ�ϰ�
		return (int) (price * StaticValue.percent[type] / 100) * 100; // /100 * 100 ���� : �Ե����� ���ΰ� �ּҴ����� 100���̱� ����
	}

	protected int ticketSum(int price, int type, int count, int saleprice) { // Ƽ�ϰ� �� ��
		int sum = 0;

		if (type == StaticValue.NONE) sum = price * count; // ���� ������
		else if ((type != StaticValue.PREGNANT || type != StaticValue.MULTICHILD) && count > StaticValue.NONE) { // �ӻ�� & �ٵ��̴� ���θ� �� �ܴ� ���� 1�� ����
			sum = saleprice * 2 + price * (count - 2); // �������� �������
		} else sum = saleprice + price * (count - 1); // �������

		return sum;
	}
}