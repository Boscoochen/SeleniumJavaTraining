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
		if(!colorIndex.equals(this.getValue())) {
			throw new RuntimeException("the color index you want to click is '" + colorIndex + "' Actual label you clicked is '" + this.getValue() + "'");
		}
	}
	
	@Override
	public String getValue() {
		return this.wrappedElement.getAttribute("value");
	}

	public String[] getAllColorValue() {
		String colorValueArray[] = this.wrappedElement.getText().split("\n");
		return colorValueArray;
	}
}
