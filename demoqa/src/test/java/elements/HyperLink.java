package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class HyperLink extends PageObjectBase{
	protected HyperLinkControlExtension hyperLinkControlExtension;
	public HyperLink(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public HyperLink clickOnLink() {
		WebElement element = this.getDriver().findElement(By.id("unauthorized"));
//		element.click();
		hyperLinkControlExtension = new HyperLinkControlExtension(element);
		
		return this;
	}
	
	public String getLinkResultValue() {
		WebElement element = this.getDriver().findElement(By.id("linkResponse"));

		hyperLinkControlExtension = new HyperLinkControlExtension(element);
		return hyperLinkControlExtension.getValue();
	}
}
