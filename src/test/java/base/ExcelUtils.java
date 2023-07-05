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
		File file = new File(Constant.login_file);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet(sheetName);
		XSSFRow row = sh.getRow(rowNum);
		XSSFCell cell = row.createCell(colNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		fis.close();
		fos.close();
		wb.close();

	}

	public static void getSingleCol_data(String sheetName) throws InvalidFormatException, IOException {
		File file = new File(Constant.login_file);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet(sheetName);
		int row_count = sh.getLastRowNum();
		System.out.println("Total Number of rows=" + row_count);
		int col_count=sh.getRow(0).getLastCellNum();
		System.out.println("Column count="+col_count);
		for(int i=1;i<=row_count;i++) {
			XSSFRow row=sh.getRow(i);
			String data=row.getCell(0).toString();
			System.out.println("Data="+data);
		}
		fis.close();
		wb.close();

	}

	public void setSingleCol_data() {

	}

}
