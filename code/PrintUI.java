package LotteTicketBox;

public class PrintUI { // for print

	protected int ticketTypeAll() { // 종합이용권 or 파크이용권 선택
		System.out.println("  권종을 선택하세요.");
		System.out.println("\t1. 종합이용권\n\t2. 파크이용권");
		InputData idata = new InputData();
		return idata.checkTwoChoice();
	}

	protected int ticketTypeDay() { // 종일권 or 오후권 선택
		System.out.println("  권종을 선택하세요.");
		System.out.println("\t1. 1DAY\n\t2. After4(오후 4시 이후 입장)");
		InputData idata = new InputData();
		return idata.checkTwoChoice();
	}

	protected void printTickets(int sum, int lastline) { // 발권 종료후, 발권한 모든 티켓들 출력
		System.out.println("  티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.println("===========================롯데월드===========================");
		int[][] orderlist = Ticketing.orderList; // 계속 왔다갔다 방지를 위한 배열 재정의
		for (int idx = 0; idx < lastline; idx++) {
			int[] line = orderlist[idx];
			int typeAll = line[0];
			int typeDay = line[1];
			int age = line[2];
			int count = line[3];
			int price = line[4];
			int sales = line[5];
			// 종합 or 파크이용권
			if (typeAll == 1) System.out.printf("%10s ", "종합이용권");
			else if (typeAll == 2) System.out.printf("%10s ", "파크이용권");
			// 종일권 or 오후권
			if (typeDay == 1) System.out.printf("%6s ", "1DAY");
			else if (typeDay == 2) System.out.printf("%6s ", "After4");
			// 연령
			if (age == Ticketing.OLD) {
				System.out.printf("%6s ", "노인");
			} else if (age == Ticketing.ADULT) { // 어른
				System.out.printf("%6s ", "어른");
			} else if (age == Ticketing.TEEN) { // 청소년
				System.out.printf("%6s ", "청소년");
			} else if (age == Ticketing.CHILD) { // 어린이
				System.out.printf("%6s ", "어린이");
			} else
				System.out.printf("%6s ", "베이비");
			// 티켓수, 티켓가격(할인적용)
			System.out.printf("X%-6d %-10d    ", count, price);
			// 우대권 종류
			if (sales == Ticketing.NONE) System.out.printf("*우대적용 없음\n");
			else {
				if (sales == Ticketing.DISABLE) System.out.printf("*장애인 ");
				else if (sales == Ticketing.MERIT) System.out.printf("*국가유공자 ");
				else if (sales == Ticketing.VACSOLD) System.out.printf("*휴가장병 ");
				else if (sales == Ticketing.PREGNANT) System.out.printf("*임산부 ");
				else if (sales == Ticketing.MULTICHILD) System.out.printf("*다둥이 ");

				System.out.printf("우대적용\n");
			}
		}

		System.out.println("\n\t입장료 총액은 " + sum + "원 입니다.");
		System.out.println(" ** 임산부와 다둥이행복카드를 제외한 우대사항은 동반 1인까지 우대가 적용됩니다.");
		System.out.println("==============================================================\n");
	}

	protected int printReapeat(int sum) { // 발권 지속여부
		System.out.println("  가격은 " + sum + " 원 입니다.");
		System.out.println("  감사합니다.\n");

		System.out.println("  계속 발권 하시겠습니까?");
		System.out.println("\t1. 티켓발권\n\t2. 종료");

		InputData idata = new InputData();
		return idata.checkTwoChoice();
	}

	protected int inputEnd() { // 프로그램 진행 or 새 주문
		System.out.println("  계속 진행(1: 새로운 주문, 2: 프로그램 종료) : ");
		InputData idata = new InputData();
		return idata.checkTwoChoice();
	}
}