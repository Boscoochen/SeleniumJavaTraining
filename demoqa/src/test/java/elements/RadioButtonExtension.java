package elements;

import org.openqa.selenium.WebElement;

import framework.ControlExtensionBase;

public class RadioButtonExtension extends ControlExtensionBase {

	public RadioButtonExtension(WebElement element) {
		super(element);
		// TODO Auto-generated constructor stub
		this.wrappedElement = element;
	}

	
	//need to change to select 
	public void selectButton() {
		this.wrappedElement.click();
	}
}