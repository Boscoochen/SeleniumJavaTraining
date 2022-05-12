package elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.selectmenupage;

public class SelectMenu extends selectmenupage{	
	@FindBy(id="oldSelectMenu")
	private WebElement selectMenuElement;
	public SelectMenu(WebDriver driver) {
		super(driver);
	}
	
	public SelectMenu selectColor(String colorIndex) {
		getControlExtensionFactory().getSelectMenu(selectMenuElement).selectColor(colorIndex);
		return this;
	}
	
	public String getSelectMenuValue() {
		return getControlExtensionFactory().getSelectMenu(selectMenuElement).getValue();
	}
	
	public String[] getAllSelectMenuValue() {
		return getControlExtensionFactory().getSelectMenu(selectMenuElement).getAllColorValue();
	}
}
