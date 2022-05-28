import org.openqa.selenium.By;
import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchProductTest {
	TestBase testBase;
	public SearchProductTest() {
		testBase = new TestBase();
	}
	
	@Given("^I am on the \"([^\"]*)\" page$")
	public void i_am_on_the_page(String arg1) throws Throwable {
		testBase.LaunchWebDriver();
		testBase.getDriver().get("https://invenauto.tech/index.php");
	}

	@Given("^I Enter the keyword \"([^\"]*)\" and click the search button$")
	public void i_Enter_the_keyword_and_click_the_search_button(String arg1) throws Throwable {
		testBase.getDriver().findElement(By.id("search_query_top")).sendKeys("T-shirt");
		testBase.getDriver().findElement(By.name("submit_search")).click();
	}

	@Then("^the item calls \"([^\"]*)\" appears$")
	public void the_item_calls_appears(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String itemTitle = testBase.getDriver().findElement(By.xpath("//*[@id=\"product_list\"]/li/div/div[2]/h5/a")).getText();
		System.out.println(itemTitle);
		Assert.assertEquals(itemTitle, "Faded Short Sleeves T-shirt");
	}
	@After
	public void cleanUp() {
		if (testBase.getDriver()!= null) {
			testBase.getDriver().quit();
		}
	}
}
