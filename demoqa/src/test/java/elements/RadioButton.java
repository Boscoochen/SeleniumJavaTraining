package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;
import framework.ControlExtensionBase;

public class RadioButton extends RadioGroup {
	
	//create selectButtonControl extention to extend controlbase
	public RadioButton(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public RadioGroup select(String label) {
		radioButtonExtension.selectButton();
		return new RadioGroup(this.getDriver());
	}
}
