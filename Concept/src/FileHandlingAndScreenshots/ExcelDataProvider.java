// Build the appache Poi Jars


package FileHandlingAndScreenshots;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider extends DataProviders {

	
	private File getDatafile(String fileName) {	
		return new File(fileName);
	}
	
	private Workbook getExcelWorkbook(String fileName) throws Exception {
		System.out.println("get the workbook of file  :- "+ fileName);		
		FileInputStream excelfile =new FileInputStream(getDatafile(fileName));
		Workbook workbook = new XSSFWorkbook(excelfile);		
		return workbook;		
	}
	
	private Sheet getExcelSheet(Workbook workbook, String sheetName){
		Sheet sheet = workbook.getSheet(sheetName);
		if(sheet == null) {
			System.out.println("Sheet Not Found :- "+ sheetName);
		}
		return sheet;
	}
	
	
	private ArrayList<Sheet> getExcelSheetList(Workbook workbook){
		ArrayList<Sheet> sheetList = new ArrayList<>();
		int sheetCount = workbook.getNumberOfSheets();
		
		for (int i = 0; i <sheetCount; i++) {
			sheetList.add(workbook.getSheetAt(i));
			System.out.println();
		}
		return sheetList;		
	}
	
	private List<String> getExcelSheetHeader(Sheet sheet){
		try {
			List<String> headerList = new ArrayList<>();
			Iterator<Cell> headerIterator = sheet.getRow(0).cellIterator();
			while (headerIterator.hasNext()) {
				headerList.add(headerIterator.next().getStringCellValue());			
			}
			return headerList;
		} catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	
}