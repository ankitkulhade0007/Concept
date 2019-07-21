package FileHandlingAndScreenshots;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		
	ReadExcelSheetData r = new ReadExcelSheetData();
	String val = r.getMapData("search");
	System.out.println("Value of the keyword (search) is- "+val);
	}
	


}
	
