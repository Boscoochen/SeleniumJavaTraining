package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import framework.PageObjectBase;

public class Slider extends PageObjectBase{
	WebElement element;
	Action action;
	public Slider(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public Slider getSlider() {
		element = this.getDriver().findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
		return this;
	}
	
	public Slider setValue(int value) {
		
		sliderControlExtension.setValue(value, this.getDriver(), element);
		return this;
	}
	
	public int getValue() {
		return sliderControlExtension.getValue(element);
//		return Integer.parseInt(element.getAttribute("value"));
	}
 
}
