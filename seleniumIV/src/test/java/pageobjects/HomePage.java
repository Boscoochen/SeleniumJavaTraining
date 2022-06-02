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
	private Setting setting;

	public HomePage(WebDriver driver) {
		super(driver);
		setting = new Setting();
	}

	public HomePage navigateToHomePage() throws IOException {
		String url = setting.readPropertiesFile("url").toLowerCase();
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
