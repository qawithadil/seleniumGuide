/* 1. ByClassName driver.findElement(By.className(""));
 * 2. ByCSSSelector driver.findElement(By.cssSelector(null))
 * 3. ByName       driver.findElement(By.name(null))
 * 4. ById         driver.findElement(By.id(null)
 * 5. ByLinkText   driver.findElement(By.linkText(null))
 * 6. ByPartialLinkText driver.findElement(By.partialLinkText(null))
 * 7. ByTagName         driver.findElement(By.tagName(null));
 * 8. ByXpath           driver.findElement(By.xpath(null))
 */

package programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BrowserConfig;
import base.Constant;

public class Locators {
	public static WebDriver driver;

	public static void main(String[] args) {

		driver = BrowserConfig.getBrowser(Constant.browser);
		driver.get(Constant.baseurl);
		// ByCLass Name
		// driver.findElement(By.className("sign-up")).click();
		// switch the browser focus on the main tab
		// driver.switchTo().window("0");

		// BylinkText
		// driver.findElement(By.linkText("Web")).click();

		// By Tag Name

		// driver.findElement(By.tagName("a")).click();

		// Xpath

	//	driver.findElement(By.xpath("(//a[@class='sign-up'])[1]")).click();
		driver.get("https://demo.guru99.com/test/selenium-xpath.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("qawithadil@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123");
		// Contains
		driver.findElement(By.xpath("//input[contains(@type,'sub')]")).click();

		/*
		 * 1. Contains
		 * driver.findElement(By.xpath("//input[contains(@type,'sub')]")).click();
		 * 2. And OR
		 * Xpath=//input[@type='submit' and @name='btnLogin']
		 * 3. Starts-with
		 * Xpath=//label[starts-with(@id,'message')]
		 * 4. text(0
		 * Xpath=//td[text()='UserID']
		 * 5. Following
		 * //input[@type='text']//following::input
		 * 6. Ancestor 
		 * Xpath=//*[text()='Enterprise Testing']//ancestor::div
		 * 7. Child 
		 * //*[@id='java_technologies']//child::li
		 */
	}
}
