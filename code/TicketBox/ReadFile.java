package TicketBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadFile {
	protected void ReadCSV() {
		try {
            BufferedReader br = new BufferedReader(new FileReader(StaticValue.PATH + "report.csv"));
            String line = br.readLine(); // ù���� ��� ���ڿ��� ī�װ��̱⿡
            SystemFunc.category = line.split(",");
            while ((line = br.readLine()) != null) {
            	String[] ary = line.replace(" ", "").split(","); // ����������, �и�
            	int[] list = new int[7];
            	// ���ںκ��� String to int ������� �Է�
            	list[0] = Integer.parseInt(ary[0]); // ��¥
        		list[4] = Integer.parseInt(ary[4]); // ����
        		list[5] = Integer.parseInt(ary[5]); // ����
        		/**
        		 * �ش� �迭�� index�� ã������
        		 * 1. arraylist ��ȯ
        		 * 2. indexOf�� ã��
        		 * index�� ã�� ����? 
        		 * �ش� �迭�� ���� == �Է¹��� ���ڿ�, �ش� �ε����� == ��ġ�ϴ� �����
        		 * => �� �Է°��� �ش��ϴ� ���ڿ����� ��� �迭�� ����� ����
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
            	
        		SystemFunc.orderList.add(list); 
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}