package DataAnalysis;

public final class StaticValue {
	// Ƽ������
	protected static final int ALL_TICKET = 1, PARK_TICKET = 2, ALL_DAY = 1, AFTER4 = 2;
	// Ƽ�ϰ��ɼ�
	protected static final int MIN_COUNT = 1, MAX_COUNT = 10;
	// ���� or not
	protected static final int CONTINUE = 1, END = 2;
	// ���̹����� ���
	protected static final int MIN_BABY = 1, MIN_CHILD = 3, MIN_TEEN = 13, MIN_ADULT = 19;
	protected static final int MAX_CHILD = 12, MAX_TEEN = 18, MAX_ADULT = 64;
	// �����׹�ȣ - ����, ���, ������, �ް��庴, �ӻ��, �ٵ���
	protected static final int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	// ���ɴ�
	protected static final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;
	// ���ڿ� ���� - ������ index = 0�� ���� ""�� �ϴ� ����? ���� ������� ��ȣ�� �� �ǹ��� �ε������� ���߱� ����
	protected static final String[] TICKET_TYPE = {"", "�����̿��", "��ũ�̿��"};
	protected static final String[] TICKET_TIME = {"", "1DAY", "After4"};
	protected static final String[] AGE = {"", "���̺�", "���", "û�ҳ�", "�", "����"};
	protected static final String[] SALE_ADVANTAGE = {"", "��� ����", "�����", "����������", "�ް��庴", "�ӻ��", "�ٵ���"};
}