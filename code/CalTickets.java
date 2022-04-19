package LotteTicketBox;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalTickets { // calculate all
	final int MIN_BABY = 1, MIN_CHILD = 3, MIN_TEEN = 13, MIN_ADULT = 19, MAX_CHILD = 12, MAX_TEEN = 18, MAX_ADULT = 64;

	protected int CalAge(int residentNum) { // calculate how old
		SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
		Date date = new Date();
		String today = format.format(date);
		// for calculate to change int
		int todayYear = Integer.parseInt(today.substring(0, 4));
		int todayMonth = Integer.parseInt(today.substring(4, 6));
		int tdate = Integer.parseInt(today.substring(6));

		int yourYear = residentNum / 10000; // 주민번호 = 년도 뒤의 두자리 + 월 두자리+ 날짜 두자리
		int yourMonth = residentNum % 10000 / 100;
		int yourDay = residentNum % 100;

		if (todayYear % 100 < yourYear) yourYear += 1900; // 올해 년도 뒤의 두자리보다 크다? 1900년대생
		else yourYear += 2000; // 작거나 같다? 2000년대생

		int age = todayYear - yourYear; // 양쪽 모두 해당

		if (todayMonth < yourMonth) age -= 1; // 생일 달이 지나지 않았을경우
		else if (todayMonth == yourMonth && tdate >= yourDay) age -= 1; // 생일 달이지만, 날짜가 지나지 않은경우

		return checkAge(age);
	}

	protected int checkAge(int age) { // 나이 체크
		if (age < MIN_CHILD && age >= MIN_BABY) age = StaticValue.BABY;
		else if (age > MAX_ADULT) age = StaticValue.OLD;
		else if (age > MAX_TEEN) age = StaticValue.ADULT;
		else if (age < MIN_ADULT && age > MAX_CHILD) age = StaticValue.TEEN;
		else if (age < MIN_TEEN && age >= MIN_CHILD) age = StaticValue.CHILD;

		return age;
	}

	protected int checkTicketPrice(int typeAll, int typeDay, int age) { // 이용권 종류와 나이에 따른 티켓정가
		final int[] ADULT_FEE = { 62000, 50000, 59000, 47000 }; // 종합-종일, 종합-오후, 파크-종일, 파크-오후
		final int[] TEEN_FEE = { 54000, 43000, 52000, 41000 };
		final int[] CHILD_FEE = { 47000, 36000, 46000, 35000 };
		final int BABY_FEE = 15000;
		int price = 0; // 티켓값
		int idx = 0; // 가격확인용

		if (typeAll == 1) idx = typeDay - 1; // index값 0, 1
		else if (typeAll == 2) idx = typeDay + 1; // index값 2, 3

		if (age == StaticValue.BABY) price = BABY_FEE;
		else if (age == StaticValue.OLD) price = CHILD_FEE[idx]; // 65세 이상 = 어린이요금
		else if (age == StaticValue.ADULT) price = ADULT_FEE[idx];
		else if (age == StaticValue.TEEN) price = TEEN_FEE[idx];
		else if (age == StaticValue.CHILD) price = CHILD_FEE[idx];

		return price;
	}

	protected int salePriceCal(int price, int type) { // 할인을 적용한 티켓값
		final float[] percent = { 0f, 1f, 0.5f, 0.5f, 0.51f, 0.5f, 0.7f }; // 각각의 할인률
		return (int) (price * percent[type] / 100) * 100;
	}

	protected int ticketSum(int price, int type, int count, int saleprice) { // 티켓값 총 합
		int sum = 0;

		if (type == StaticValue.NONE) sum = price * count; // 할인 미적용
		else if ((type != StaticValue.PREGNANT || type != StaticValue.MULTICHILD) && count > 1) { // 임산부 & 다둥이는 본인만 그 외는 동반 1인 할인
			sum = saleprice * 2 + price * (count - 2); // 동반적용 우대할인
		} else sum = saleprice + price * (count - 1); // 우대할인

		return sum;
	}
	
	protected int repeatFunc() {
		InputData input = new InputData();
		PrintUI pui = new PrintUI();
		CalTickets calc = new CalTickets();
		SaveVals save = new SaveVals();
		
		int totalSum = 0; // 모든 티켓값 총합
		int position = 0;
		while (true) {
			int typeAll = pui.ticketTypeAll(); // 종합 or 파크
			int typeDay = pui.ticketTypeDay(); // 종일 or 오후
			int residentNum = input.inputResidentNum(); // 주민번호 앞자리
			int count = input.ticketsCount(); // 티켓수
			int forsales = input.ticketSale(typeAll); // 우대할인적용

			int age = calc.CalAge(residentNum); // 연령대계산
			int price = calc.checkTicketPrice(typeAll, typeDay, age); // 티켓 정가
			int saleprice = calc.salePriceCal(price, forsales); // 할인가 적용 티켓값
			int sum = calc.ticketSum(price, forsales, count, saleprice); // 티켓값 총합
			position = save.saveOrder(typeAll, typeDay, age, count, saleprice, forsales, position);
			totalSum += sum;
			int check = pui.printReapeat(sum); // 추가발권질문
			if (check == 2) break;
		}
		pui.printTickets(totalSum, position); // 발권한 티켓 종류 & 수 & 가격등 출력
		save.inputFile(position); // 해당 파일에 입력
		
		return pui.inputEnd(); // 종료질문
	}
}