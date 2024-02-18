package com.TutorialNinja.QA.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//this pakage we can use in multiple test cases where we required same code
public class Utilites {
	
	public static final int Implicit_Wait_Time=10;
	public static final int page_Wait_Time=5;
	
	//below method is used to run the automation script with invalid credentials multiple times it will not show maximum number of attempts message
	public static String generateEmailwithTimeStamp() 
	{
		java.util.Date date = new java.util.Date();
		
		String timestamp =date.toString().replace(" ", "_").replace(":", "_");
		return "sachingowda"+timestamp+"@gmail.com";
		
	}
	
	// getting the data from excel sheet
	public static Object[][] getTestDataFromExcelSheet(String SheetName) 
	{
		File ExcelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TutorialNinja\\QA\\Testdata\\TutorialNinjaTestData.xlsx");
		XSSFWorkbook  workbook = null;
		try {
		FileInputStream fisExcel = new FileInputStream(ExcelFile);
		workbook = new XSSFWorkbook(fisExcel);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet=workbook.getSheet(SheetName);
		int rows = sheet.getLastRowNum();
		int columns=sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][columns];
		
		for(int i=0;i<rows;i++)
		{
			XSSFRow row=sheet.getRow(i+1);
			
			for(int j=0;j<columns;j++)
			{
				XSSFCell cell=row.getCell(j);
				
				CellType celltype=cell.getCellType();
				
				switch (celltype) {
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]=Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					break;

				
				}
			}
		}
		
		return data;
		
	}

}
