package com.crm.qa.testUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICITLY_WAIT = 10;
	public static String TESTDATA_SHEET_PATH = "C:\\Learning\\elipse_Workspace\\FreeCRMNew\\src\\main\\java"
			+ "\\com\\crm\\qa\\testdata\\NewFreeCRMTestData.xls";
	
	static Workbook book;
	static Sheet sheet;

	
	//Utility to read data from a sheet {sheetName} of Excel File 
		public static Object[][] getCRMTestData (String sheetName){
			FileInputStream file = null;
			
			try {
				file = new FileInputStream(TESTDATA_SHEET_PATH);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			try {
				book = WorkbookFactory.create(file);
				//book = new XSSFWorkbook(file);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sheet = book.getSheet(sheetName);
			
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for (int i=0; i<sheet.getLastRowNum();i++) {
				for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}			
			return data;
		}

		//Utility to take screenshot when error occurred
		public static void takeScreenshotAtEndOfTest() throws IOException{
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screeshot/" + System.currentTimeMillis() + ".png"));
		
	}
}