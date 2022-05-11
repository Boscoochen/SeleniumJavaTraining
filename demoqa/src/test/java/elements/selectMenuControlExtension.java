package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import framework.ControlExtensionBase;

public class selectMenuControlExtension extends ControlExtensionBase {

	public selectMenuControlExtension(WebElement element) {
		super(element);
		// TODO Auto-generated constructor stub
		this.wrappedElement = element;
	}

	public void selectColor() {
		// TODO Auto-generated method stub
		Select select = new Select(this.wrappedElement);
		select.selectByValue("4");
	}

	public int getColorValue() {
		// TODO Auto-generated method stub
		return Integer.parseInt(this.wrappedElement.getAttribute("value"));
	}

	public String[] getAllColorValue() {
		// TODO Auto-generated method stub
		String colorValueArray[] = this.wrappedElement.getText().split("\n");
		return colorValueArray;
	}

}
