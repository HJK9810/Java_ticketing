package LotteTicketBox;

public final class StaticValue { // 상수용
	// 나이범위용 상수
	final static int MIN_BABY = 1, MIN_CHILD = 3, MIN_TEEN = 13, MIN_ADULT = 19; 
	final static int MAX_CHILD = 12, MAX_TEEN = 18, MAX_ADULT = 64;
	// 우대사항번호 -  없음, 장애, 유공자, 휴가장병, 임산부, 다둥이
	final static int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	// 연령대
	final static int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;	
	
	// 각 연령별 티켓값 -> 종합-종일, 종합-오후, 파크-종일, 파크-오후
	final static int[] ADULT_FEE = { 62000, 50000, 59000, 47000 };
	final static int[] TEEN_FEE = { 54000, 43000, 52000, 41000 };
	final static int[] CHILD_FEE = { 47000, 36000, 46000, 35000 };
	final static int BABY_FEE = 15000;
	// 각각의 할인률 - 각 인덱스 == 우대사항 번호
	final static float[] percent = { 0f, 1f, 0.5f, 0.5f, 0.51f, 0.5f, 0.7f }; 
}