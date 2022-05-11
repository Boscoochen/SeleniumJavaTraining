package elements;

import org.openqa.selenium.WebElement;

import framework.ControlExtensionBase;

public class HyperLinkControlExtension extends ControlExtensionBase{

	
	
	
	public HyperLinkControlExtension(WebElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public void selectLink() {
		super.wrappedElement.click();
	}
	
	

}
