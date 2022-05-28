
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchProductTest{
	private WebDriver driver;
	@Before
	public void launchWebDriver() {
		String path = null;
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.equals("mac os x")) {
			path = "src/test/resources/chromedriver";
		} else if (osName.equals("windows 11")) {
			path = "src/test/resources/chromedriver.exe";
		}
		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", absolutePath);
		driver = new ChromeDriver();
	}
	
	@Given("^I am on the \"([^\"]*)\" page$")
	public void i_am_on_the_page(String arg1) throws Throwable {
		driver.get("https://invenauto.tech/index.php");
	}

	@Given("^I Enter the keyword \"([^\"]*)\" and click the search button$")
	public void i_Enter_the_keyword_and_click_the_search_button(String arg1) throws Throwable {
		driver.findElement(By.id("search_query_top")).sendKeys("T-shirt");
		driver.findElement(By.name("submit_search")).click();
	}

	@Then("^the item calls \"([^\"]*)\" appears$")
	public void the_item_calls_appears(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String itemTitle = driver.findElement(By.xpath("//*[@id=\"product_list\"]/li/div/div[2]/h5/a")).getText();
		System.out.println(itemTitle);
		Assert.assertEquals(itemTitle, "Faded Short Sleeves T-shirt");
	}
	
	@After
	public void cleanUp() {
		if (driver != null) {
			driver.quit();
		}
	}
}
