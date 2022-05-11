package page;

import org.openqa.selenium.WebDriver;

import elements.HyperLink;
import framework.PageObjectBase;

public class hyperlinkpage extends PageObjectBase{
	private static final String URL = "https://demoqa.com/links";

	public hyperlinkpage(WebDriver driver) {
		super(driver);
	}

	public HyperLink navigate() {
		super.getDriver().get(URL);
		return new HyperLink(this.getDriver());
	}

}
