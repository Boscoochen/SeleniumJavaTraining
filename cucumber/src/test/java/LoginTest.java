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

public class LoginTest {
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
	@Given("^I am current on the \"([^\"]*)\" page$")
	public void i_am_current_on_the_page(String arg1) throws Throwable {
		driver.get("https://invenauto.tech/index.php");
	}

	@When("^I click on sign in button$")
	public void i_click_on_sign_in_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
	}

	@Then("^I sign in with valid email and password$")
	public void i_sign_in_with_valid_email_and_password() throws Throwable {
	    driver.findElement(By.id("email")).sendKeys("admin123@gmail.com");
	    driver.findElement(By.id("passwd")).sendKeys("1234567");
	    driver.findElement(By.id("SubmitLogin")).click();
	}

	@And("^I should see the MY ACCOUNT title$")
	public void i_should_see_the_MY_ACCOUNT_title() throws Throwable {
	    String title = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
	    Assert.assertEquals(title, "MY ACCOUNT");
	}
	@After
	public void cleanUp() {
		if (driver != null) {
			driver.quit();
		}
	}
}
