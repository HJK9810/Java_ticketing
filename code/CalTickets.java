package LotteTicketBox;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalTickets { // calculate all
	final int MIN_BABY = 1, MIN_CHILD = 3, MIN_TEEN = 13, MIN_ADULT = 19, MAX_CHILD = 12, MAX_TEEN = 18, MAX_ADULT = 64;
	// ����, ���, ������, �ް��庴, �ӻ��, �ٵ���
	final int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;

	protected int CalAge(int residentNum) { // calculate how old
		SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
		Date date = new Date();
		String today = format.format(date);
		// for calculate to change int
		int todayYear = Integer.parseInt(today.substring(0, 4));
		int todayMonth = Integer.parseInt(today.substring(4, 6));
		int tdate = Integer.parseInt(today.substring(6));

		int yourYear = residentNum / 10000; // �ֹι�ȣ = �⵵ ���� ���ڸ� + �� ���ڸ�+ ��¥ ���ڸ�
		int yourMonth = residentNum % 10000 / 100;
		int yourDay = residentNum % 100;

		if (todayYear % 100 < yourYear) yourYear += 1900; // ���� �⵵ ���� ���ڸ����� ũ��? 1900����
		else yourYear += 2000; // �۰ų� ����? 2000����

		int age = todayYear - yourYear; // ���� ��� �ش�

		if (todayMonth < yourMonth) age -= 1; // ���� ���� ������ �ʾ������
		else if (todayMonth == yourMonth && tdate >= yourDay) age -= 1; // ���� ��������, ��¥�� ������ �������

		return age;
	}

	protected int checkAge(int age) { // ���� üũ
		if (age < MIN_CHILD && age >= MIN_BABY) age = BABY;
		else if (age > MAX_ADULT) age = OLD;
		else if (age > MAX_TEEN) age = ADULT;
		else if (age < MIN_ADULT && age > MAX_CHILD) age = TEEN;
		else if (age < MIN_TEEN && age >= MIN_CHILD) age = CHILD;

		return age;
	}

	protected int checkTicketPrice(int typeAll, int typeDay, int age) { // �̿�� ������ ���̿� ���� Ƽ������
		final int[] ADULT_FEE = { 62000, 50000, 59000, 47000 }; // ����-����, ����-����, ��ũ-����, ��ũ-����
		final int[] TEEN_FEE = { 54000, 43000, 52000, 41000 };
		final int[] CHILD_FEE = { 47000, 36000, 46000, 35000 };
		final int BABY_FEE = 15000;
		int price = 0; // Ƽ�ϰ�
		int idx = 0; // ����Ȯ�ο�

		if (typeAll == 1) idx = typeDay - 1; // index�� 0, 1
		else if (typeAll == 2) idx = typeDay + 1; // index�� 2, 3

		if (age == BABY) price = BABY_FEE;
		else if (age == OLD) price = CHILD_FEE[idx]; // 65�� �̻� = ��̿��
		else if (age == ADULT) price = ADULT_FEE[idx];
		else if (age == TEEN) price = TEEN_FEE[idx];
		else if (age == CHILD) price = CHILD_FEE[idx];

		return price;
	}

	protected int salePriceCal(int price, int type) { // ������ ������ Ƽ�ϰ�
		final float[] percent = { 0f, 1f, 0.5f, 0.5f, 0.51f, 0.5f, 0.7f }; // ������ ���η�
		return (int) (price * percent[type] / 100) * 100;
	}

	protected int ticketSum(int price, int type, int count, int saleprice) { // Ƽ�ϰ� �� ��
		int sum = 0;

		if (type == NONE) sum = price * count; // ���� ������
		else if ((type != PREGNANT || type != MULTICHILD) && count > 1) { // �ӻ�� & �ٵ��̴� ���θ� �� �ܴ� ���� 1�� ����
			sum = saleprice * 2 + price * (count - 2); // �������� �������
		} else sum = saleprice + price * (count - 1); // �������

		return sum;
	}
}