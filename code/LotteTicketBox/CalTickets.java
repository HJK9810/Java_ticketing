package LotteTicketBox;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalTickets { // calculate all
	protected void sysCal(OrderData orderitem) {
		CalTickets calc = new CalTickets();
		
		orderitem.setAge(calc.calAge(orderitem.getIDNumber())); // 연령대계산
		int price = calc.checkTicketPrice(orderitem); // 티켓 정가
		orderitem.setPrice(calc.salePriceCal(price, orderitem.getAdventageType())); // 할인가 적용 티켓값
		orderitem.setSum(calc.ticketSum(price, orderitem.getAdventageType(), orderitem.getOrderCount(), orderitem.getPrice())); // 티켓값 총합
	}
	
	protected int calAge(String residentNum) { // calculate how old
		SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
		Date date = new Date();
		String today = format.format(date);
		
		// for calculate to change int
		int todayYear = Integer.parseInt(today.substring(0, 4));
		int todayMonth = Integer.parseInt(today.substring(4, 6));
		int tdate = Integer.parseInt(today.substring(6));
		// 주민번호는 총 6자리
		int yourYear = Integer.parseInt(residentNum.substring(0, 2));
		int yourMonth = Integer.parseInt(residentNum.substring(2, 4));
		int yourDay = Integer.parseInt(residentNum.substring(4));

		if (todayYear % 100 < yourYear) yourYear += 1900; // 올해 년도 뒤의 두자리보다 크다? 1900년대생
		else yourYear += 2000; // 작거나 같다? 2000년대생

		int age = todayYear - yourYear; // 양쪽 모두 해당

		if (todayMonth < yourMonth) age -= 1; // 생일 달이 지나지 않았을경우
		else if (todayMonth == yourMonth && tdate >= yourDay) age -= 1; // 생일 달이지만, 날짜가 지나지 않은경우

		return checkAge(age); // 현 나이로 나잇대 체크
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

		if (orderitem.getTicketType() == StaticValue.ALL_TICKET) idx = orderitem.getTicketDay() - 1; // index값 0, 1
		else if (orderitem.getTicketType() == StaticValue.PARK_TICKET) idx = orderitem.getTicketDay() + 1; // index값 2, 3
		// BABY_FEE를 제외한 요금들은 배열에 저장된상태
		if (orderitem.getAge() == StaticValue.BABY) price = StaticValue.BABY_FEE;
		else if (orderitem.getAge() == StaticValue.OLD) price = StaticValue.CHILD_FEE[idx]; // 65세 이상 = 어린이요금
		else if (orderitem.getAge() == StaticValue.ADULT) price = StaticValue.ADULT_FEE[idx];
		else if (orderitem.getAge() == StaticValue.TEEN) price = StaticValue.TEEN_FEE[idx];
		else if (orderitem.getAge() == StaticValue.CHILD) price = StaticValue.CHILD_FEE[idx];

		return price;
	}

	protected int salePriceCal(int price, int type) { // 할인을 적용한 티켓값
		return (int) (price * StaticValue.percent[type] / 100) * 100; // /100 * 100 이유 : 롯데월드 할인가 최소단위는 100원이기 때문
	}

	protected int ticketSum(int price, int type, int count, int saleprice) { // 티켓값 총 합
		int sum = 0;

		if (type == StaticValue.NONE) sum = price * count; // 할인 미적용
		else if ((type != StaticValue.PREGNANT || type != StaticValue.MULTICHILD) && count > StaticValue.NONE) { // 임산부 & 다둥이는 본인만 그 외는 동반 1인 할인
			sum = saleprice * 2 + price * (count - 2); // 동반적용 우대할인
		} else sum = saleprice + price * (count - 1); // 우대할인

		return sum;
	}
}