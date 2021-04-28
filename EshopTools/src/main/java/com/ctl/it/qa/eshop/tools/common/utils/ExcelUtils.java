package com.ctl.it.qa.eshop.tools.common.utils;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.thucydides.core.annotations.Step;

public class ExcelUtils extends GlobalVariables {

	static DataFormatter formatter = new DataFormatter();
	public static Workbook excelWBook;
	public static Sheet excelWSheet;
	public static Row excelRow;
	public static Cell cell;
	static int i = 0;
	static int j = 0;

	public void openExcelFile(File excelFile, String sheetName)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		FileInputStream testDataFile = new FileInputStream(excelFile);
		excelWBook = WorkbookFactory.create(testDataFile);
		excelWSheet = excelWBook.getSheet(sheetName);

	}

	public static int getRowNumber(String data) {

		for (i = 0; i < excelWSheet.getLastRowNum(); i++) {

			for (j = 0; j < excelWSheet.getRow(i).getLastCellNum(); j++) {

				if (formatter.formatCellValue(excelWSheet.getRow(i).getCell(j)).equalsIgnoreCase(data)) {
					return i;
				}

			}

		}
		return i;

	}

	public static int getColumnNumber(String colName) {

		for (i = 0; i < excelWSheet.getLastRowNum(); i++) {

			for (j = 0; j < excelWSheet.getRow(i).getLastCellNum(); j++) {
				if (formatter.formatCellValue(excelWSheet.getRow(i).getCell(j)).equalsIgnoreCase(colName)) {
					return j;
				}
			}

		}
		return j + 1;

	}

	public String getCellData(int rowNumber, int colNumber) {
		return excelWSheet.getRow(rowNumber).getCell(colNumber).getStringCellValue();
	}
	
	public static String ReadExcel1(String ColName)
	{
		String val = "";
		try {
		File file = new File("..\\EshopTools\\src\\test\\resources\\OrderDetails.xlsx");//creating a new file instance
		FileInputStream fis = new FileInputStream(file); 
		XSSFWorkbook wb = new XSSFWorkbook(fis);  
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
	
   		XSSFRow row = sheet.getRow(rowCount);
   		int noOfColumns = sheet.getRow(0).getLastCellNum();
   		
		XSSFCell cell = row.getCell(5);
		String cellValue=cell.getStringCellValue();
		System.out.println(cellValue);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}



	// set excel cell data for the given row and column
	public void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		try {
			excelWSheet.getRow(RowNum).createCell(ColNum);
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(Result);
			FileOutputStream fileOut = new FileOutputStream(ExcelFile);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

}
