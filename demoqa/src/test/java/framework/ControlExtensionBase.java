package framework;

import org.openqa.selenium.WebElement;

public abstract class ControlExtensionBase{
	public WebElement wrappedElement;
	
	public ControlExtensionBase(WebElement element) {
		this.wrappedElement = element;
	}

	//get the button value
	public String getValue() {
		return this.wrappedElement.getText();
	}
}
