import org.openqa.selenium.By;
import org.junit.Assert;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchProductTest {
	@Given("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
		TestBase.LaunchWebDriver();
		TestBase.getDriver().get("https://invenauto.tech/index.php");
	}

	@Then("^I Enter the keyword T-shirt and click the search button$")
	public void i_Enter_the_keyword_T_short_and_click_the_search_button() throws Throwable {
		TestBase.getDriver().findElement(By.id("search_query_top")).sendKeys("T-shirt");
		TestBase.getDriver().findElement(By.name("submit_search")).click();
	}

	@And("^the item calls Faded Short Sleeves T-shirt appears$")
	public void the_item_calls_Faded_Short_Sleeves_T_shirt_appears() throws Throwable {
		String itemTitle = TestBase.getDriver()
				.findElement(By.xpath("//*[@id=\"product_list\"]/li//div/h5/a[@class='product-name']")).getText();
		Assert.assertEquals(itemTitle, "Faded Short Sleeves T-shirt");
	}

	@After
	public void cleanUp() {
		if (TestBase.getDriver() != null) {
			TestBase.getDriver().quit();
		}
	}
}
