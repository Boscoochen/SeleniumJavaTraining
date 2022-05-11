package elements;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.buttonpage;

public class RadioGroup extends buttonpage {
	@FindBy(xpath="//*[@id=\"app\"]//div/label")
	private List<WebElement> elements;
	
	public WebElement getElement;
	
	public RadioGroup(WebDriver driver, WebElement getElement) {
		super(driver);
		this.getElement = getElement;
	}

	public RadioButton getButton(String label) {
		for (WebElement webElement : elements) {
			if(label.equals(webElement.getText())) {
				this.getElement = webElement;
			}
		}
		getControlExtensionFactory().getRadioButton(this.getElement);
		return new RadioButton(this.getDriver(), this.getElement);
	}

	public String getSelected() {
		return getControlExtensionFactory().getRadioButton(this.getElement).getValue();
	}
}
