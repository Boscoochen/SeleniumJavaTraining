package testcases;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import foundation.SeleniumTestBase;
import pageobjects.HomePage;

public class NavigateToHomePageTest extends SeleniumTestBase{
	@Test
	public void navigateToHomePageChromeVersionTest() {
		String url = new HomePage(super.getChromeDriverManager().getDriver())
				.navigateToHomePage()
				.clickProductsButton()
				.clickOnSVTPROSERIESBassHeadsProduct()
				.clickOnSVT_3PROProduct()
				.navigateToHomePage()
				.getHomePageUrl();
		
		assertEquals(url, "https://ampeg.com/index.html");
	}
	
	@Test
	public void navigateToHomePageEdgeVersionTest() {
		String url = new HomePage(super.getEdgeDriverManager().getDriver())
				.navigateToHomePage()
				.clickProductsButton()
				.clickOnSVTPROSERIESBassHeadsProduct()
				.clickOnSVT_3PROProduct()
				.navigateToHomePage()
				.getHomePageUrl();
		
		assertEquals(url, "https://ampeg.com/index.html");
	}
}
