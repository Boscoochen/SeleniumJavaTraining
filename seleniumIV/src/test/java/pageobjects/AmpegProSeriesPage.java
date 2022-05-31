package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.PageObjectBase;

public class AmpegProSeriesPage extends PageObjectBase {

	public AmpegProSeriesPage(WebDriver driver) {
		super(driver);
	}
	
	public AmpegProSeriesSVT3PRODetailsPage clickOnSVT_3PROProduct() {
		WebElement element = super.getDriver().findElement(By.xpath("//*[@id=\"seriesHome\"]/table/tbody/tr[1]/td[1]/a"));
		element.click();
		return new AmpegProSeriesSVT3PRODetailsPage(super.getDriver());
	}
}
