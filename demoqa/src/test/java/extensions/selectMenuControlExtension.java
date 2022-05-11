package extensions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import framework.ControlExtensionBase;

public class selectMenuControlExtension extends ControlExtensionBase {

	public selectMenuControlExtension(WebElement element) {
		super(element);
		this.wrappedElement = element;
	}

	public void selectColor(String colorIndex) {
		Select select = new Select(this.wrappedElement);
		select.selectByValue(colorIndex);
	}

	public String getColorValue() {
		return this.wrappedElement.getAttribute("value");
	}

	public String[] getAllColorValue() {
		String colorValueArray[] = this.wrappedElement.getText().split("\n");
		return colorValueArray;
	}

}
