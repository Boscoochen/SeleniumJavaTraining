package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import page.selectmenupage;

public class SelectMenu extends selectmenupage{
	WebElement element;
	public SelectMenu(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public SelectMenu getSelectMenu() {
		element = this.getDriver().findElement(By.id("oldSelectMenu"));
		return this;
	}
	
	public SelectMenu selectColor() {
		selectMenuControlExtension.selectColor(element);
		return this;
	}
	
	
	public int getSelectMenuValue() {
		return selectMenuControlExtension.getColorValue(element);
	}
	
	public String[] getAllSelectMenuValue() {
		return selectMenuControlExtension.getAllColorValue(element);
	}
	

}
