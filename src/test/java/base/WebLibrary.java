package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebLibrary {
	public WebLibrary(WebDriver driver) {
		this.driver = driver;
	}

	public static WebDriver driver = BrowserConfig.driver;

	public void window_maximize() {
		driver.manage().window().maximize();
	}

	public void navigate_back() {
		driver.navigate().back();
	}

	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}

	public void explicitWait(int seconds, WebElement wait_locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(wait_locator));
	}

	public void fluentWait(int time, int polling_time) {
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
		fwait.withTimeout(Duration.ofSeconds(time)).pollingEvery(Duration.ofSeconds(polling_time))
				.ignoring(NoSuchElementException.class);

	}

	public void click(WebElement el) {
		el.click();

	}

	public static String takeSnapShot() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		// Convert web driver object to TakeScreenshot
		// TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File scrShot = ((TakesScreenshot) BrowserConfig.driver).getScreenshotAs(OutputType.FILE);
		// Call getScreenshotAs method to create image file
		// File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(Constant.snap_file_path + formatter.format(date) + ".png");
		String path=Constant.snap_file_path + formatter.format(date) + ".png";
		System.out.println("<a src='" + DestFile + "'>Click to View the Snapshot</a>");
		// Copy file at destination
		try {
			FileUtils.copyFile(scrShot, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;

	}

}
