package LotteTicketBox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class InputData { // for inputs
	Scanner scanner = new Scanner(System.in); // 해당 클래스의 모든 함수가 사용함으로 여기에 정의

	protected int checkTwoChoice() { // 2개중 하나를 선택하는 경우
		int input;
		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
		} while (input != 1 && input != 2); // 1이나 2가 아닐경우 반복
		return input;
	}

	protected String inputResidentNum() { // 연령입력
		String input;
		System.out.println("  주민번호를 입력하세요. (6자리까지)");

		while (true) {
			System.out.print("\t\t => ");
			input = scanner.next(); // 년도 2자리 + 월 2자리 + 날짜 2자리
			try {
				SimpleDateFormat  dateFormat = new  SimpleDateFormat("yyMMdd");
				dateFormat.setLenient(false); // 포맷 확인 엄격하게
				dateFormat.parse(input); // 입력한 날짜, 포멧에 맞는지 확인
			} catch (ParseException  e) { // => 입력한 날짜가 유효하지 않은 경우
				continue;
			}
			break; // 입력한것이 유효해 try-catch 빠져나온경우 -> while stop
		}
		return input;
	}

	protected int ticketsCount() { // 티켓 개수
		int input;
		System.out.println("  몇개를 주문하시겠습니까? (최대 10개)");

		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
		} while (input > StaticValue.MAX_COUNT || input < StaticValue.MIN_COUNT); // 티켓 주문가능수는 최대 10개
		return input;
	}

	protected int ticketSale(int type) { // 우대사항선택 - 종합이용권이 우대사항 수에 관여하기에 파라미터 입력
		int input;
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
			} while (input < StaticValue.NONE || input > StaticValue.MULTICHILD); // 종합이용권일경우, 우대사항은 6번까지 가능
		} else {
			do {
				System.out.print("\t\t => ");
				input = scanner.nextInt();
			} while (input < StaticValue.NONE || input > StaticValue.MERIT); // 파크이용권일경우, 우대사항은 3번까지 가능
		}

		return input;
	}
	
	protected void ticketingSystem() { // main 에서 돌아갈 메인 시스템 함수
		CalTickets calc = new CalTickets(); // 주 반복함수가 들어있는 class 선언

		int isExit = 0; // 프로그램 종료를 위한 확인변수

		do { // main 간략화
			isExit = calc.repeatFunc(); // 반복용 while 함수분리
			Ticketing.orderList = new ArrayList<>(); // 해당 배열 초기화
		} while (isExit == 1); // if isExit == 2 => program end
	}
}