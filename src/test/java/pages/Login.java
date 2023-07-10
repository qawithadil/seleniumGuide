package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.WebLibrary;

public class Login {
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Page factory initialization at Constructor level

	}

	public static WebDriver driver;
	WebLibrary wbl = new WebLibrary(driver);

	/*
	 * All Elements locator Declaration
	 */

	@FindBy(name = "uid")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement pwd;

	@FindBy(name = "btnLogin")
	private WebElement login_btn;

	@FindBy(id = "message23")
	private WebElement userName_error;

	@FindBy(id = "message18")
	private WebElement pwd_error;

	public void userLogin(String uName, String upass) {
		userName.clear();
		userName.sendKeys(uName);
		pwd.clear();
		pwd.sendKeys(upass);

	}

	public void click_login() {
		login_btn.click();
	}

	public String uError() {
		String uError = userName_error.getText();
		return uError;

	}

	public String pwd_error() {
		String pError = pwd_error.getText();
		return pError;

	}

}
