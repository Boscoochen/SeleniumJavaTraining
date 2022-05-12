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
		String Acutalresult = "button is not clickable";
		
		String selectNo = new buttonpage(this.getDriver())
				.navigate()
				.getButton(no)
				.select()
				.getSelected();

		assertEquals(selectNo, Acutalresult);
	}
	
	@Test
	public void canClickOnHyperLink() {
		String actualResult =  "Link has responded with staus 401 and status text Unauthorized";
		
		String expectedResultString = new hyperlinkpage(this.getDriver())
				.navigate()
				.clickOnLink("Unauthorized")
				.getLinkResultValue();
		
		assertEquals(expectedResultString, actualResult);
	}
	
	@Test
	public void selectSliderValueTo80() {
		int expectedValue = new sliderpage(this.getDriver())
				.navigate()
				.setValue(80)
				.getValue();
		
		assertEquals(expectedValue, 80);
	}
	
	@Test
	public void selectSliderValueTo17() {
		int expectedValue = new sliderpage(this.getDriver())
				.navigate()
				.setValue(17)
				.getValue();
		
		assertEquals(expectedValue, 17);
	}
	
	@Test
	public void selectSliderValueTo0() {
		int expectedValue = new sliderpage(this.getDriver())
				.navigate()
				.setValue(0)
				.getValue();
		
		assertEquals(expectedValue, 0);
	}
	
	@Test
	public void selectSliderValueTo100() {
		int expectedValue = new sliderpage(this.getDriver())
				.navigate()
				.setValue(100)
				.getValue();
		
		assertEquals(expectedValue, 100);
	}
	
	@Test
	public void selectMenuPurple() {
		String actualColorIndex = "4";
		String expectedColorIndex = new selectmenupage(this.getDriver())
				.navigate()
				.selectColor("4")
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
