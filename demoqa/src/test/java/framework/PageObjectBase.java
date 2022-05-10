package framework;

import org.openqa.selenium.WebDriver;


public abstract class PageObjectBase {
	private WebDriver driver;
	public PageObjectBase(WebDriver driver) {
		this.driver = driver;
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
}
