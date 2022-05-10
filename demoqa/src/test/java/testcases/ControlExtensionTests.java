package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import framework.SeleniumTestBase;
import page.buttonpage;

public class ControlExtensionTests extends SeleniumTestBase{
	@Test
	public void canSelectYesRadioButton() {
		String yes = "Yes";
		
		String selectYes = new buttonpage(this.getDriver())
				.navigate()
				.getButton(0)
				.select(yes)
				.getSelected();
		
//		System.out.println(selectYes);
		assertEquals(selectYes, yes);
	}
	
	@Test
	public void canSelectImpressiveRadioButton() {
		String impressive = "Impressive";
		
		String selectImpressive = new buttonpage(this.getDriver())
				.navigate()
				.getButton(1)
				.select(impressive)
				.getSelected();
		
//		System.out.println(selectImpressive);
		assertEquals(selectImpressive, impressive);
	}
	
	@Test
	public void canSelectNoRadioButton() {
		String no = "No";
		
		String selectNo = new buttonpage(this.getDriver())
				.navigate()
				.getButton(2)
				.select(no)
				.getSelected();
		
//		System.out.println(selectNo);
		assertEquals(selectNo, no);
	}
}
