package extensions;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import framework.ControlExtensionBase;

public class RadioButtonExtension extends ControlExtensionBase {
	private static boolean flag;

	public RadioButtonExtension(WebElement element) {
		super(element);
		this.wrappedElement = element;
	}

	public void selectButton(WebDriver driver) {
		this.wrappedElement.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean isSelected = (Boolean) js.executeScript("return document.getElementById('"
				+ this.wrappedElement.getText().toLowerCase() + "Radio" + "').checked");
		boolean isDisableButton = (Boolean) js.executeScript("return document.getElementById('"
				+ this.wrappedElement.getText().toLowerCase() + "Radio" + "').disabled");
		
		if (!isSelected && isDisableButton) {
			flag = true;
		}
		
		if (!isSelected && !isDisableButton) {
			throw new RuntimeException("label button not be selected");
		}
	}

	public WebElement findButton(String label, List<WebElement> elements, WebDriver driver) {
		if (!(label.equals("No") || label.equals("Yes") || label.equals("Impressive"))) {
			throw new RuntimeException("the label + '" + label + "' could not found");
		}

		for (WebElement webElement : elements) {
			if (label.equals(webElement.getText())) {
				this.wrappedElement = webElement;
			}
		}

		return this.wrappedElement;
	}

	@Override
	public String getValue() {
		if (flag) {
			flag = false;
			return "button is not clickable";
		}
		return super.getValue();
	}
}
