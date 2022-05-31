package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import foundation.PageObjectBase;

public class AmpegProSeriesPage extends PageObjectBase {
	@FindBy(xpath = "//*[@id=\"seriesHome\"]/table/tbody/tr[1]/td[1]/a")
	private WebElement sVT_3PROProductElement;

	public AmpegProSeriesPage(WebDriver driver) {
		super(driver);
	}

	public AmpegProSeriesSVT3PRODetailsPage clickOnSVT_3PROProduct() {
		sVT_3PROProductElement.click();
		return new AmpegProSeriesSVT3PRODetailsPage(super.getDriver());
	}
}
