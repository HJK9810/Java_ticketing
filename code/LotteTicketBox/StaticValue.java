package LotteTicketBox;

public final class StaticValue { // �����
	// Ƽ������
	private static final int ALL_TICKET = 1, PARK_TICKET = 2, ALL_DAY = 1, AFTER4 = 2;
	// Ƽ�ϰ��ɼ�
	private static final int MIN_COUNT = 1, MAX_COUNT = 10;
	// ���� or not
	private static final int CONTINUE = 1, END = 2;	
	// ���̹����� ���
	private static final int MIN_BABY = 1, MIN_CHILD = 3, MIN_TEEN = 13, MIN_ADULT = 19; 
	private static final int MAX_CHILD = 12, MAX_TEEN = 18, MAX_ADULT = 64;
	// �����׹�ȣ -  ����, ���, ������, �ް��庴, �ӻ��, �ٵ���
	private static final int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	// ���ɴ�
	private static final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;	
	
	// �� ���ɺ� Ƽ�ϰ� -> ����-����, ����-����, ��ũ-����, ��ũ-����
	private static final int[] ADULT_FEE = { 62000, 50000, 59000, 47000 };
	private static final int[] TEEN_FEE = { 54000, 43000, 52000, 41000 };
	private static final int[] CHILD_FEE = { 47000, 36000, 46000, 35000 };
	private static final int BABY_FEE = 15000;
	// ������ ���η� - �� �ε��� == ������ ��ȣ
	private static final float[] percent = { 0f, 1f, 0.5f, 0.5f, 0.51f, 0.5f, 0.7f };
	
	// ����鿡 ���� getter�Լ�
	// Ƽ������
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
	// Ƽ�ϰ��ɼ�
	public static int getMinCount() {
		return MIN_COUNT;
	}
	public static int getMaxCount() {
		return MAX_COUNT;
	}
	// ���� or not
	public static int getContinue() {
		return CONTINUE;
	}
	public static int getEnd() {
		return END;
	}
	// ���̹����� ���
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
	// �����׹�ȣ -  ����, ���, ������, �ް��庴, �ӻ��, �ٵ���
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
	// ���ɴ�
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
	// �� ���ɺ� Ƽ�ϰ�
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
	// ������
	public static float[] getPercent() {
		return percent;
	}
}