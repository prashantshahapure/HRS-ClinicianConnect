package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static String  TEST_DATA_FILE_PATH = "D:\\Selenium\\HomePractice\\HRS\\src\\main\\java\\com\\hrs\\testdata\\HRSTestData.xlsx";
	
	public static Object[][] getTestData(String sheetname) throws Exception
	{
		
		FileInputStream fin = null;
		fin = new FileInputStream(TEST_DATA_FILE_PATH);
		
		wb =  new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetname);
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i< sheet.getLastRowNum(); i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}

}
