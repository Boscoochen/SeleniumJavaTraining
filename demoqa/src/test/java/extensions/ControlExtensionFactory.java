package extensions;

import org.openqa.selenium.WebElement;

public class ControlExtensionFactory {

	public static RadioButtonExtension getRadioButton(WebElement element) {
		return new RadioButtonExtension(element);
	}

}
