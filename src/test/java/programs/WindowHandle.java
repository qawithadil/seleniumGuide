package programs;
/*
 * Window / Tab
 */

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BrowserConfig;
import base.Constant;
import base.WebLibrary;

public class WindowHandle {
	public static WebDriver driver;

	public static void main(String[] args) {
		driver = BrowserConfig.getBrowser(Constant.browser);
		driver.get("https://irctc.co.in");
		WebLibrary wbl = new WebLibrary(driver);
		wbl.window_maximize();
		wbl.implicitWait(Constant.implicit_wait_time);
		String parent_window = driver.getWindowHandle();
		System.out.println("Parent Window=" + parent_window);
		driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
		Set<String> all_windows = driver.getWindowHandles();
		System.out.println("All windows length=" + all_windows.size());
		Iterator<String> itr = all_windows.iterator();
		String parent_tab = itr.next();
		String flight_tab = itr.next();
		System.out.println("Parent Tab=" + parent_tab);
		System.out.println("Flight Tab=" + flight_tab);
		// switching to flight tab
		System.out.println("Switching to Flight Tab...");
		driver.switchTo().window(flight_tab);
		System.out.println("Switching to Main Window...");
		driver.switchTo().window(parent_tab);
		System.out.println("****End ****");
		boolean status = itr.hasNext();
		System.out.println("Other windows =" + status);
		driver.close();

	}

}
