package LotteTicketBox;

import java.util.Scanner;

public class InputData { // for inputs
	Scanner scanner = new Scanner(System.in);

	protected int checkTwoChoice() {
		int input;
		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
		} while (input != 1 && input != 2);
		return input;
	}

	protected int inputResidentNum() { // 연령입력
		int input;
		System.out.println("  주민번호를 입력하세요. (6자리까지)");

		while (true) {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
			int year = input / 10000;
			int month = input % 10000 / 100;
			int day = input % 100;

			if (year < 100 && (month < 13 && month > 0) && (day < 32 && day > 0)) break;
		}
		return input;
	}

	protected int ticketsCount() { // 티켓 개수
		int input;
		System.out.println("  몇개를 주문하시겠습니까? (최대 10개)");

		do {
			System.out.print("\t\t => ");
			input = scanner.nextInt();
		} while (input > 11 || input < 1);
		return input;
	}

	protected int ticketSale(int type) { // 우대사항선택
		int input;
		System.out.println("  우대사항을 선택하세요.");
		System.out.println("\t1. 없음(나이 우대는 자동처리)");
		System.out.println("\t2. 장애인");
		System.out.println("\t3. 국가유공자");
		if (type == 1) { // 해당 우대사항은 종일권에만 해당
			System.out.println("\t4. 휴가장병");
			System.out.println("\t5. 임산부");
			System.out.println("\t6. 다둥이행복카드");
			do {
				System.out.print("\t\t => ");
				input = scanner.nextInt();
			} while (input < 1 || input > 6);
		} else {
			do {
				System.out.print("\t\t => ");
				input = scanner.nextInt();
			} while (input < 1 || input > 3);
		}

		return input;
	}
}