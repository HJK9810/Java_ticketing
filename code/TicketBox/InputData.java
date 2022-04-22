package TicketBox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InputData { // for inputs
	Scanner scanner = new Scanner(System.in); // 해당 클래스의 모든 함수가 사용함으로 여기에 정의
	int input = 0; // int로 입력받을때
	String line = ""; // String으로 입력받을때
	
	protected void startinput(OrderData orderitem) {
		PrintUI pui = new PrintUI();
		InputData input = new InputData();
		
		orderitem.setTicketType(pui.ticketTypeAll()); // 종합 or 파크
		orderitem.setTicketDay(pui.ticketTypeDay()); // 종일 or 오후
		orderitem.setIDNumber(input.inputResidentNum()); // 주민번호 앞자리
		orderitem.setOrderCount(input.ticketsCount()); // 티켓수
		orderitem.setAdventageType(input.ticketSale(orderitem.getTicketType())); // 우대할인적용
	}

	protected int checkTwoChoice() { // 2개중 하나를 선택하는 경우
		SystemFunc sys = new SystemFunc();
		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
			if(input == 33) break;
		} while (input != 1 && input != 2); // 1이나 2가 아닐경우 반복
		if(input == 33) sys.sysEnd();
		return input;
	}
	
	protected int checkEnd() {
		SystemFunc sys = new SystemFunc();
		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt(); // 1이나 2가 아닐경우 반복
			if(input == 33) break;
		} while (input != StaticValue.CONTINUE && input != StaticValue.END && input != StaticValue.ANALYSIS); 
		if(input == 33) sys.sysEnd();
		if(input == StaticValue.ANALYSIS) sys.AnalySys(); // StaticValue.ANALYSIS = 0 일 경우 분석프로그램 전환
		return input;
	}

	protected String inputResidentNum() { // 연령입력
		SystemFunc sys = new SystemFunc();
		System.out.println("  주민번호를 입력하세요. (6자리까지)");

		while (true) {
			System.out.print("\t\t => ");
			line = scanner.next(); // 년도 2자리 + 월 2자리 + 날짜 2자리
			if(line.equals("33")) break;
			try {
				SimpleDateFormat  dateFormat = new  SimpleDateFormat("yyMMdd");
				dateFormat.setLenient(false); // 포맷 확인 엄격하게
				dateFormat.parse(line); // 입력한 날짜, 포멧에 맞는지 확인
			} catch (ParseException  e) { // => 입력한 날짜가 유효하지 않은 경우
				continue;
			}
			break; // 입력한것이 유효해 try-catch 빠져나온경우 -> while stop
		}
		if(line.equals("33")) sys.sysEnd();
		return line;
	}

	protected int ticketsCount() { // 티켓 개수
		SystemFunc sys = new SystemFunc();
		System.out.println("  몇개를 주문하시겠습니까? (최대 10개)");

		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
			if(input == 33) break;
		} while (input > StaticValue.MAX_COUNT || input < StaticValue.MIN_COUNT); // 티켓 주문가능수는 최대 10개
		if(input == 33) sys.sysEnd();
		return input;
	}

	protected int ticketSale(int type) { // 우대사항선택 - 종합이용권이 우대사항 수에 관여하기에 파라미터 입력
		SystemFunc sys = new SystemFunc();
		System.out.println("  우대사항을 선택하세요.");
		System.out.println("\t1. 없음(나이 우대는 자동처리)");
		System.out.println("\t2. 장애인");
		System.out.println("\t3. 국가유공자");
		if (type == 1) { // 해당 우대사항은 종합이용권에만 해당
			System.out.println("\t4. 휴가장병");
			System.out.println("\t5. 임산부");
			System.out.println("\t6. 다둥이행복카드");
			do {
				System.out.print("\t\t => ");
				input = scanner.nextInt();
				if(input == 33) break;
			} while (input < StaticValue.NONE || input > StaticValue.MULTICHILD); // 종합이용권일경우, 우대사항은 6번까지 가능
		} else {
			do {
				System.out.print("\t\t => ");
				input = scanner.nextInt();
				if(input == 33) break;
			} while (input < StaticValue.NONE || input > StaticValue.MERIT); // 파크이용권일경우, 우대사항은 3번까지 가능
		}
		if(input == 33) sys.sysEnd();
		return input;
	}
}