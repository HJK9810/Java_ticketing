package LotteTicketBox;

public class SaveVals { // save & make csv files
	protected int saveOrder(int all, int day, int age, int count, int price, int sales, int lastline, int[][] orderlist) {
		Ticketing.orderList[lastline][0] = all;
		Ticketing.orderList[lastline][1] = day;
		Ticketing.orderList[lastline][2] = age;
		Ticketing.orderList[lastline][3] = count;
		Ticketing.orderList[lastline][4] = price;
		Ticketing.orderList[lastline][5] = sales;
		return ++lastline;
	}
}