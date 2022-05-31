package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.PageObjectBase;

public class AmpegProSeriesSVT3PRODetailsPage extends PageObjectBase {

	public AmpegProSeriesSVT3PRODetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage navigateToHomePage() {
		WebElement element = super.getDriver().findElement(By.xpath("//*[@id=\"navLinks\"]/a[1]"));
		element.click();
		return new HomePage(super.getDriver());
	}
}
