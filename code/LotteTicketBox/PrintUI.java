package LotteTicketBox;

public class PrintUI { // for print

	protected int ticketTypeAll() { // 종합이용권 or 파크이용권 선택
		System.out.println("  권종을 선택하세요.");
		System.out.println("\t1. 종합이용권\n\t2. 파크이용권");
		InputData idata = new InputData(); 
		return idata.checkTwoChoice(); // 숫자 입력받고 유효 확인
	}

	protected int ticketTypeDay() { // 종일권 or 오후권 선택
		System.out.println("  권종을 선택하세요.");
		System.out.println("\t1. 1DAY\n\t2. After4(오후 4시 이후 입장)");
		InputData idata = new InputData();
		return idata.checkTwoChoice();
	}

	protected void printTickets(int sum) { // 발권 종료후, 발권한 모든 티켓들 출력
		StringBuilder str = new StringBuilder(); // 용량을 적게 차지하기위한 가변성 string
		System.out.println("  티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.println("===========================롯데월드===========================");
		for (OrderData item : Ticketing.orderList) { // forEach구문 사용
			// 종합 or 파크이용권
			if (item.getTicketType() == StaticValue.getAllTicket()) str.append(String.format("%10s", "종합이용권"));
			else if (item.getTicketType() == StaticValue.getParkTicket()) str.append(String.format("%10s", "파크이용권"));
			// 종일권 or 오후권
			if (item.getTicketDay() == StaticValue.getAllDay()) str.append(String.format("%6s", "1DAY"));
			else if (item.getTicketDay() == StaticValue.getAfter4()) str.append(String.format("%6s", "After4"));
			// 연령
			if (item.getAge() == StaticValue.getOld()) { // 노인
				str.append(String.format("%6s", "노인"));
			} else if (item.getAge() == StaticValue.getAdult()) { // 어른
				str.append(String.format("%6s", "어른"));
			} else if (item.getAge() == StaticValue.getTeen()) { // 청소년
				str.append(String.format("%6s", "청소년"));
			} else if (item.getAge() == StaticValue.getChild()) { // 어린이
				str.append(String.format("%6s", "어린이"));
			} else // 유아 - 베이비
				str.append(String.format("%6s", "베이비"));
			// 티켓수, 티켓가격(할인적용)
			str.append(String.format("X%-6d %-10d    ", item.getOrderCount(), item.getPrice()));
			// 우대권 종류
			if (item.getAdventageType() == StaticValue.getNone()) str.append("*우대적용 없음");
			else {
				if (item.getAdventageType() == StaticValue.getDisable()) str.append("*장애인 ");
				else if (item.getAdventageType() == StaticValue.getMerit()) str.append("*국가유공자 ");
				else if (item.getAdventageType() == StaticValue.getVacsold()) str.append("*휴가장병 ");
				else if (item.getAdventageType() == StaticValue.getPregnant()) str.append("*임산부 ");
				else if (item.getAdventageType() == StaticValue.getMultichild()) str.append("*다둥이 ");

				str.append("우대적용");
			}
			System.out.println(str); // console에 출력
			str.setLength(0); // stringbuilder 초기화
		}

		System.out.println("\n\t입장료 총액은 " + sum + "원 입니다."); // sum = totalSum
		System.out.println(" ** 임산부와 다둥이행복카드를 제외한 우대사항은 동반 1인까지 우대가 적용됩니다.");
		System.out.println("==============================================================\n");
	}

	protected int printReapeat(int sum) { // 발권 지속여부
		System.out.println("  가격은 " + sum + " 원 입니다."); // 해당 티켓 총 합 = 티켓발권수 * 가격
		System.out.println("  감사합니다.\n");

		System.out.println("  계속 발권 하시겠습니까?"); // 추가 발권여부 질문
		System.out.println("\t1. 티켓발권\n\t2. 종료");

		InputData idata = new InputData();
		return idata.checkTwoChoice();
	}

	protected int inputEnd() { // 프로그램 진행 or 새 주문
		System.out.println("  계속 진행(1: 새로운 주문, 2: 프로그램 종료) : "); // 해당 프로그램 종료여부
		InputData idata = new InputData();
		return idata.checkTwoChoice();
	}
}