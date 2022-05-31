package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import foundation.PageObjectBase;

public class SVT410HLFDetailsPage extends PageObjectBase {
	@FindBy(xpath = "//*[@id=\"artist\"]/p/b")
	private WebElement artistNameElement;

	public SVT410HLFDetailsPage(WebDriver driver) {
		super(driver);
	}

	public String getArtistName() {
		return artistNameElement.getText();
	}
}
