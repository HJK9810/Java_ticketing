package DataAnalysis;

import java.util.Arrays;

public class SetArg {
	protected int[] SetFileArgus(String[] ary) {
		int[] list = new int[7];
		
		list[0] = Integer.parseInt(ary[0]); // 날짜
		list[4] = Integer.parseInt(ary[4]); // 수량
		list[5] = Integer.parseInt(ary[5]); // 가격
		/**
		 * 해당 배열의 index를 찾기위해 - 1. arraylist 변환
		 * 해당 배열의 index를 찾기위해 - 2. indexOf로 찾기
		 * index를 찾는 이유? 해당 배열의 문자 == 입력받은 문자열, 해당 인덱스값 == 일치하는 상수값
		 */
		// 이용권
		list[1] = Arrays.asList(StaticValue.TICKET_TYPE).indexOf(ary[1]); 
		// 권종
		list[2] = Arrays.asList(StaticValue.TICKET_TIME).indexOf(ary[2]);
		// 연령
		list[3] = Arrays.asList(StaticValue.AGE).indexOf(ary[3]);
		if(list[3] == -1) list[3] = StaticValue.BABY;
		// 우대사항
		list[6] = Arrays.asList(StaticValue.SALE_ADVANTAGE).indexOf(ary[6]);
		if(list[6] == -1) list[6] = StaticValue.NONE;
		
		return list;
	}
}