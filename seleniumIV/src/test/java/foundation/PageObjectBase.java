package foundation;

import org.openqa.selenium.WebDriver;

public abstract class PageObjectBase {
	private WebDriver driver;
	
	public PageObjectBase(WebDriver driver) {
		this.driver = driver;
	}

	
	public WebDriver getDriver() {
		return this.driver;
	}
}
