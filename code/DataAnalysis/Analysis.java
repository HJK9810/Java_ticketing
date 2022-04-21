package DataAnalysis;

import java.util.ArrayList;

public class Analysis {
	protected static String[] category; 
	protected static ArrayList<int[]> orderList = new ArrayList<>(); // 티켓발권용 배열
	
	public static void main(String[] args) {
		ReadFile rf = new ReadFile();
		CheckTickets check = new CheckTickets();
		PrintList printl = new PrintList();
		
		rf.ReadCSV();
		check.TicketsAnalysis();
		printl.PrintAll();
	}
}