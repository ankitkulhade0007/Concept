
/*This class is going to read the data from Excel with Multiple Column and by Looking to Key 
 * 1st Column will be your Key and next all other column will Value
 * 
 * 
 * */
package practiceExcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MasterData {

public static final String EXCELFILEPATH = "./MasterData.xlsx";
	
	private static FileInputStream fis ;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	
	public static void loadExcel() throws Exception{
	
		// This Methos will Load the Excel Sheet
		System.out.println("Loading the Excel File");
		File file = new File(EXCELFILEPATH);
		fis= new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("TestData");
		fis.close();
		
	}
	
	public static List<Map<String,String>> readAllData() throws Exception{		
		// This will check weather the sheet is loaded if not then will Load the Sheet
		if(sheet==null) {
			loadExcel();
		}
		
		List<Map<String,String>>  mapList = new ArrayList<>();
		int rows = sheet.getLastRowNum();
		// Here we are initialinzing the row object so we not get the NullPointerException
		row = sheet.getRow(0);
		
		// Starting the loop from the column. 1st will store all the value from 1st clmn and then move to move to next column
		for (int j = 1; j<row.getLastCellNum(); j++) {			
			// will store all data from jth column to that myMap
			Map<String, String> myMap = new HashMap<>();			
			// Will move to jth column respected Rows
			for(int i = 1; i<rows+1; i++) {
				Row r = CellUtil.getRow(i, sheet);
				String key = CellUtil.getCell(r, 0).getStringCellValue();
				String value = CellUtil.getCell(r, j).getStringCellValue();
				myMap.put(key, value);				
			}
			mapList.add(myMap);			
		}
		
		return mapList;
	}

	
	
	public static void main(String[] args) throws Exception{
		
		// System.out.println(readAllData());
		
		
	}
	
	public void reteriveData(List<Map<String,String>> readAllData) {
		
		for(Map<String,String> map : readAllData) {
			
			
			System.out.println(map.get("name"));
			
		}
		System.out.println();
		
	}
}



