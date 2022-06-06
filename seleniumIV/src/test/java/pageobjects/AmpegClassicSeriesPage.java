package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import foundation.PageObjectBase;

public class AmpegClassicSeriesPage extends PageObjectBase {
	@FindBy(xpath = "//*[@id=\"seriesHome\"]//*[@href=\"svt410hlf/\"]")
	private WebElement sVT410HLFProductLinkElement;

	public AmpegClassicSeriesPage(WebDriver driver) {
		super(driver);
	}

	public SVT410HLFDetailsPage clickOnSVT410HLFProductLink() {
		sVT410HLFProductLinkElement.click();
		return new SVT410HLFDetailsPage(super.getDriver());
	}
}
