package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.PageObjectBase;

public class AmpegProductDirectoryPage extends PageObjectBase {

	public AmpegProductDirectoryPage(WebDriver driver) {
		super(driver);
	}
	
	public AmpegProSeriesPage clickOnSVTPROSERIESBassHeadsProduct() {
		WebElement element = super.getDriver().findElement(By.xpath("//*[@id=\"productIndex\"]/table/tbody/tr[2]/td[3]"));
		element.click();
		return new AmpegProSeriesPage(super.getDriver());
	}
	
	public AmpegClassicSeriesPage clickProductsCLASSICSERIESBassHeadsandEnclosuresButton() {
		WebElement element = super.getDriver().findElement(By.xpath("//*[@id=\"productIndex\"]/table/tbody/tr[2]/td[1]"));
		element.click();
		return new AmpegClassicSeriesPage(super.getDriver());
	}
}
