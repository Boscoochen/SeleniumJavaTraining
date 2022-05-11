package sample_tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class TextBoxPage extends PageObjectBase {
	private static final String URL = "https://demoqa.com/text-box";
	TextBoxControlExtension textboxControlExtension;
	
	public TextBoxPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public TextBoxPage navigate() {
		this.getDriver().get(URL);
		return this;
	}

	public TextBoxPage enterFullName(String fullName) {
		//find the element
		WebElement element = this.getDriver().findElement(By.id("userName"));
		//wrap up element
		textboxControlExtension = new TextBoxControlExtension(element);
		textboxControlExtension.setValue(fullName);
//		element.sendKeys(fullName);
		return this;
	}

	public String getFullName() {
		//find the element
		this.getDriver().findElement(By.id("userName"));
		//wrap up element
		return textboxControlExtension.getValue();
//		return element.getAttribute("value");
	}

	public TextBoxPage enterCurrentAddress(String address) {
		//find the element
		WebElement element = this.getDriver().findElement(By.id("currentAddress"));
		//wrap up element
		textboxControlExtension = new TextBoxControlExtension(element);
		textboxControlExtension.setValue(address);
		return this;
	}
	
	public String getCurrentAddress() {
		//find the element
		this.getDriver().findElement(By.id("currentAddress"));
		//wrap up element
		return textboxControlExtension.getValue();
//		return element.getAttribute("value");
	}

}
