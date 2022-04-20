package LotteTicketBox;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SaveVals { // save & make csv files
	protected static ArrayList<OrderData> orderList = new ArrayList<>(); // 티켓발권용 배열
	
	protected void saveOrder(OrderData orderItem) {
		orderList.add(orderItem); // arraylist에 해당 값들 input
	}

	protected void inputFile() { // 파일에 입력한 값들 이어쓰기
		SimpleDateFormat dateformat = new SimpleDateFormat("YYYYMMdd"); // 날짜 폼 지정
		Date date = new Date();
		String today = dateformat.format(date); // 오늘날짜
		try {
			FileWriter fw = new FileWriter("C:\\javatest\\ticketing\\report.csv", true);
			StringBuilder str = new StringBuilder(); // 용량을 적게 차지하기위한 가변성 string
			for (OrderData item : orderList) { // forEach 사용
				str.append(today + ","); // 오늘날짜 입력
				// 이용권
				if (item.getTicketType() == StaticValue.ALL_TICKET) str.append(String.format("%-7s,", "종합이용권"));
				else if (item.getTicketType() == StaticValue.PARK_TICKET) str.append(String.format("%-7s,", "파크이용권"));
				// 권종
				if (item.getTicketDay() == StaticValue.ALL_DAY) str.append(String.format("%-6s,", "1DAY"));
				else if (item.getTicketDay() == StaticValue.AFTER4) str.append(String.format("%-6s,", "After4"));
				// 연령
				if (item.getAge() == StaticValue.OLD) str.append(String.format("%-4s,", "노인"));
				else if (item.getAge() == StaticValue.ADULT) str.append(String.format("%-4s,", "어른")); // 어른
				else if (item.getAge() == StaticValue.TEEN) str.append(String.format("%-4s,", "청소년")); // 청소년
				else if (item.getAge() == StaticValue.CHILD) str.append(String.format("%-4s,", "어린이")); // 어린이
				else str.append(String.format("%-4s,", "베이비"));
				// 수량 & 가격
				str.append(String.format("%d,%d,", item.getOrderCount(), item.getSum()));
				// 우대사항
				if (item.getAdventageType() == StaticValue.NONE) str.append("없음\n");
				else if (item.getAdventageType() == StaticValue.DISABLE) str.append("장애인\n");
				else if (item.getAdventageType() == StaticValue.MERIT) str.append("국가유공자\n");
				else if (item.getAdventageType() == StaticValue.VACSOLD) str.append("휴가장병\n");
				else if (item.getAdventageType() == StaticValue.PREGNANT) str.append("임산부\n");
				else if (item.getAdventageType() == StaticValue.MULTICHILD) str.append("다둥이\n");
				
				fw.write(str.toString()); // 해당 문장 string전환 & 파일 입력
				str.setLength(0); // stringbuilder 초기화
			}

			fw.close(); // 파일닫기
		} catch (IOException e) { // 파일읽고 쓰는동안의 에러체크용
			e.printStackTrace();
		}
	}
}