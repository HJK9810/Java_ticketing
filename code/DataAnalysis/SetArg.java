package DataAnalysis;

public class SetArg {
	protected int[] SetFileArgus(String[] ary) {
		int[] list = new int[7];
		
		list[0] = Integer.parseInt(ary[0]);
		list[4] = Integer.parseInt(ary[4]);
		list[5] = Integer.parseInt(ary[5]);
		
		if(ary[1].contains("종합")) list[1] = 1;
		else if(ary[1].contains("파크")) list[1] = 2;
		
		if(ary[2].trim().equals("1DAY")) list[2] = 1;
		else if(ary[2].trim().equals("After4")) list[2] = 2;
		
		String age = ary[3].trim();
		if(age.equals("노인")) list[3] = 5;
		else if(age.equals("어른")) list[3] = 4;
		else if(age.equals("청소년")) list[3] = 3;
		else if(age.equals("어린이")) list[3] = 2;
		else list[3] = 1;
		
		String type = ary[6].trim();
		if(type.equals("다둥이")) list[6] = 6;
		else if(type.equals("임산부")) list[6] = 5;
		else if(type.equals("휴가장병")) list[6] = 4;
		else if(type.equals("국가유공자")) list[6] = 3;
		else if(type.equals("장애인")) list[6] = 2;
		else list[6] = 1;
		
		return list;
	}
}