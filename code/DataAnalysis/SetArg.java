package DataAnalysis;

import java.util.Arrays;

public class SetArg {
	protected int[] SetFileArgus(String[] ary) {
		int[] list = new int[7];
		
		list[0] = Integer.parseInt(ary[0]); // ��¥
		list[4] = Integer.parseInt(ary[4]); // ����
		list[5] = Integer.parseInt(ary[5]); // ����
		/**
		 * �ش� �迭�� index�� ã������ - 1. arraylist ��ȯ
		 * �ش� �迭�� index�� ã������ - 2. indexOf�� ã��
		 * index�� ã�� ����? �ش� �迭�� ���� == �Է¹��� ���ڿ�, �ش� �ε����� == ��ġ�ϴ� �����
		 */
		// �̿��
		list[1] = Arrays.asList(StaticValue.TICKET_TYPE).indexOf(ary[1]); 
		// ����
		list[2] = Arrays.asList(StaticValue.TICKET_TIME).indexOf(ary[2]);
		// ����
		list[3] = Arrays.asList(StaticValue.AGE).indexOf(ary[3]);
		if(list[3] == -1) list[3] = StaticValue.BABY;
		// ������
		list[6] = Arrays.asList(StaticValue.SALE_ADVANTAGE).indexOf(ary[6]);
		if(list[6] == -1) list[6] = StaticValue.NONE;
		
		return list;
	}
}