package framework;
import org.openqa.selenium.WebElement;

public abstract class ControlExtensionBase{
	public WebElement wrappedElement;
	
	public ControlExtensionBase(WebElement element) {
		this.wrappedElement = element;
	}

	public String getValue() {
		return this.wrappedElement.getText();
	}
}
