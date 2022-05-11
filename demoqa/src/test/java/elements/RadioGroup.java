package elements;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import extensions.RadioButtonExtension;
import framework.PageObjectBase;

public class RadioGroup extends PageObjectBase {
	protected static RadioButtonExtension radioButtonExtension;
	
	@FindBy(xpath="//*[@id=\"app\"]//div/label")
	private List<WebElement> elements;
	
	WebElement getElement = null;
	
	public RadioGroup(WebDriver driver) {
		super(driver);
	}

	public RadioButton getButton(String label) {
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
