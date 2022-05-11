package testcases;
import static org.testng.Assert.assertEquals;
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
	public void selectSliderValueTo80() {
		int actualValue = 80;
		int expectedValue = new sliderpage(this.getDriver())
				.navigate()
				.setValue(actualValue)
				.getValue();
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void selectSliderValueTo17() {
		int actualValue = 17;
		int expectedValue = new sliderpage(this.getDriver())
				.navigate()
				.setValue(actualValue)
				.getValue();
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void selectSliderValueTo0() {
		int actualValue = 0;
		int expectedValue = new sliderpage(this.getDriver())
				.navigate()
				.setValue(actualValue)
				.getValue();
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void selectSliderValueTo100() {
		int actualValue = 100;
		int expectedValue = new sliderpage(this.getDriver())
				.navigate()
				.setValue(actualValue)
				.getValue();
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void selectMenuPurple() {
		int actualColorIndex = 4;
		int expectedColorIndex = new selectmenupage(this.getDriver())
				.navigate()
				.selectColor()
				.getSelectMenuValue();
		
		assertEquals(expectedColorIndex, actualColorIndex);
	}
	
	@Test
	public void getAllSelectMenuValue() {
		String[] actualAllColorValueArray = {"Red","Blue","Green","Yellow","Purple","Black","White","Voilet","Indigo","Magenta","Aqua"};
		String[] expectedAllColorValueArray = new selectmenupage(this.getDriver())
				.navigate()
				.getAllSelectMenuValue();
		
		assertEquals(expectedAllColorValueArray, actualAllColorValueArray);
	}
}
