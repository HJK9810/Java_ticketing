package DataAnalysis;

public final class StaticValue {
	// 파일 경로
	protected static final String PATH = "C:\\javatest\\ticketing\\";
	// 우대사항번호 - 없음, 장애, 유공자, 휴가장병, 임산부, 다둥이
	protected static final int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	// 연령대
	protected static final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;
	// 문자열 집합 - 각각이 index = 0의 값을 ""로 하는 이유? 위의 상수들의 번호에 각 의미의 인덱스값을 맞추기 위해
	protected static final String[] TICKET_TYPE = {"", "종합이용권", "파크이용권"};
	protected static final String[] TICKET_TIME = {"", "1DAY", "After4"};
	protected static final String[] AGE = {"", "베이비", "어린이", "청소년", "어른", "노인"};
	protected static final String[] SALE_ADVANTAGE = {"", "우대 없음", "장애인", "국가유공자", "휴가장병", "임산부", "다둥이"};
}