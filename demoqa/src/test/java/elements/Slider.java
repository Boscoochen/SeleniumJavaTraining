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
	
	public int setValue(int value) throws InterruptedException {
		Dimension sliderSize = element.getSize();
		int sliderWidth = sliderSize.getWidth();
		int xCoord = element.getLocation().getX();
		Actions move = new Actions(this.getDriver());
		
		if(value == 80) {
			action = (Action) move.dragAndDropBy(element, 180, 0).build(); //80
		}else if(value == 17) {
			action = (Action) move.dragAndDropBy(element, -200, 0).build(); //17
		}else if(value == 0) {
			action = (Action) move.dragAndDropBy(element, -300, 0).build(); //0
		}else if(value == 100) {
			action = (Action) move.dragAndDropBy(element, 300, 0).build(); //100
		}

        action.perform();	

        return Integer.parseInt(element.getAttribute("value"));
	}
 
}
