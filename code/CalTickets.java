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

		if (todayYear % 100 < yourYear) yourYear += 1900; // 올해 년도 뒤의 두자리보다 크다? 1900년대생
		else yourYear += 2000; // 작거나 같다? 2000년대생

		int age = todayYear - yourYear; // 양쪽 모두 해당

		if (todayMonth < yourMonth) age -= 1; // 생일 달이 지나지 않았을경우
		else if (todayMonth == yourMonth && tdate >= yourDay) age -= 1; // 생일 달이지만, 날짜가 지나지 않은경우

		return checkAge(age);
	}

	protected int checkAge(int age) { // 나이 체크
		if (age < StaticValue.MIN_CHILD && age >= StaticValue.MIN_BABY) age = StaticValue.BABY;
		else if (age > StaticValue.MAX_ADULT) age = StaticValue.OLD;
		else if (age > StaticValue.MAX_TEEN) age = StaticValue.ADULT;
		else if (age < StaticValue.MIN_ADULT && age > StaticValue.MAX_CHILD) age = StaticValue.TEEN;
		else if (age < StaticValue.MIN_TEEN && age >= StaticValue.MIN_CHILD) age = StaticValue.CHILD;

		return age;
	}

	protected int checkTicketPrice(OrderData orderitem) { // 이용권 종류와 나이에 따른 티켓정가
		int price = 0; // 티켓값
		int idx = 0; // 가격확인용

		if (orderitem.ticketType == 1) idx = orderitem.ticketDay - 1; // index값 0, 1
		else if (orderitem.ticketType == 2) idx = orderitem.ticketDay + 1; // index값 2, 3

		if (orderitem.age == StaticValue.BABY) price = StaticValue.BABY_FEE;
		else if (orderitem.age == StaticValue.OLD) price = StaticValue.CHILD_FEE[idx]; // 65세 이상 = 어린이요금
		else if (orderitem.age == StaticValue.ADULT) price = StaticValue.ADULT_FEE[idx];
		else if (orderitem.age == StaticValue.TEEN) price = StaticValue.TEEN_FEE[idx];
		else if (orderitem.age == StaticValue.CHILD) price = StaticValue.CHILD_FEE[idx];

		return price;
	}

	protected int salePriceCal(int price, int type) { // 할인을 적용한 티켓값
		return (int) (price * StaticValue.percent[type] / 100) * 100;
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
		OrderData orderitem;

		int totalSum = 0;
		while (true) {
			orderitem = new OrderData(); // 새로 생성
			
			orderitem.ticketType = pui.ticketTypeAll(); // 종합 or 파크
			orderitem.ticketDay = pui.ticketTypeDay(); // 종일 or 오후
			orderitem.IDNumber = input.inputResidentNum(); // 주민번호 앞자리
			orderitem.orderCount = input.ticketsCount(); // 티켓수
			orderitem.adventageType = input.ticketSale(orderitem.ticketType); // 우대할인적용

			orderitem.age = calc.CalAge(orderitem.IDNumber); // 연령대계산
			int price = calc.checkTicketPrice(orderitem); // 티켓 정가
			orderitem.price = calc.salePriceCal(price, orderitem.adventageType); // 할인가 적용 티켓값
			int sum = calc.ticketSum(price, orderitem.adventageType, orderitem.orderCount, orderitem.price); // 티켓값 총합
			save.saveOrder(orderitem);
			totalSum += sum;
			int check = pui.printReapeat(sum); // 추가발권질문
			if (check == 2) break;
		}
		pui.printTickets(totalSum); // 발권한 티켓 종류 & 수 & 가격등 출력
		save.inputFile(); // 해당 파일에 입력
		
		return pui.inputEnd(); // 종료질문
	}
}