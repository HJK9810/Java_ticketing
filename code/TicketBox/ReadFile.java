package TicketBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadFile {
	protected void ReadCSV() {
		try {
            BufferedReader br = new BufferedReader(new FileReader(StaticValue.PATH + "report.csv"));
            String line = br.readLine(); // 첫줄은 모두 문자열인 카테고리이기에
            SystemFunc.category = line.split(",");
            while ((line = br.readLine()) != null) {
            	String[] ary = line.replace(" ", "").split(","); // 공백제거후, 분리
            	int[] list = new int[7];
            	// 숫자부분은 String to int 방식으로 입력
            	list[0] = Integer.parseInt(ary[0]); // 날짜
        		list[4] = Integer.parseInt(ary[4]); // 수량
        		list[5] = Integer.parseInt(ary[5]); // 가격
        		/**
        		 * 해당 배열의 index를 찾기위해
        		 * 1. arraylist 변환
        		 * 2. indexOf로 찾기
        		 * index를 찾는 이유? 
        		 * 해당 배열의 문자 == 입력받은 문자열, 해당 인덱스값 == 일치하는 상수값
        		 * => 각 입력값에 해당하는 문자열들을 상수 배열로 묶어논 상태
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
            	
        		SystemFunc.orderList.add(list); 
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}