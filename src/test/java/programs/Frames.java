package programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BrowserConfig;
import base.Constant;
import base.WebLibrary;

public class Frames {
	public static WebDriver driver;

	public static void main(String[] args) {
		driver = BrowserConfig.getBrowser(Constant.browser);
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		WebLibrary wbl = new WebLibrary(driver);
		wbl.window_maximize();
		wbl.implicitWait(Constant.implicit_wait_time);
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[text()='org.openqa.selenium']")).click();
		wbl.implicitWait(Constant.implicit_wait_time);
		driver.switchTo().parentFrame();
		System.out.println("*** All Ops Done ***");
		driver.close();

	}

}
