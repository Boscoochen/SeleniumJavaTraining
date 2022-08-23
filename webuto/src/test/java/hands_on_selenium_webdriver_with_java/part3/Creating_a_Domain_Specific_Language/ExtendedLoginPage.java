package hands_on_selenium_webdriver_with_java.part3.Creating_a_Domain_Specific_Language;

import org.openqa.selenium.By;

public class ExtendedLoginPage extends ExtendedBasePage{
	By usernameInput = By.id("username");
	By passwordInput = By.id("password");
	By submitButton = By.cssSelector("button");
	By successBox = By.id("success");
	
	public ExtendedLoginPage(String browser, int timeoutSec) {
		this(browser);
		setTimeoutSec(timeoutSec);
	}
	
	public ExtendedLoginPage(String browser) {
		super(browser);
		visit("http://bonigarcia.dev/selenium-webdriver-java/login-form.html");
	}
	
	public void with(String username, String password) {
		type(usernameInput, username);
		type(passwordInput, password);
		click(submitButton);
	}
	
	public boolean successBoxPresent() {
		return isDisplayed(successBox);
	}
}
