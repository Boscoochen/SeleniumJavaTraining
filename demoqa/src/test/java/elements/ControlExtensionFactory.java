package elements;

import org.openqa.selenium.WebElement;

public class ControlExtensionFactory {

	public static RadioButtonExtension getRadioButton(WebElement element) {
		// TODO Auto-generated method stub
		return new RadioButtonExtension(element);
	}

}
