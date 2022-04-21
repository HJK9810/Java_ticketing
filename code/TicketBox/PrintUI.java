package TicketBox;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PrintUI { // for print
	InputData idata = new InputData();
	DecimalFormat df = new DecimalFormat("###,###,###"); // 가격용 , 구분
	
	protected void PrintAnalysisAll() { // 분석 UI 모두 출력
		CheckTickets check = new CheckTickets();
		PrintUI pui = new PrintUI();
		SaveVals save = new SaveVals(); // 데이터 저장 & 파일 저장용
		
		check.TicketsAnalysis(); // 데이터 분류 & 분석
		pui.PrintCSV(); // csv 파일 전체 출력
		pui.PrintTicketType(); // 권종별 판매현황 출력
		pui.PrintDaysSum(); // 일자별 매출 현황 출력
		pui.PrintSaleType(); // 우대권 판매현황 출력
		
		save.InputCSVs(); // 모든 데이터 개별 파일에 저장
	}

	protected int ticketTypeAll() { // 종합이용권 or 파크이용권 선택
		System.out.println("  권종을 선택하세요.");
		System.out.println("\t1. 종합이용권\n\t2. 파크이용권"); 
		return idata.checkTwoChoice(); // 숫자 입력받고 유효 확인
	}

	protected int ticketTypeDay() { // 종일권 or 오후권 선택
		System.out.println("  권종을 선택하세요.");
		System.out.println("\t1. 1DAY\n\t2. After4(오후 4시 이후 입장)");
		return idata.checkTwoChoice();
	}

	protected void printTickets(int sum) { // 발권 종료후, 발권한 모든 티켓들 출력
		StringBuilder str = new StringBuilder(); // 용량을 적게 차지하기위한 가변성 string
		System.out.println("  티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.println("===========================롯데월드===========================");
		for (OrderData item : SaveVals.orderList) { // forEach구문 사용
			// 종합 or 파크이용권
			if (item.getTicketType() == StaticValue.ALL_TICKET) str.append(String.format("%10s", "종합이용권"));
			else if (item.getTicketType() == StaticValue.PARK_TICKET) str.append(String.format("%10s", "파크이용권"));
			// 종일권 or 오후권
			if (item.getTicketDay() == StaticValue.ALL_DAY) str.append(String.format("%8s", "1DAY"));
			else if (item.getTicketDay() == StaticValue.AFTER4) str.append(String.format("%8s", "After4"));
			// 연령
			if (item.getAge() == StaticValue.OLD) { // 노인
				str.append(String.format("%6s", "노인"));
			} else if (item.getAge() == StaticValue.ADULT) { // 어른
				str.append(String.format("%6s", "어른"));
			} else if (item.getAge() == StaticValue.TEEN) { // 청소년
				str.append(String.format("%6s", "청소년"));
			} else if (item.getAge() == StaticValue.CHILD) { // 어린이
				str.append(String.format("%6s", "어린이"));
			} else // 유아 - 베이비
				str.append(String.format("%6s", "베이비"));
			// 티켓수, 티켓가격(할인적용)
			str.append(String.format("X%-6d %-10d    ", item.getOrderCount(), item.getPrice()));
			// 우대권 종류
			if (item.getAdventageType() == StaticValue.NONE) str.append("*우대적용 없음");
			else {
				if (item.getAdventageType() == StaticValue.DISABLE) str.append("*장애인 ");
				else if (item.getAdventageType() == StaticValue.MERIT) str.append("*국가유공자 ");
				else if (item.getAdventageType() == StaticValue.VACSOLD) str.append("*휴가장병 ");
				else if (item.getAdventageType() == StaticValue.PREGNANT) str.append("*임산부 ");
				else if (item.getAdventageType() == StaticValue.MULTICHILD) str.append("*다둥이 ");

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

		return idata.checkTwoChoice();
	}

	protected int inputEnd() { // 프로그램 진행 or 새 주문
		System.out.println("  계속 진행(1: 새로운 주문, 2: 프로그램 종료) : "); // 해당 프로그램 종료여부
		return idata.checkTwoChoice();
	}
	
	protected void PrintCSV() {
		String[] ary = SystemFunc.category;
		
		System.out.println("================= report.csv =================");
		System.out.printf("%7s%5s%4s%5s%4s%8s%4s\n", ary[0], ary[1], ary[2], ary[3], ary[4], ary[5], ary[6]);
		
		StringBuilder str = new StringBuilder();
		for(int[] line : SystemFunc.orderList) {
			str.append(String.format("%8d", line[0]));
			str.append(String.format("%6d", line[1]));
			str.append(String.format("%4d", line[2]));
			str.append(String.format("%6d", line[3]));
			str.append(String.format("%6d", line[4]));
			str.append(String.format("%9s", df.format(line[5])));
			str.append(String.format("%6d", line[6]));
			System.out.println(str);
			
			str.setLength(0);
		}
		System.out.println("----------------------------------------------\n");
	}
	
	protected void PrintTicketType() {
		int[][] tickets = CheckTickets.ticketType;
		System.out.println("======================= 권종 별 판매현황 =======================");
		for(int idx = 0; idx < tickets.length; idx++) {
			int checkType = idx % 2 + 1;
			int lastIdx = tickets[idx].length - 1;
			if(checkType == 1) System.out.printf("%s 총 %d매\n", StaticValue.TICKET_TYPE[idx / 2 + 1], tickets[idx][0] + tickets[idx + 1][0]);
			
			for(int jdx = 0; jdx < lastIdx; jdx++) {
				if(jdx == 0) {
					System.out.printf("\t%s 총 %d매\n", StaticValue.TICKET_TIME[checkType], tickets[idx][0]);
					continue;
				} else if(jdx == 1) System.out.print("\t\t");
				
				System.out.printf("%s %d매", StaticValue.AGE[jdx], tickets[idx][jdx]);
				if(jdx == lastIdx - 1) System.out.println();
				else System.out.print(", ");
			}
			System.out.printf(" => %s 총매출 %s원\n\n", StaticValue.TICKET_TIME[checkType], df.format(tickets[idx][lastIdx]));
			
			if(checkType == 2) System.out.printf(" ==>> %s 총 매출 %s원\n\n", StaticValue.TICKET_TYPE[idx / 2 + 1], df.format(tickets[idx - 1][lastIdx] + tickets[idx][lastIdx]));
		}
		System.out.println("------------------------------------------------------------\n");
	}
	
	protected void PrintDaysSum() {
		ArrayList<String> perDates = CheckTickets.pricePerDate;
		System.out.println("============= 일자별 매출 현황 =============");
		for(String line : perDates) {
			String[] ary = line.split("-");
			System.out.printf("%s년 %s월 %s일 : ", ary[0].substring(0, 4), ary[0].substring(4, 6), ary[0].substring(6));
			System.out.printf("총 매출 %14s원\n", df.format(Integer.parseInt(ary[1])));
		}
		
		System.out.println("----------------------------------------\n");
	}
	
	protected void PrintSaleType() {
		int[] tickets = CheckTickets.perAdvant;
		System.out.println("====== 우대권 판매 현황 ======");
		for(int idx = 0; idx < tickets.length; idx++) {
			if(idx == 0) System.out.printf("%s\t:%6d매\n", "총 판매 티켓수", tickets[0]);
			else System.out.printf("%s\t\t:%6d매\n", StaticValue.SALE_ADVANTAGE[idx], tickets[idx]);
		}
		System.out.println("--------------------------\n");
	}
}