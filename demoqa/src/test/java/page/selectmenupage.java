package page;

import org.openqa.selenium.WebDriver;

import elements.SelectMenu;
import framework.PageObjectBase;

public class selectmenupage extends PageObjectBase{
	private static final String URL = "https://demoqa.com/select-menu";

	
	public selectmenupage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public SelectMenu navigate() {
		super.getDriver().get(URL);
		return new SelectMenu(this.getDriver());
	}

}
