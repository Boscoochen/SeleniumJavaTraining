package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.PageObjectBase;

public class AmpegClassicSeriesPage extends PageObjectBase {

	public AmpegClassicSeriesPage(WebDriver driver) {
		super(driver);
	}
	
	public SVT410HLFDetailsPage clickOnSVT410HLFProductLink() {
		WebElement element = super.getDriver().findElement(By.xpath("//*[@id=\"seriesHome\"]/table/tbody/tr[3]/td[4]"));
		element.click();
		return new SVT410HLFDetailsPage(super.getDriver());
	}
}
