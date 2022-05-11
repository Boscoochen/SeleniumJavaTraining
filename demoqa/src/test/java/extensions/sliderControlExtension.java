package extensions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import framework.ControlExtensionBase;

public class sliderControlExtension extends ControlExtensionBase {
	private static Action action;
	public sliderControlExtension(WebElement element) {
		super(element);
		this.wrappedElement = element;
	}

	public void setValue(int value, WebDriver webDriver) {
		if(!(value == 80 || value == 0 || value == 100 || value == 17)) {
			throw new RuntimeException("this test case can only set slider range value (80, 17, 0, 100)");
		}
		
		Actions move = new Actions(webDriver);
		if(value == 80) {
			action = (Action) move.dragAndDropBy(this.wrappedElement, 180, 0).build(); 
		}else if(value == 17) {
			action = (Action) move.dragAndDropBy(this.wrappedElement, -200, 0).build();
		}else if(value == 0) {
			action = (Action) move.dragAndDropBy(this.wrappedElement, -300, 0).build();
		}else if(value == 100) {
			action = (Action) move.dragAndDropBy(this.wrappedElement, 300, 0).build();
		}
        action.perform();
        
        if(!(value == this.getValue(this.wrappedElement))) {
			throw new RuntimeException("the slider value you want to set is '" + value + "' Actual slider value was '" + this.getValue(this.wrappedElement) + "'");
        }
	}
	
	public int getValue(WebElement element) {
		return Integer.parseInt(element.getAttribute("value"));
	}
}
