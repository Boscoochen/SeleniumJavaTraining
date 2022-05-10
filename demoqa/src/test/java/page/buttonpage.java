package page;

import org.openqa.selenium.WebDriver;

import elements.RadioButton;
import elements.RadioGroup;
import framework.PageObjectBase;

public class buttonpage extends PageObjectBase{
	private static final String URL = "https://demoqa.com/radio-button";
	public buttonpage(WebDriver driver) {
		super(driver);
	}
	
	public RadioGroup navigate() {
		super.getDriver().get(URL);
		return new RadioGroup(this.getDriver());
	}
	
}
