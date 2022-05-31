package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import foundation.PageObjectBase;

public class HomePage extends PageObjectBase{
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage navigateToHomePage() {
		super.getDriver().get("http://www.ampeg.com");
		return this;
	}
	
	public AmpegProductDirectoryPage clickProductsButton() {
		WebElement element = super.getDriver().findElement(By.xpath("//*[@id=\"global-topnav\"]/ul/li[1]/a"));
		element.click();
		return new AmpegProductDirectoryPage(super.getDriver());
	}
	
	public String getHomePageUrl() {
		return super.getDriver().getCurrentUrl();
	}
}
