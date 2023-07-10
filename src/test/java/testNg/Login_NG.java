package testNg;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import base.BrowserConfig;
import base.Constant;
import base.ExcelUtils;
import base.WebLibrary;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Login_NG {

	public static WebDriver driver;
	WebLibrary wbl;

	@BeforeClass(groups = "smoke")
	public void testSetup() {

		System.out.println("Under @BeforeClass Method..");
		driver = BrowserConfig.getBrowser(Constant.browser);
		driver.get("https://demo.guru99.com/test/selenium-xpath.html");
		wbl = new WebLibrary(driver);
		wbl.window_maximize();
		wbl.implicitWait(Constant.implicit_wait_time);

	}

	@Test(groups = "smoke")
	public void TC001() {
		System.out.println("# Verify Blank user Id and password");
		driver.findElement(By.name("uid")).sendKeys("test");
		driver.findElement(By.name("password")).sendKeys("123");
		String ac_uName_error = driver.findElement(By.id("message23")).getText();
		String exp_uName_error = "User-ID must not be blank";
		Assert.assertEquals(ac_uName_error, exp_uName_error);

	}

	@Test(groups = "smoke")
	public void TC002() {
		boolean val = false;
		if (val) {
			System.out.println("Value is set to TRUE");

		} else {
			throw new SkipException("Skip this exception");
		}

	}

	@Test(groups = "smoke")
	public void TC004() {
		System.out.println("Uder TC004");

	}

	@Test(groups = "smoke")
	public void TC005() {
		System.out.println("Uder TC005");

	}

	@Test(dataProvider = "loginAuth", groups = { "smoke" })
	public void TC003(String userName, String password) {
		System.out.println("Under data provider function....");
		System.out.println("userName=" + userName + "password=" + password);

	}

	@AfterClass(groups = { "smoke" })
	public void closeBrowser() {
		driver.close();
	}

	@DataProvider(name = "loginAuth")
	public static Object[][] credential() throws IOException {
		Object[][] loginObjArray = ExcelUtils.getLoginCreds(Constant.login_file, Constant.sheet_name);
		return loginObjArray;

	}

}
