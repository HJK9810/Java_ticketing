package DataAnalysis;

import java.util.Arrays;

public class SetArg {
	protected int[] SetFileArgus(String[] ary) {
		int[] list = new int[7];
		
		list[0] = Integer.parseInt(ary[0]); // 날짜
		list[4] = Integer.parseInt(ary[4]); // 수량
		list[5] = Integer.parseInt(ary[5]); // 가격
		// 이용권
		String ticket = ary[1].trim();
		list[1] = Arrays.asList(StaticValue.TICKET_TYPE).indexOf(ticket);
		// 권종
		String time = ary[2].trim();
		list[2] = Arrays.asList(StaticValue.TICKET_TIME).indexOf(time);
		// 연령
		String age = ary[3].trim();
		list[3] = Arrays.asList(StaticValue.AGE).indexOf(age);
		if(list[3] == -1) list[3] = StaticValue.BABY;
		// 우대사항
		String type = ary[6].trim();
		list[6] = Arrays.asList(StaticValue.SALE_ADVANTAGE).indexOf(type);
		if(list[6] == -1) list[6] = StaticValue.NONE;
		
		return list;
	}
}