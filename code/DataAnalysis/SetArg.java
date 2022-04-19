package DataAnalysis;

public class SetArg {
	protected int[] SetFileArgus(String[] ary) {
		int[] list = new int[7];
		
		list[0] = Integer.parseInt(ary[0]);
		list[4] = Integer.parseInt(ary[4]);
		list[5] = Integer.parseInt(ary[5]);
		
		if(ary[1].contains("����")) list[1] = 1;
		else if(ary[1].contains("��ũ")) list[1] = 2;
		
		if(ary[2].trim().equals("1DAY")) list[2] = 1;
		else if(ary[2].trim().equals("After4")) list[2] = 2;
		
		String age = ary[3].trim();
		if(age.equals("����")) list[3] = 5;
		else if(age.equals("�")) list[3] = 4;
		else if(age.equals("û�ҳ�")) list[3] = 3;
		else if(age.equals("���")) list[3] = 2;
		else list[3] = 1;
		
		String type = ary[6].trim();
		if(type.equals("�ٵ���")) list[6] = 6;
		else if(type.equals("�ӻ��")) list[6] = 5;
		else if(type.equals("�ް��庴")) list[6] = 4;
		else if(type.equals("����������")) list[6] = 3;
		else if(type.equals("�����")) list[6] = 2;
		else list[6] = 1;
		
		return list;
	}
}