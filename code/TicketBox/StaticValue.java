package TicketBox;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class StaticValue { // 상수용
	// 파일 경로
	protected static final String PATH = "C:\\javatest\\ticketing\\";

	// 티켓종류
	protected static final int ALL_TICKET = 1, PARK_TICKET = 2, ALL_DAY = 1, AFTER4 = 2;
	// 티켓가능수
	protected static final int MIN_COUNT = 1, MAX_COUNT = 10;
	// 지속 or not
	protected static final int CONTINUE = 1, END = 2, ANALYSIS = 0;
	// 나이범위용 상수
	protected static final int MIN_BABY = 1, MIN_CHILD = 3, MIN_TEEN = 13, MIN_ADULT = 19;
	protected static final int MAX_CHILD = 12, MAX_TEEN = 18, MAX_ADULT = 64;
	// 우대사항번호 - 없음, 장애, 유공자, 휴가장병, 임산부, 다둥이
	protected static final int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	// 연령대
	protected static final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;

	// 각 연령별 티켓값 -> 종합-종일, 종합-오후, 파크-종일, 파크-오후
	protected static final int[] ADULT_FEE = { 62000, 50000, 59000, 47000 };
	protected static final int[] TEEN_FEE = { 54000, 43000, 52000, 41000 };
	protected static final int[] CHILD_FEE = { 47000, 36000, 46000, 35000 };
	protected static final int BABY_FEE = 15000;
	// 각각의 할인률 - 각 인덱스 == 우대사항 번호
	protected static final float[] percent = { 0f, 1f, 0.5f, 0.5f, 0.51f, 0.5f, 0.7f };

	// 문자열 집합 - 각각이 index = 0의 값을 ""로 하는 이유? 위의 상수들의 번호에 각 의미의 인덱스값을 맞추기 위해
	protected static final String[] TICKET_TYPE = { "", "종합이용권", "파크이용권" };
	protected static final String[] TICKET_TIME = { "", "1DAY", "After4" };
	protected static final String[] AGE = { "", "베이비", "어린이", "청소년", "어른", "노인" };
	protected static final String[] SALE_ADVANTAGE = { "", "우대 없음", "장애인", "국가유공자", "휴가장병", "임산부", "다둥이" };
	
	private static String today;

	public static final String getToday() {
		SimpleDateFormat dateformat = new SimpleDateFormat("YYYYMMdd"); // 날짜 폼 지정
		Date date = new Date();
		today = dateformat.format(date); // 오늘날짜
		return today;
	}
}