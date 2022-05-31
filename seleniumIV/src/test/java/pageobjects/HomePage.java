package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import foundation.PageObjectBase;
import util.Setting;

public class HomePage extends PageObjectBase {
	@FindBy(xpath = "//*[@id=\"global-topnav\"]/ul/li[1]/a")
	private WebElement productsButtonElement;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage navigateToHomePage() throws IOException {
		String url = Setting.readPropertiesFile("url").toLowerCase();
		super.getDriver().get(url);
		return this;
	}

	public AmpegProductDirectoryPage clickProductsButton() {
		productsButtonElement.click();
		return new AmpegProductDirectoryPage(super.getDriver());
	}

	public String getHomePageUrl() {
		return super.getDriver().getCurrentUrl();
	}
}
