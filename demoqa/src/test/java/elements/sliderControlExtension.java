package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import framework.ControlExtensionBase;

public class sliderControlExtension extends ControlExtensionBase {
	static Action action;
	public sliderControlExtension(WebElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public static void setValue(int value, WebDriver webDriver, WebElement element) {
		
		Actions move = new Actions(webDriver);
		
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
	}
	
	public static int getValue(WebElement element) {
		return Integer.parseInt(element.getAttribute("value"));
	}
	

}
