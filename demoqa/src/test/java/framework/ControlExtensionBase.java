package framework;

import org.openqa.selenium.WebElement;

public abstract class ControlExtensionBase{
	private WebElement wrappedElement;
	
	public ControlExtensionBase(WebElement element) {
		this.wrappedElement = element;
	}
	
	//need to change to select 
	public void selectButton(String text) {
		
		if(!this.wrappedElement.isSelected()) {
			this.wrappedElement.click();
		}
	}
	
	
	
	//get the button value
	public String getValue() {
		return this.wrappedElement.getText();
	}
}
