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

		int yourYear = Integer.parseInt(residentNum.substring(0, 2));
		int yourMonth = Integer.parseInt(residentNum.substring(2, 4));
		int yourDay = Integer.parseInt(residentNum.substring(4));

		if (todayYear % 100 < yourYear) yourYear += 1900; // ���� �⵵ ���� ���ڸ����� ũ��? 1900����
		else yourYear += 2000; // �۰ų� ����? 2000����

		int age = todayYear - yourYear; // ���� ��� �ش�

		if (todayMonth < yourMonth) age -= 1; // ���� ���� ������ �ʾ������
		else if (todayMonth == yourMonth && tdate >= yourDay) age -= 1; // ���� ��������, ��¥�� ������ �������

		return checkAge(age);
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

		if (orderitem.ticketType == 1) idx = orderitem.ticketDay - 1; // index�� 0, 1
		else if (orderitem.ticketType == 2) idx = orderitem.ticketDay + 1; // index�� 2, 3

		if (orderitem.age == StaticValue.BABY) price = StaticValue.BABY_FEE;
		else if (orderitem.age == StaticValue.OLD) price = StaticValue.CHILD_FEE[idx]; // 65�� �̻� = ��̿��
		else if (orderitem.age == StaticValue.ADULT) price = StaticValue.ADULT_FEE[idx];
		else if (orderitem.age == StaticValue.TEEN) price = StaticValue.TEEN_FEE[idx];
		else if (orderitem.age == StaticValue.CHILD) price = StaticValue.CHILD_FEE[idx];

		return price;
	}

	protected int salePriceCal(int price, int type) { // ������ ������ Ƽ�ϰ�
		return (int) (price * StaticValue.percent[type] / 100) * 100;
	}

	protected int ticketSum(int price, int type, int count, int saleprice) { // Ƽ�ϰ� �� ��
		int sum = 0;

		if (type == StaticValue.NONE) sum = price * count; // ���� ������
		else if ((type != StaticValue.PREGNANT || type != StaticValue.MULTICHILD) && count > 1) { // �ӻ�� & �ٵ��̴� ���θ� �� �ܴ� ���� 1�� ����
			sum = saleprice * 2 + price * (count - 2); // �������� �������
		} else sum = saleprice + price * (count - 1); // �������

		return sum;
	}
	
	protected int repeatFunc() {
		InputData input = new InputData();
		PrintUI pui = new PrintUI();
		CalTickets calc = new CalTickets();
		SaveVals save = new SaveVals();
		OrderData orderitem;

		int totalSum = 0;
		while (true) {
			orderitem = new OrderData(); // ���� ����
			
			orderitem.ticketType = pui.ticketTypeAll(); // ���� or ��ũ
			orderitem.ticketDay = pui.ticketTypeDay(); // ���� or ����
			orderitem.IDNumber = input.inputResidentNum(); // �ֹι�ȣ ���ڸ�
			orderitem.orderCount = input.ticketsCount(); // Ƽ�ϼ�
			orderitem.adventageType = input.ticketSale(orderitem.ticketType); // �����������

			orderitem.age = calc.CalAge(orderitem.IDNumber); // ���ɴ���
			int price = calc.checkTicketPrice(orderitem); // Ƽ�� ����
			orderitem.price = calc.salePriceCal(price, orderitem.adventageType); // ���ΰ� ���� Ƽ�ϰ�
			int sum = calc.ticketSum(price, orderitem.adventageType, orderitem.orderCount, orderitem.price); // Ƽ�ϰ� ����
			save.saveOrder(orderitem);
			totalSum += sum;
			int check = pui.printReapeat(sum); // �߰��߱�����
			if (check == 2) break;
		}
		pui.printTickets(totalSum); // �߱��� Ƽ�� ���� & �� & ���ݵ� ���
		save.inputFile(); // �ش� ���Ͽ� �Է�
		
		return pui.inputEnd(); // ��������
	}
}