package sample;

import org.openqa.selenium.WebElement;

public class TextBoxControlExtension {

	private WebElement wrappedElement;

	public TextBoxControlExtension(WebElement element) {
		this.wrappedElement = element;
	}

	public void setValue(String text) {
		// TODO Auto-generated method stub
		this.wrappedElement.sendKeys(text);
		//maybe need to wait for the value comapre?
		if(!this.getValue().equals(text)) {
			throw new RuntimeException("The text could not be set to " + text);
		}
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return this.wrappedElement.getAttribute("value");

	}

}
