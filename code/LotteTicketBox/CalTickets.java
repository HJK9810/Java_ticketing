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
		if (age < StaticValue.getMinChild() && age >= StaticValue.getMinBaby()) age = StaticValue.getBaby();
		else if (age > StaticValue.getMaxAdult()) age = StaticValue.getOld();
		else if (age > StaticValue.getMaxTeen()) age = StaticValue.getAdult();
		else if (age < StaticValue.getMinAdult() && age > StaticValue.getMaxChild()) age = StaticValue.getTeen();
		else if (age < StaticValue.getMinTeen() && age >= StaticValue.getMinChild()) age = StaticValue.getChild();

		return age;
	}

	protected int checkTicketPrice(OrderData orderitem) { // 이용권 종류와 나이에 따른 티켓정가
		int price = 0; // 티켓값
		int idx = 0; // 가격확인용

		if (orderitem.getTicketType() == StaticValue.getAllTicket()) idx = orderitem.getTicketDay() - 1; // index값 0, 1
		else if (orderitem.getTicketType() == StaticValue.getParkTicket()) idx = orderitem.getTicketDay() + 1; // index값 2, 3
		// BABY_FEE를 제외한 요금들은 배열에 저장된상태
		if (orderitem.getAge() == StaticValue.getBaby()) price = StaticValue.getBabyFee();
		else if (orderitem.getAge() == StaticValue.getOld()) price = StaticValue.getChildFee()[idx]; // 65세 이상 = 어린이요금
		else if (orderitem.getAge() == StaticValue.getAdult()) price = StaticValue.getAdultFee()[idx];
		else if (orderitem.getAge() == StaticValue.getTeen()) price = StaticValue.getTeenFee()[idx];
		else if (orderitem.getAge() == StaticValue.getChild()) price = StaticValue.getChildFee()[idx];

		return price;
	}

	protected int salePriceCal(int price, int type) { // 할인을 적용한 티켓값
		return (int) (price * StaticValue.getPercent()[type] / 100) * 100; // /100 * 100 이유 : 롯데월드 할인가 최소단위는 100원이기 때문
	}

	protected int ticketSum(int price, int type, int count, int saleprice) { // 티켓값 총 합
		int sum = 0;

		if (type == StaticValue.getNone()) sum = price * count; // 할인 미적용
		else if ((type != StaticValue.getPregnant() || type != StaticValue.getMultichild()) && count > StaticValue.getNone()) { // 임산부 & 다둥이는 본인만 그 외는 동반 1인 할인
			sum = saleprice * 2 + price * (count - 2); // 동반적용 우대할인
		} else sum = saleprice + price * (count - 1); // 우대할인

		return sum;
	}
	
	protected int repeatFunc() { //  main에서 반복되던 함수 분리
		InputData input = new InputData(); // 입력용
		PrintUI pui = new PrintUI(); // ui 출력용
		CalTickets calc = new CalTickets(); // 계산용
		SaveVals save = new SaveVals(); // 데이터 저장 & 파일 저장용
		OrderData orderitem; // 정의

		int totalSum = 0; // '한번에' 발급한 전체 티켓값 총합
		while (true) {
			orderitem = new OrderData(); // 새로 생성
			
			orderitem.setTicketType(pui.ticketTypeAll()); // 종합 or 파크
			orderitem.setTicketDay(pui.ticketTypeDay()); // 종일 or 오후
			orderitem.setIDNumber(input.inputResidentNum()); // 주민번호 앞자리
			orderitem.setOrderCount(input.ticketsCount()); // 티켓수
			orderitem.setAdventageType(input.ticketSale(orderitem.getTicketType())); // 우대할인적용

			orderitem.setAge(calc.CalAge(orderitem.getIDNumber())); // 연령대계산
			int price = calc.checkTicketPrice(orderitem); // 티켓 정가
			orderitem.setPrice(calc.salePriceCal(price, orderitem.getAdventageType())); // 할인가 적용 티켓값
			orderitem.setSum(calc.ticketSum(price, orderitem.getAdventageType(), orderitem.getOrderCount(), orderitem.getPrice())); // 티켓값 총합
			save.saveOrder(orderitem); // 해당 데이터, arraylist에 저장
			totalSum += orderitem.getSum(); // 누적총합
			int check = pui.printReapeat(orderitem.getSum()); // 추가발권질문
			if (check == StaticValue.getEnd()) break; // 반복문 out
		}
		pui.printTickets(totalSum); // 발권한 티켓 종류 & 수 & 가격등 출력
		save.inputFile(); // 해당 파일에 입력
		
		return pui.inputEnd(); // 종료질문
	}
}