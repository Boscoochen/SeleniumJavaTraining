package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class RadioGroup extends PageObjectBase {
	protected static RadioButtonExtension radioButtonExtension;
	public RadioGroup(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public RadioButton getButton(int i) {
		//1.need to find the button element first
		List<WebElement> element = this.getDriver().findElements(By.xpath("//*[@id=\"app\"]//div/label"));
//		System.out.println("=======" + element.get(2).getText());
		//2.wrap up
		radioButtonExtension = new RadioButtonExtension(element.get(i));
		return new RadioButton(this.getDriver());
	}

	public String getSelected() {
		this.getDriver().findElements(By.xpath("//*[@id=\"app\"]//div/label"));
		return radioButtonExtension.getValue();
	}
}
