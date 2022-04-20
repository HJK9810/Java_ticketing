package DataAnalysis;

import java.util.Arrays;

public class SetArg {
	protected int[] SetFileArgus(String[] ary) {
		int[] list = new int[7];
		
		list[0] = Integer.parseInt(ary[0]); // ��¥
		list[4] = Integer.parseInt(ary[4]); // ����
		list[5] = Integer.parseInt(ary[5]); // ����
		// �̿��
		String ticket = ary[1].trim();
		list[1] = Arrays.asList(StaticValue.TICKET_TYPE).indexOf(ticket);
		// ����
		String time = ary[2].trim();
		list[2] = Arrays.asList(StaticValue.TICKET_TIME).indexOf(time);
		// ����
		String age = ary[3].trim();
		list[3] = Arrays.asList(StaticValue.AGE).indexOf(age);
		if(list[3] == -1) list[3] = StaticValue.BABY;
		// ������
		String type = ary[6].trim();
		list[6] = Arrays.asList(StaticValue.SALE_ADVANTAGE).indexOf(type);
		if(list[6] == -1) list[6] = StaticValue.NONE;
		
		return list;
	}
}