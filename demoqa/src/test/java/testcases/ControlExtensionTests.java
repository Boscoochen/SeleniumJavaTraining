package testcases;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;

import org.testng.annotations.Test;

import framework.SeleniumTestBase;
import page.buttonpage;
import page.hyperlinkpage;
import page.selectmenupage;
import page.sliderpage;

public class ControlExtensionTests extends SeleniumTestBase{
	@Test
	public void canSelectYesRadioButton() {
		String yes = "Yes";
		
		String selectYes = new buttonpage(this.getDriver())
				.navigate()
				.getButton(yes)
				.select()
				.getSelected();
				
		assertEquals(selectYes, yes);
	}
	
	@Test
	public void canSelectImpressiveRadioButton() {
		String impressive = "Impressive";
		
		String selectImpressive = new buttonpage(this.getDriver())
				.navigate()
				.getButton(impressive)
				.select()
				.getSelected();
		
//		System.out.println(selectImpressive);
		assertEquals(selectImpressive, impressive);
	}
	
	@Test
	public void canSelectNoRadioButton() {
		String no = "No";
		
		String selectNo = new buttonpage(this.getDriver())
				.navigate()
				.getButton(no)
				.select()
				.getSelected();
		
//		System.out.println(selectNo);
		assertEquals(selectNo, no);
	}
	
	@Test
	public void canClickOnHyperLink() {
		String actualResult =  "Link has responded with staus 401 and status text Unauthorized";
		
		String expectedResultString = new hyperlinkpage(this.getDriver())
				.navigate()
				.clickOnLink()
				.getLinkResultValue();
		
		assertEquals(expectedResultString, actualResult);

	}
	
	@Test
	public void selectSliderValueTo80() throws InterruptedException {
		int actualValue = 80;
		int expectedValue = new sliderpage(this.getDriver())
				.navigate()
				.getSlider()
				.setValue(actualValue);
		
		System.out.println(expectedValue);
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void selectSliderValueTo17() throws InterruptedException {
		int actualValue = 17;
		int expectedValue = new sliderpage(this.getDriver())
				.navigate()
				.getSlider()
				.setValue(actualValue);
		
		System.out.println(expectedValue);
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void selectSliderValueTo0() throws InterruptedException {
		int actualValue = 0;
		int expectedValue = new sliderpage(this.getDriver())
				.navigate()
				.getSlider()
				.setValue(actualValue);
		
		System.out.println(expectedValue);
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void selectSliderValueTo100() throws InterruptedException {
		int actualValue = 100;
		int expectedValue = new sliderpage(this.getDriver())
				.navigate()
				.getSlider()
				.setValue(actualValue);
		
		System.out.println(expectedValue);
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void selectMenuPurple() {
		int actualColorIndex = 4;
		int expectedColorIndex = new selectmenupage(this.getDriver())
				.navigate()
				.getSelectMenu()
				.getSelectMenuValue();
		
		System.out.println(expectedColorIndex);
		assertEquals(expectedColorIndex, actualColorIndex);
	}
	
	@Test
	public void getAllSelectMenuValue() {
		String[] actualAllColorValueArray = {"Red","Blue","Green","Yellow","Purple","Black","White","Voilet","Indigo","Magenta","Aqua"};
		String[] expectedAllColorValueArray = new selectmenupage(this.getDriver())
				.navigate()
				.getSelectMenu()
				.getAllSelectMenuValue();
		
//		for (String color : expectedAllColorValueArray) {
//			System.out.println(color);
//		}
		
		assertEquals(expectedAllColorValueArray, actualAllColorValueArray);
		
	
	}
	
	
}
