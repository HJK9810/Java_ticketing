package LotteTicketBox;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveVals { // save & make csv files
	
	protected int saveOrder(int all, int day, int age, int count, int price, int sales, int lastline) {
		Ticketing.orderList[lastline][0] = all;
		Ticketing.orderList[lastline][1] = day;
		Ticketing.orderList[lastline][2] = age;
		Ticketing.orderList[lastline][3] = count;
		Ticketing.orderList[lastline][4] = price;
		Ticketing.orderList[lastline][5] = sales;
		return ++lastline;
	}

	protected void inputFile(int lastline) {
		SimpleDateFormat dateformat = new SimpleDateFormat("YYYYMMdd");
		Date date = new Date();
		String today = dateformat.format(date); // 오늘날짜
		try {
			FileWriter fw = new FileWriter("C:\\Users\\A_013\\Documents\\C코드\\ticketing\\report.csv", true);
			StringBuilder str = new StringBuilder(); // 용량을 적게 차지하기위한 가변성 string
			for (int idx = 0; idx < lastline; idx++) {
				int[] list = Ticketing.orderList[idx]; // 일일히 접속하지 않기 위해 배열 재정의
				int typeAll = list[0];
				int typeDay = list[1];
				int age = list[2];
				int count = list[3];
				int price = list[4];
				int sales = list[5];

				str.append(today + ","); // 오늘날짜 입력
				// 이용권
				if (typeAll == 1) str.append(String.format("%-7s,", "종합이용권"));
				else if (typeAll == 2) str.append(String.format("%-7s,", "파크이용권"));
				// 권종
				if (typeDay == 1) str.append(String.format("%-6s,", "1DAY"));
				else if (typeDay == 2) str.append(String.format("%-6s,", "After4"));
				// 연령
				if (age == Ticketing.OLD) str.append(String.format("%-4s,", "노인"));
				else if (age == Ticketing.ADULT) str.append(String.format("%-4s,", "어른")); // 어른
				else if (age == Ticketing.TEEN) str.append(String.format("%-4s,", "청소년")); // 청소년
				else if (age == Ticketing.CHILD) str.append(String.format("%-4s,", "어린이")); // 어린이
				else str.append(String.format("%-4s,", "베이비"));
				// 수량 & 가격
				str.append(String.format("%d,%d,", count, price));
				// 우대사항
				if (sales == Ticketing.NONE) str.append("없음\n");
				else if (sales == Ticketing.DISABLE) str.append("장애인\n");
				else if (sales == Ticketing.MERIT) str.append("국가유공자\n");
				else if (sales == Ticketing.VACSOLD) str.append("휴가장병\n");
				else if (sales == Ticketing.PREGNANT) str.append("임산부\n");
				else if (sales == Ticketing.MULTICHILD) str.append("다둥이\n");
				
				fw.write(str.toString()); // 해당 문장 string전환 & 파일 입력
				str.setLength(0); // stringbuilder 초기화
			}

			fw.close(); // 파일닫기
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}