package DataAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	protected static String path = "C:\\javatest\\ticketing\\";
	protected void ReadCSV() {
		SetArg set = new SetArg();
		try {
            BufferedReader br = new BufferedReader(new FileReader(path + "report.csv"));
            String line = br.readLine();
            Analysis.category = line.split(",");
            while ((line = br.readLine()) != null) {
            	Analysis.orderList.add(set.SetFileArgus(line.replace(" ", "").split(","))); // ����������, �и�
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}