import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
public class RegistrationTest {
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
	@Given("^I am currently on the \"([^\"]*)\" page$")
	public void i_am_currently_on_the_page(String arg1) throws Throwable {
		driver.get("https://invenauto.tech/index.php");
	}

	@When("^I click sign in button$")
	public void i_click_sign_in_button() throws Throwable {
	    driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
	}

	@Then("^I enter valid email and click \"([^\"]*)\" button$")
	public void i_enter_valid_email_and_click_button(String arg1) throws Throwable {
		driver.findElement(By.id("email_create")).sendKeys("quintrix2022" + System.currentTimeMillis() + "@gmail.com");
	    driver.findElement(By.id("SubmitCreate")).click();
	    Thread.sleep(5000);
	}

	@When("^I sign up with valid details and click \"([^\"]*)\" button$")
	public void i_sign_up_with_valid_details_and_click_button(String arg1) throws Throwable {
		driver.findElement(By.id("customer_firstname")).sendKeys("admin");
	    driver.findElement(By.id("customer_lastname")).sendKeys("admin");
	    driver.findElement(By.id("passwd")).sendKeys(System.currentTimeMillis()+"");
	    driver.findElement(By.xpath("//*[@id=\"days\"]")).click();
	    driver.findElement(By.xpath("//*[@id=\"months\"]")).click();
	    driver.findElement(By.xpath("//*[@id=\"years\"]")).click();
	    driver.findElement(By.id("submitAccount")).click();
	}

	@And("^I should see the successful sign up message$")
	public void i_should_see_the_successful_sign_up_message() throws Throwable {
	    String messageString = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText();
	    System.out.println(messageString);
	    Assert.assertEquals(messageString, "Your account has been created.");
	}
	
	@After
	public void cleanUp() {
		if (driver != null) {
			driver.quit();
		}
	}
}
