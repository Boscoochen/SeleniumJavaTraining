package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import foundation.PageObjectBase;

public class AmpegClassicSeriesPage extends PageObjectBase {
	@FindBy(xpath = "//*[@id=\"seriesHome\"]/table/tbody/tr[3]/td[4]")
	private WebElement sVT410HLFProductLinkElement;

	public AmpegClassicSeriesPage(WebDriver driver) {
		super(driver);
	}

	public SVT410HLFDetailsPage clickOnSVT410HLFProductLink() {
		sVT410HLFProductLinkElement.click();
		return new SVT410HLFDetailsPage(super.getDriver());
	}
}