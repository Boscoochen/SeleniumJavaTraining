package elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton extends RadioGroup {
	public RadioButton(WebDriver driver, WebElement getElement) {
		super(driver, getElement);
	}

	public RadioGroup select(String label) {
		getControlExtensionFactory().getRadioButton(getElement).selectButton(label, this.getDriver());
		return new RadioGroup(this.getDriver(), getElement);
	}
}
