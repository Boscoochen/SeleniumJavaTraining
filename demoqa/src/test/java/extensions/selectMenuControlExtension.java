package extensions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import framework.ControlExtensionBase;

public class selectMenuControlExtension extends ControlExtensionBase {

	public selectMenuControlExtension(WebElement element) {
		super(element);
		this.wrappedElement = element;
	}

	public void selectColor() {
		Select select = new Select(this.wrappedElement);
		select.selectByValue("4");
	}

	public int getColorValue() {
		return Integer.parseInt(this.wrappedElement.getAttribute("value"));
	}

	public String[] getAllColorValue() {
		String colorValueArray[] = this.wrappedElement.getText().split("\n");
		return colorValueArray;
	}

}
