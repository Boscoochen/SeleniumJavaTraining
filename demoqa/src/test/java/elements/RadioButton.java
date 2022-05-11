package elements;
import org.openqa.selenium.WebDriver;

public class RadioButton extends RadioGroup {
	public RadioButton(WebDriver driver) {
		super(driver);
	}

	public RadioGroup select() {
		radioButtonExtension.selectButton();
		return new RadioGroup(this.getDriver());
	}
}
