package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import foundation.PageObjectBase;

public class AmpegProSeriesSVT3PRODetailsPage extends PageObjectBase {
	@FindBy(xpath = "//*[@id=\"navLinks\"]/a[1]")
	private WebElement homePageElement;

	public AmpegProSeriesSVT3PRODetailsPage(WebDriver driver) {
		super(driver);
	}

	public HomePage navigateToHomePage() {
		homePageElement.click();
		return new HomePage(super.getDriver());
	}
}
