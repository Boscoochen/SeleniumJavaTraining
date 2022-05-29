import org.openqa.selenium.By;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginTest {
	@Given("^I am current on the home page$")
	public void i_am_current_on_the_home_page() throws Throwable {
		TestBase.LaunchWebDriver();
		TestBase.getDriver().get("https://invenauto.tech/index.php");
	}

	@Then("^I click on sign in button$")
	public void i_click_on_sign_in_button() throws Throwable {
		TestBase.getDriver().findElement(By.xpath("//*[@id=\"header\"]//div/a[@class='login']")).click();
	}

	@When("^I sign in with valid email and password$")
	public void i_sign_in_with_valid_email_and_password() throws Throwable {
		TestBase.getDriver().findElement(By.id("email")).sendKeys("admin123@gmail.com");
		TestBase.getDriver().findElement(By.id("passwd")).sendKeys("1234567");
		TestBase.getDriver().findElement(By.id("SubmitLogin")).click();
	}

	@And("^I should see the MY ACCOUNT title$")
	public void i_should_see_the_MY_ACCOUNT_title() throws Throwable {
		String title = TestBase.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
		Assert.assertEquals(title, "MY ACCOUNT");
	}

	@After
	public void cleanUp() {
		if (TestBase.getDriver() != null) {
			TestBase.getDriver().quit();
		}
	}
}
