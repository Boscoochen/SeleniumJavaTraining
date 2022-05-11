package extensions;

import org.openqa.selenium.WebElement;

import framework.ControlExtensionBase;

public class RadioButtonExtension extends ControlExtensionBase {

	public RadioButtonExtension(WebElement element) {
		super(element);
		this.wrappedElement = element;
	}

	public void selectButton() {
		this.wrappedElement.click();
	}
}
