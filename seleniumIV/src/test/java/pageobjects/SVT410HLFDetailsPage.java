package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import foundation.PageObjectBase;

public class SVT410HLFDetailsPage extends PageObjectBase {

	public SVT410HLFDetailsPage(WebDriver driver) {
		super(driver);
	}

	public String getArtistName() {
		return super.getDriver().findElement(By.xpath("//*[@id=\"artist\"]/p/b")).getText();
	}
}
