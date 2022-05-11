package extensions;

import org.openqa.selenium.WebElement;

import framework.ControlExtensionBase;

public class HyperLinkControlExtension extends ControlExtensionBase{

	
	
	
	public HyperLinkControlExtension(WebElement element) {
		super(element);
		this.wrappedElement = element;
	}

	public void selectLink() {
		this.wrappedElement.click();
	}
	
	

}
