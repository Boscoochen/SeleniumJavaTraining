package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import elements.ControlExtensionFactory;


public abstract class PageObjectBase {
	private WebDriver driver;
	public PageObjectBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
}
