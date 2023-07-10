package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static String readSingleData(String sheetName, int rowNum, int colNum)
			throws InvalidFormatException, IOException {
		File file = new File(Constant.login_file);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet(sheetName);
		XSSFRow row = sh.getRow(rowNum);
		String data = row.getCell(colNum).toString();
		fis.close();
		wb.close();
		return data;

	}

	public static void setSingleCell_data(String sheetName, int rowNum, int colNum, String data)
			throws InvalidFormatException, IOException {
		// File file = new File(Constant.login_file);
		FileInputStream fis = new FileInputStream(Constant.login_file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheetName);
		XSSFRow row = sh.getRow(rowNum);
		XSSFCell cell = row.createCell(colNum);
		System.out.println("Cell Created");
		cell.setCellValue(data);
		System.out.println("Data has been set");
		FileOutputStream fos = new FileOutputStream(Constant.login_file);
		wb.write(fos);
		System.out.println("Value written over the given cell");
		fos.close();

	}

	public static void getSingleCol_data(String sheetName) throws InvalidFormatException, IOException {
		File file = new File(Constant.login_file);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet(sheetName);
		int row_count = sh.getLastRowNum();
		System.out.println("Total Number of rows=" + row_count);
		int col_count = sh.getRow(0).getLastCellNum();
		System.out.println("Column count=" + col_count);
		for (int i = 1; i <= row_count; i++) {
			XSSFRow row = sh.getRow(i);
			String data = row.getCell(0).toString();
			System.out.println("Data=" + data);
		}
		fis.close();
		wb.close();

	}

	public static Object[][] getLoginCreds(String login_file, String sheet_name) throws IOException {
		
		int startRow = 1;
		int StartCol = 0;
		int ci, cj;
		int total_col = 1;
		FileInputStream fis = new FileInputStream(login_file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheet_name);
		
		
		int row_count = sh.getLastRowNum();
		
		Object[][] credsArray = new Object[row_count][total_col+1];
		ci = 0;
		for (int i = startRow; i <= row_count; i++) {
			cj = 0;
			for (int j = StartCol; j <= total_col; j++) {
				XSSFRow row=sh.getRow(i);
				String data = row.getCell(j).toString();
			//	System.out.println("Data["+i+"]+["+j+"]=>"+data);
				credsArray[ci][cj]=data;
               cj++;
			}
			ci++;
		}
		fis.close();
		wb.close();

		return credsArray;

	}
}
