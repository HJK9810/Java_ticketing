package LotteTicketBox;

public class Ticketing { // main for ticketing programm
	// ����, ���, ������, �ް��庴, �ӻ��, �ٵ���
	final int NONE = 1, DISABLE = 2, MERIT = 3, VACSOLD = 4, PREGNANT = 5, MULTICHILD = 6;
	final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;
	protected static int[][] orderList = new int[100][6]; // Ƽ�Ϲ߱ǿ� �迭

	public static void main(String[] args) {
		InputData input = new InputData();
		PrintUI pui = new PrintUI();
		CalTickets calc = new CalTickets();
		SaveVals save = new SaveVals();

		int isExit = 0;

		do {
			int totalSum = 0; // ��� Ƽ�ϰ� ����
			int position = 0;
			while (true) {
				int typeAll = pui.ticketTypeAll(); // ���� or ��ũ
				int typeDay = pui.ticketTypeDay(); // ���� or ����
				int residentNum = input.inputResidentNum(); // �ֹι�ȣ ���ڸ�
				int count = input.ticketsCount(); // Ƽ�ϼ�
				int forsales = input.ticketSale(typeAll); // �����������

				int age = calc.checkAge(calc.CalAge(residentNum)); // ���ɴ���
				int price = calc.checkTicketPrice(typeAll, typeDay, age); // Ƽ�� ����
				int saleprice = calc.salePriceCal(price, forsales); // ���ΰ� ���� Ƽ�ϰ�
				int sum = calc.ticketSum(price, forsales, count, saleprice); // Ƽ�ϰ� ����
				position = save.saveOrder(typeAll, typeDay, age, count, saleprice, forsales, position);
				totalSum += sum;
				int check = pui.printReapeat(sum); // �߰��߱�����
				if (check == 2) break;
			}
			pui.printTickets(totalSum, position, orderList); // �߱��� Ƽ�� ���� & �� & ���ݵ� ���
			save.inputFile(position); // �ش� ���Ͽ� �Է�
			isExit = pui.inputEnd(); // ��������
		} while (isExit == 1);
	}
}