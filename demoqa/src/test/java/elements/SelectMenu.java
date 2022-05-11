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
		Select select = new Select(element);
		select.selectByValue("4");
		return this;
	}
	
	
	public int getSelectMenuValue() {
		return Integer.parseInt(element.getAttribute("value"));
	}
	
	public String[] getAllSelectMenuValue() {
		String colorValueArray[] = element.getText().split("\n");
		return colorValueArray;
	}
	

}
