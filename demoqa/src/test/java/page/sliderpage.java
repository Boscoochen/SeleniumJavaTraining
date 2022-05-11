package page;

import org.openqa.selenium.WebDriver;

import elements.Slider;
import framework.PageObjectBase;

public class sliderpage extends PageObjectBase{
	private static final String URL = "https://demoqa.com/slider";

	public sliderpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public Slider navigate() {
		super.getDriver().get(URL);
		return new Slider(this.getDriver());
	}

}
