package programs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BrowserConfig;
import base.Constant;
import base.WebLibrary;

public class Alerts {

	public static WebDriver driver;
	public static Alert alert;

	public static void main(String[] args) {
		driver = BrowserConfig.getBrowser(Constant.browser);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		WebLibrary wbl = new WebLibrary(driver);
		wbl.window_maximize();

		// Alert Click
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		alert = driver.switchTo().alert();
		String alert_text = alert.getText();
		System.out.println("Alert text=" + alert_text);
		alert.accept();
		System.out.println("After Action Text=" + driver.findElement(By.xpath("//p[@id='result']")).getText());

		// Confirm
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		alert = driver.switchTo().alert();
		String confirm_text = alert.getText();
		System.out.println("Confirmation popup text=" + confirm_text);
		System.out.println("Clicking on Cancel");
		alert.dismiss();
		System.out.println("After Action Text=" + driver.findElement(By.xpath("//p[@id='result']")).getText());

		// JS Prompt
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		alert = driver.switchTo().alert();
		String Prompt_text = alert.getText();
		System.out.println("Prompt Alert Text=" + Prompt_text);
		// Sending value
		alert.sendKeys("This is input text");
		alert.accept();
		System.out.println("After Action Text=" + driver.findElement(By.xpath("//p[@id='result']")).getText());
        driver.close();
	}

}
