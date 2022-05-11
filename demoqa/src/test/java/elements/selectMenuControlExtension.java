package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import framework.ControlExtensionBase;

public class selectMenuControlExtension extends ControlExtensionBase {

	public selectMenuControlExtension(WebElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public static void selectColor(WebElement element) {
		// TODO Auto-generated method stub
		Select select = new Select(element);
		select.selectByValue("4");
	}

	public static int getColorValue(WebElement element) {
		// TODO Auto-generated method stub
		return Integer.parseInt(element.getAttribute("value"));
	}

	public static String[] getAllColorValue(WebElement element) {
		// TODO Auto-generated method stub
		String colorValueArray[] = element.getText().split("\n");
		return colorValueArray;
	}

}
