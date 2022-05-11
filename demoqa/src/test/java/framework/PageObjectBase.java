package framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import extensions.controlextensionfactory_.ControlExtensionFactory;


public abstract class PageObjectBase {
	private WebDriver driver;
	private ControlExtensionFactory ControlExtensionFactory;
	public PageObjectBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		ControlExtensionFactory = new ControlExtensionFactory();
	}
	
	protected WebDriver getDriver() {
		return driver;
	}

	public ControlExtensionFactory getControlExtensionFactory() {
		return ControlExtensionFactory;
	}
}
