package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class RadioGroup extends PageObjectBase {
	protected static RadioButtonExtension radioButtonExtension;
	
	@FindBy(xpath="//*[@id=\"app\"]//div/label")
	private List<WebElement> elements;
	
	WebElement getElement = null;
	
	public RadioGroup(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public RadioButton getButton(String label) {
		//1.need to find the button element first
//		List<WebElement> element = this.getDriver().findElements(By.xpath("//*[@id=\"app\"]//div/label"));
//		System.out.println("=======" + element.get(2).getText());
		//2.wrap up
		
		for (WebElement webElement : elements) {
			if(label.equals(webElement.getText())) {
				getElement = webElement;
			}
		}
		radioButtonExtension = new RadioButtonExtension(getElement);
		return new RadioButton(this.getDriver());
	}

	public String getSelected() {
		return radioButtonExtension.getValue();
	}
}
