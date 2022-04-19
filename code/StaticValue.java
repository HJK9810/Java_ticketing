package LotteTicketBox;

public final class StaticValue { // �����
	// ���̹����� ���
	final static int MIN_BABY = 1, MIN_CHILD = 3, MIN_TEEN = 13, MIN_ADULT = 19; 
	final static int MAX_CHILD = 12, MAX_TEEN = 18, MAX_ADULT = 64;
	// �����׹�ȣ -  ����, ���, ������, �ް��庴, �ӻ��, �ٵ���
	final static int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	// ���ɴ�
	final static int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;	
	
	// �� ���ɺ� Ƽ�ϰ� -> ����-����, ����-����, ��ũ-����, ��ũ-����
	final static int[] ADULT_FEE = { 62000, 50000, 59000, 47000 };
	final static int[] TEEN_FEE = { 54000, 43000, 52000, 41000 };
	final static int[] CHILD_FEE = { 47000, 36000, 46000, 35000 };
	final static int BABY_FEE = 15000;
	// ������ ���η� - �� �ε��� == ������ ��ȣ
	final static float[] percent = { 0f, 1f, 0.5f, 0.5f, 0.51f, 0.5f, 0.7f }; 
}