package DataAnalysis;

import java.util.ArrayList;

public class Analysis {
	protected static String[] category; 
	protected static ArrayList<int[]> orderList = new ArrayList<>(); // Ƽ�Ϲ߱ǿ� �迭
	
	public static void main(String[] args) {
		ReadFile rf = new ReadFile();
		PrintList printl = new PrintList();
		
		rf.ReadCSV();
		printl.PrintCSV();
		printl.PrintDaysSum();
		printl.PrintSaleType();
	}
}