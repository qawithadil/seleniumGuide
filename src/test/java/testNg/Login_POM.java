package testNg;

import java.io.IOException;

import org.apache.poi.hssf.model.RowBlocksReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BrowserConfig;
import base.Constant;
import base.ExcelUtils;

import base.WebLibrary;
import pages.Login;

@Listeners(listeners.Screenshot.class)
public class Login_POM {

	public static WebDriver driver;
	public static Login LG;
	WebLibrary wbl;
	ExtentReports report;
	ExtentTest test;

	@BeforeTest(groups = "POM")
	public void setUp(ITestContext context) {
		driver = BrowserConfig.getBrowser(Constant.browser);
		driver.get("https://demo.guru99.com/test/selenium-xpath.html");
		wbl = new WebLibrary(driver);
		wbl.window_maximize();
		wbl.implicitWait(Constant.implicit_wait_time);
		LG = PageFactory.initElements(driver, Login.class);
		context.setAttribute("WebDriver", driver);
		report = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\extent_class.html", true);
		test=report.startTest("Extent Report Demo");
		
	}
	
	@AfterTest(groups = "POM")
	public void close() {
		driver.close();
		report.endTest(test);
		report.flush();
	}

	@Test(groups = "POM", dataProvider = "loginPage")
	public void loginTest(String userName, String password) {
		test.log(LogStatus.INFO, "******** Login Test Cases Validation has been Started *******");
		LG.userLogin(userName, password);
		test.log(LogStatus.PASS, "This test case is pass");

	}

	@Test(groups = "POM")
	public void testScreenshot() {
		
		driver.findElement(By.xpath("123")).sendKeys("testFail");

	}

	@DataProvider(name = "loginPage")
	public Object[][] userLogin() throws IOException {
		Object[][] loginObjArray = ExcelUtils.getLoginCreds(Constant.login_file, Constant.sheet_name);
		return loginObjArray;
	}

}
