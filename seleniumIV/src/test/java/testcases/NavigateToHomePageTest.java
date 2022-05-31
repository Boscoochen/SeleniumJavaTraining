package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.SeleniumTestBase;
import pageobjects.AmpegProSeriesPage;
import pageobjects.AmpegProSeriesSVT3PRODetailsPage;
import pageobjects.AmpegProductDirectoryPage;
import pageobjects.HomePage;

public class NavigateToHomePageTest extends SeleniumTestBase{
	@Test
	public void navigateToHomePageTest() {
		String url = new HomePage(super.getDriver())
				.navigateToHomePage()
				.clickProductsButton()
				.clickOnSVTPROSERIESBassHeadsProduct()
				.clickOnSVT_3PROProduct()
				.navigateToHomePage()
				.getHomePageUrl();
		
		System.out.println(url);
		assertEquals(url, "https://ampeg.com/index.html");
	}
}
