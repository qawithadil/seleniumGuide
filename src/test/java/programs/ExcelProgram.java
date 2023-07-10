package programs;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import base.ExcelUtils;

public class ExcelProgram {

	public static WebDriver driver;

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// driver = BrowserConfig.getBrowser(Constant.browser);
		/*
		 * driver.get(Constant.baseurl_guru); WebLibrary wbl = new WebLibrary(driver);
		 * wbl.window_maximize(); wbl.implicitWait(Constant.implicit_wait_time);
		 */
		// String data = ExcelUtils.readSingleData("login", 1, 0);
		// System.out.println("Data=" + data);
		// ExcelUtils.getSingleCol_data("login");
		ExcelUtils.setSingleCell_data("login", 6, 1, "test6");

	}

}
