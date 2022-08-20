package hands_on_selenium_webdriver_with_java.part3.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicLoginPage {
	WebDriver driver;
	
	By usernameInput = By.id("username");
	By passwordInput = By.id("password");
	By submitButton = By.cssSelector("button");
	By succcessBox = By.id("success");
	
	public BasicLoginPage(WebDriver driver) {
		this.driver = driver;
		
		driver.get("http://bonigarcia.dev/selenium-webdriver-java/login-form.html");
	}
	
	public void	 with(String username, String password) {
		driver.findElement(usernameInput).sendKeys(username);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(submitButton).click();
	}
	
	public boolean successBoxPresent() {
		return driver.findElement(succcessBox).isDisplayed();
	}
}
