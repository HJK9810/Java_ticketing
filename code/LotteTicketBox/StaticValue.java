package LotteTicketBox;

public final class StaticValue { // 상수용
	// 티켓종류
	private static final int ALL_TICKET = 1, PARK_TICKET = 2, ALL_DAY = 1, AFTER4 = 2;
	// 티켓가능수
	private static final int MIN_COUNT = 1, MAX_COUNT = 10;
	// 지속 or not
	private static final int CONTINUE = 1, END = 2;	
	// 나이범위용 상수
	private static final int MIN_BABY = 1, MIN_CHILD = 3, MIN_TEEN = 13, MIN_ADULT = 19; 
	private static final int MAX_CHILD = 12, MAX_TEEN = 18, MAX_ADULT = 64;
	// 우대사항번호 -  없음, 장애, 유공자, 휴가장병, 임산부, 다둥이
	private static final int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	// 연령대
	private static final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;	
	
	// 각 연령별 티켓값 -> 종합-종일, 종합-오후, 파크-종일, 파크-오후
	private static final int[] ADULT_FEE = { 62000, 50000, 59000, 47000 };
	private static final int[] TEEN_FEE = { 54000, 43000, 52000, 41000 };
	private static final int[] CHILD_FEE = { 47000, 36000, 46000, 35000 };
	private static final int BABY_FEE = 15000;
	// 각각의 할인률 - 각 인덱스 == 우대사항 번호
	private static final float[] percent = { 0f, 1f, 0.5f, 0.5f, 0.51f, 0.5f, 0.7f };
	
	// 상수들에 대한 getter함수
	// 티켓종류
	public static int getAllTicket() {
		return ALL_TICKET;
	}
	public static int getParkTicket() {
		return PARK_TICKET;
	}
	public static int getAllDay() {
		return ALL_DAY;
	}
	public static int getAfter4() {
		return AFTER4;
	}
	// 티켓가능수
	public static int getMinCount() {
		return MIN_COUNT;
	}
	public static int getMaxCount() {
		return MAX_COUNT;
	}
	// 지속 or not
	public static int getContinue() {
		return CONTINUE;
	}
	public static int getEnd() {
		return END;
	}
	// 나이범위용 상수
	public static int getMinBaby() {
		return MIN_BABY;
	}
	public static int getMinChild() {
		return MIN_CHILD;
	}
	public static int getMinTeen() {
		return MIN_TEEN;
	}
	public static int getMinAdult() {
		return MIN_ADULT;
	}
	public static int getMaxChild() {
		return MAX_CHILD;
	}
	public static int getMaxTeen() {
		return MAX_TEEN;
	}
	public static int getMaxAdult() {
		return MAX_ADULT;
	}
	// 우대사항번호 -  없음, 장애, 유공자, 휴가장병, 임산부, 다둥이
	public static int getNone() {
		return NONE;
	}
	public static int getDisable() {
		return DISABLE;
	}
	public static int getMerit() {
		return MERIT;
	}
	public static int getVacsold() {
		return VACSOLD;
	}
	public static int getPregnant() {
		return PREGNANT;
	}
	public static int getMultichild() {
		return MULTICHILD;
	}
	// 연령대
	public static int getBaby() {
		return BABY;
	}
	public static int getChild() {
		return CHILD;
	}
	public static int getTeen() {
		return TEEN;
	}
	public static int getAdult() {
		return ADULT;
	}
	public static int getOld() {
		return OLD;
	}
	// 각 연령별 티켓값
	public static int[] getAdultFee() {
		return ADULT_FEE;
	}
	public static int[] getTeenFee() {
		return TEEN_FEE;
	}
	public static int[] getChildFee() {
		return CHILD_FEE;
	}
	public static int getBabyFee() {
		return BABY_FEE;
	}
	// 할인율
	public static float[] getPercent() {
		return percent;
	}
}