package foundation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObjectBase {
	private WebDriver driver;

	public PageObjectBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return this.driver;
	}
}
