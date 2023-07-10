package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BrowserConfig;
import base.Constant;
import base.WebLibrary;

public class Screenshot implements ITestListener {
	public static WebDriver driver;
	

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		// ITestListener.super.onStart(context);
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.onTestStart(result);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestSuccess(result);
		System.out.println("Test Case Success=>" + result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) {
		
		

		// TODO Auto-generated method stub
		System.out.println("Under Test Failure");
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		// Convert web driver object to TakeScreenshot
		// TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File scrShot = ((TakesScreenshot) BrowserConfig.driver).getScreenshotAs(OutputType.FILE);
		// Call getScreenshotAs method to create image file
		// File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(Constant.snap_file_path + formatter.format(date) + ".png");
		System.out.println("<a src='" + DestFile + "'>Click to View the Snapshot</a>");
		// Copy file at destination
		try {
			FileUtils.copyFile(scrShot, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		// System.out.println("Test Case Success=>" + result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// ITestListener.super.onFinish(context);
	}

}
