package programs;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BrowserConfig;
import base.Constant;
import base.WebLibrary;

/*
 * 1. Implicit Wait
 * 2. Explicit Wait
 * 3. Fluent Wait
 * 4. Normal Wait 
 *
 */
public class WDriverWait {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = BrowserConfig.getBrowser(Constant.browser);
		driver.get(Constant.baseurl_guru);
		WebLibrary wbl = new WebLibrary(driver);
		wbl.window_maximize();

		/*
		 * 1. Normal Wait
		 */
		System.out.println("1. Normal Wait..");
		Thread.sleep(3000);
		WebElement sw=driver.findElement(By.xpath("//*[@title='Software Testing']"));
		wbl.click(sw);
		wbl.navigate_back();

		/*
		 * 2. Implicit Wait
		 */
		System.out.println("2. Implicit Wait...");
		wbl.implicitWait(Constant.implicit_wait_time);
		driver.findElement(By.xpath("//*[@title='Selenium']")).click();
		wbl.navigate_back();

		/*
		 * 3. Explicit Wait
		 */
		System.out.println("3. Explicit Wait");
		WebElement wait_locator = driver.findElement(By.xpath("//*[@title='SAP Beginner']"));
		wbl.explicitWait(Constant.explicit_wait_time, wait_locator);
		wait_locator.click();
		wbl.navigate_back();

		/*
		 * 4. Fluent Wait
		 */
		System.out.println("4. Fluent Wait");
		wbl.fluentWait(Constant.fluent_wait_time, Constant.polling_time);
		wait_locator.click();
		wbl.navigate_back();
		
		System.out.println("*********** End **************");

	}

}
