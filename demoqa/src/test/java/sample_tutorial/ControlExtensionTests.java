package sample_tutorial;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import framework.SeleniumTestBase;

public class ControlExtensionTests extends SeleniumTestBase {
	@Test
	public void canEnterTextIntoTextBox() {
		String fullName = "Dennis Taylor";
		String enteredFullName = new TextBoxPage(this.getDriver())
			.navigate()
			.enterFullName(fullName)
			.getFullName();
		
		assertEquals(enteredFullName, fullName, "the text sent to the textbox should match the textbox current value");
	}
	
	@Test
	public void canEnterTextIntoTextBox2() {
		String address = "110 Main";
		String enteredCurrentAddress = new TextBoxPage(this.getDriver())
			.navigate()
			.enterCurrentAddress(address)
			.getCurrentAddress();
		
		assertEquals(enteredCurrentAddress, address, "the text sent to the textbox should match the textbox current value");
	}
}
