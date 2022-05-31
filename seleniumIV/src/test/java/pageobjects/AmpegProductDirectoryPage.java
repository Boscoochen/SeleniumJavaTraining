package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import foundation.PageObjectBase;

public class AmpegProductDirectoryPage extends PageObjectBase {
	@FindBy(xpath = "//*[@id=\"productIndex\"]/table/tbody/tr[2]/td[3]")
	private WebElement sVTPROSERIESBassHeadsProductElement;

	@FindBy(xpath = "//*[@id=\"productIndex\"]/table/tbody/tr[2]/td[1]")
	private WebElement cLASSICSERIESBassHeadsandEnclosuresButtonElement;

	public AmpegProductDirectoryPage(WebDriver driver) {
		super(driver);
	}

	public AmpegProSeriesPage clickOnSVTPROSERIESBassHeadsProduct() {
		sVTPROSERIESBassHeadsProductElement.click();
		return new AmpegProSeriesPage(super.getDriver());
	}

	public AmpegClassicSeriesPage clickProductsCLASSICSERIESBassHeadsandEnclosuresButton() {
		cLASSICSERIESBassHeadsandEnclosuresButtonElement.click();
		return new AmpegClassicSeriesPage(super.getDriver());
	}
}