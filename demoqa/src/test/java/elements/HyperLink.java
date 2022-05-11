package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class HyperLink extends PageObjectBase{
	public HyperLink(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public HyperLink clickOnLink() {
		WebElement element = this.getDriver().findElement(By.id("unauthorized"));
		new HyperLinkControlExtension(element).selectLink();
		
		return this;
	}
	
	public String getLinkResultValue() {
		WebElement element = this.getDriver().findElement(By.id("linkResponse"));

		return new HyperLinkControlExtension(element).getValue();
	}
}
