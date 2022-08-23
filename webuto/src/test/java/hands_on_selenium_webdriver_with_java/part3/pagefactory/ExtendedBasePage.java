package hands_on_selenium_webdriver_with_java.part3.pagefactory;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendedBasePage {
	WebDriver driver;
	WebDriverWait wait;
	int timeoutSec = 5;
	
	public ExtendedBasePage(String browser) {
		driver = WebDriverManager.getInstance(browser).create();
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
	}
	
	public void setTimeoutSec(int timeoutSec) {
		this.timeoutSec = timeoutSec;
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void type(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			return false;
		}
		return true;
	}
	
	public void quit() {
		if (driver != null) {
			driver.quit();
		}
	}
}
