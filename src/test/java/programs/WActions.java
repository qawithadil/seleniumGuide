package programs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BrowserConfig;
import base.Constant;
import base.WebLibrary;

public class WActions {

	public static WebDriver driver;

	public static void main(String[] args) {
		driver = BrowserConfig.getBrowser(Constant.browser);
		driver.get(Constant.baseurl_guru);
		WebLibrary wbl = new WebLibrary(driver);
		wbl.window_maximize();
		wbl.implicitWait(Constant.implicit_wait_time);

		/*
		 * Actions
		 */

		Actions act = new Actions(driver);
		/*
		 * WebElement el_loc =
		 * driver.findElement(By.xpath("//*[@title='Software Testing']"));
		 * act.moveToElement(el_loc).click().build().perform(); wbl.navigate_back();
		 */
		// act.contextClick(el_loc).build().perform();

		driver.findElement(By.xpath("//*[@id='navbar-brand-centered']//child::li/a[1]")).click();

		act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ARROW_DOWN);
		WebElement userName = driver.findElement(By.name("uid"));
		WebElement pw = driver.findElement(By.name("password"));
		userName.sendKeys("emailforadil");
		act.moveToElement(userName).click();
		act.keyDown(Keys.CONTROL).sendKeys("A", "C");
		act.moveToElement(pw).click();
		act.keyDown(Keys.CONTROL).sendKeys("V").build().perform();
		WebElement login_button = driver.findElement(By.name("btnLogin"));
		act.moveToElement(login_button).click().build().perform();

	}

}
