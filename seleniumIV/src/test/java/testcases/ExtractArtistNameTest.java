package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.SeleniumTestBase;
import pageobjects.HomePage;

public class ExtractArtistNameTest extends SeleniumTestBase{
	@Test
	public void getArtistNameForProductSVT_410HLFChromeVersionTest() {
		String artistName = new HomePage(super.getChromeDriverManager().getDriver())
				.navigateToHomePage()
				.clickProductsButton()
				.clickProductsCLASSICSERIESBassHeadsandEnclosuresButton()
				.clickOnSVT410HLFProductLink()
				.getArtistName();
		
		assertEquals(artistName, "Bootsy Collins");
	}
	
	@Test
	public void getArtistNameForProductSVT_410HLFEdgeVersionTest() {
		String artistName = new HomePage(super.getEdgeDriverManager().getDriver())
				.navigateToHomePage()
				.clickProductsButton()
				.clickProductsCLASSICSERIESBassHeadsandEnclosuresButton()
				.clickOnSVT410HLFProductLink()
				.getArtistName();
		
		assertEquals(artistName, "Bootsy Collins");
	}
}
