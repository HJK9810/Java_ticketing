package DataAnalysis;

import java.util.ArrayList;

public class Analysis {
	protected static String[] category; 
	protected static ArrayList<int[]> orderList = new ArrayList<>(); // Ƽ�Ϲ߱ǿ� �迭
	
	public static void main(String[] args) {
		ReadFile rf = new ReadFile();
		CheckTickets check = new CheckTickets();
		PrintList printl = new PrintList();
		
		rf.ReadCSV();
		check.TicketsAnalysis();
		printl.PrintAll();
	}
}