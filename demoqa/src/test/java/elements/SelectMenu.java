package elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import extensions.selectMenuControlExtension;
import page.selectmenupage;

public class SelectMenu extends selectmenupage{
	WebElement element;
	
	@FindBy(id="oldSelectMenu")
	private WebElement selectMenuElement;
	
	public SelectMenu(WebDriver driver) {
		super(driver);
	}
	
	public SelectMenu selectColor() {
		new selectMenuControlExtension(selectMenuElement).selectColor();
		return this;
	}
	
	
	public int getSelectMenuValue() {
		return new selectMenuControlExtension(selectMenuElement).getColorValue();
	}
	
	public String[] getAllSelectMenuValue() {
		return new selectMenuControlExtension(selectMenuElement).getAllColorValue();
	}
	

}
