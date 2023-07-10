package programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import base.BrowserConfig;
import base.Constant;
import base.WebLibrary;

public class Excelops {
	public static WebDriver driver;

	public static void main(String[] args) throws InvalidFormatException, IOException {
		driver = BrowserConfig.getBrowser(Constant.browser);
		driver.get(Constant.baseurl_guru);
		WebLibrary wbl = new WebLibrary(driver);
		wbl.window_maximize();
		wbl.implicitWait(Constant.implicit_wait_time);
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\data\\login.xlsx");
		FileInputStream fis = new FileInputStream(file);

		/*
		 * 1.0 Reading Single Cell Data
		 */
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheetAt(0);

		// 1st row Data Fetch
		XSSFRow row = sh.getRow(1);
		String userName1 = row.getCell(0).toString();
		String password1 = row.getCell(1).toString();
		System.out.println("UserName=" + userName1 + "Password=" + password1);

		row = sh.getRow(2);
		String userName2 = row.getCell(0).toString();
		String password2 = row.getCell(1).toString();
		System.out.println("UserName=" + userName2 + "Password=" + password2);

		/*
		 * 2.0 Reading Multiple Cell Data
		 */

		int row_length = sh.getLastRowNum();
		int col_length = sh.getRow(1).getLastCellNum();
		System.out.println("Row_length=" + row_length + "Col_Length=" + col_length);
		for (int i = 1; i <= row_length; i++) {
			for (int j = 0; j < col_length; j++) {
				XSSFRow row1 = sh.getRow(i);
				String data = row1.getCell(j).toString();
				System.out.println("data[" + i + "]=" + data);
			}
		}
		fis.close();
		wb.close();

		/*
		 * 3. Writing Data into the last row
		 */

		FileInputStream fis1 = new FileInputStream(file);
		XSSFWorkbook wb1 = new XSSFWorkbook(file);
		XSSFSheet sh1 = wb1.getSheetAt(0);
		XSSFRow WROW = sh1.getRow(6);
		XSSFCell WCell = WROW.createCell(0);
		WCell.setCellValue("test6@gmail.com");
		FileOutputStream fos = new FileOutputStream(file);
		wb1.write(fos);
		fos.close();
		fis1.close();
		wb1.close();

		driver.close();

	}

}
