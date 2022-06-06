package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import foundation.SeleniumTestBase;
import pageobjects.HomePage;

public class ExtractArtistNameTest extends SeleniumTestBase{
	@Test
	public void getArtistNameForProductSVT_410HLFTest() throws IOException {
		String artistName = new HomePage(super.getDriverManager().getDriver())
				.navigateToHomePage()
				.clickProductsButton()
				.clickProductsCLASSICSERIESBassHeadsandEnclosuresButton()
				.clickOnSVT410HLFProductLink()
				.getArtistName();
		
		assertEquals(artistName, "Bootsy Collins");
	}
}
