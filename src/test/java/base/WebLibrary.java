package base;

import java.time.Duration;
import java.util.NoSuchElementException;

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

}
