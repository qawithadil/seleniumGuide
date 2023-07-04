package programs;

import org.openqa.selenium.WebDriver;

import base.BrowserConfig;
import base.Constant;

public class LaunchBrowser {
	public static WebDriver driver;

	public static void main(String[] args) {

		driver = BrowserConfig.getBrowser(Constant.browser);
		driver.get(Constant.baseurl); // Launch browser
		driver.manage().window().maximize(); // maximize window
		// driver.manage().window().fullscreen(); // Window full screen
		String page_title=driver.getTitle();// Title of the page
		System.out.println("Page Title="+page_title);
		driver.close();

	}

}
