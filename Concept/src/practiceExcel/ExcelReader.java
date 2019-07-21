
/*author- Ankit Kulhade
 * Code to read the Excel by Key Value Pair
 * 1st Column will be Key Column and next column is be Value column
 * */

package practiceExcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static final String EXCELFILEPATH = "./Data.xlsx";
	
	private static FileInputStream fis ;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	
	public static void loadExcel() throws Exception{
		
		System.out.println("Loading the Excel File");
		File file = new File(EXCELFILEPATH);
		fis= new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("TestData");
		fis.close();
		
	}
	
	public static Map<String,Map<String, String>> getDataMap() throws Exception{
		if(sheet == null) {
			loadExcel();
		}
		Map<String,Map<String,String>> superMap = new HashMap<String,Map<String,String>>();
		Map<String,String> myMap = new HashMap<String,String>();
		
		for(int i = 1;i < sheet.getLastRowNum() + 1; i++){
			row = sheet.getRow(i);
			String KeyCell = row.getCell(0).getStringCellValue();
					
			int colNumber = row.getLastCellNum();
			for(int j = 1; j < colNumber; j++) {
				String value = row.getCell(j).getStringCellValue();
				myMap.put(KeyCell, value);		
			}
			superMap.put("MASTERDATA", myMap);
		}
				
		return superMap;
	}
	
	
	public static String getValue(String key) throws Exception{
		
		Map<String, String> myValue = getDataMap().get("MASTERDATA");
		String retValue = myValue.get(key);
		return retValue;
	}
	
	public static void main(String [] args) throws Exception {
		
		System.out.println("my name is -->  "+ getValue("name"));
		System.out.println("my lastname is -->  "+ getValue("lastname"));
		System.out.println("my age is -->  "+ getValue("age"));
	}
}
