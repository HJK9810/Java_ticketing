package DataAnalysis;

public final class StaticValue {
	// ���� ���
	protected static final String PATH = "C:\\javatest\\ticketing\\";
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