package DataAnalysis;

import java.util.ArrayList;

public class Analysis {
	protected static String[] category; 
	protected static ArrayList<int[]> orderList = new ArrayList<>(); // 티켓발권용 배열
	
	public static void main(String[] args) {
		ReadFile rf = new ReadFile();
		PrintList printl = new PrintList();
		
		rf.ReadCSV();
		printl.PrintCSV();
		printl.PrintDaysSum();
		printl.PrintSaleType();
	}
}