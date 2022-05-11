package elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import extensions.sliderControlExtension;
import framework.PageObjectBase;

public class Slider extends PageObjectBase{
	WebElement element;
	Action action;
	
	@FindBy(xpath="//*[@id=\"sliderContainer\"]/div[1]/span/input")
	private WebElement sliderElement;
	
	public Slider(WebDriver driver) {
		super(driver);
	}
	
	public Slider setValue(int value) {
		
		new sliderControlExtension(sliderElement).setValue(value, getDriver());
		return this;
	}
	
	public int getValue() {
		return new sliderControlExtension(sliderElement).getValue(sliderElement);
	}
 
}
