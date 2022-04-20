package LotteTicketBox;

public final class StaticValue { // �����
	// Ƽ������
	protected static final int ALL_TICKET = 1, PARK_TICKET = 2, ALL_DAY = 1, AFTER4 = 2;
	// Ƽ�ϰ��ɼ�
	protected static final int MIN_COUNT = 1, MAX_COUNT = 10;
	// ���� or not
	protected static final int CONTINUE = 1, END = 2;	
	// ���̹����� ���
	protected static final int MIN_BABY = 1, MIN_CHILD = 3, MIN_TEEN = 13, MIN_ADULT = 19; 
	protected static final int MAX_CHILD = 12, MAX_TEEN = 18, MAX_ADULT = 64;
	// �����׹�ȣ -  ����, ���, ������, �ް��庴, �ӻ��, �ٵ���
	protected static final int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	// ���ɴ�
	protected static final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;	
	
	// �� ���ɺ� Ƽ�ϰ� -> ����-����, ����-����, ��ũ-����, ��ũ-����
	protected static final int[] ADULT_FEE = { 62000, 50000, 59000, 47000 };
	protected static final int[] TEEN_FEE = { 54000, 43000, 52000, 41000 };
	protected static final int[] CHILD_FEE = { 47000, 36000, 46000, 35000 };
	protected static final int BABY_FEE = 15000;
	// ������ ���η� - �� �ε��� == ������ ��ȣ
	protected static final float[] percent = { 0f, 1f, 0.5f, 0.5f, 0.51f, 0.5f, 0.7f };
}