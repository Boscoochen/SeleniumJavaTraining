import org.openqa.selenium.By;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RegistrationTest {
	@Given("^I am currently on the home page$")
	public void i_am_currently_on_the_home_page() throws Throwable {
		TestBase.LaunchWebDriver();
		TestBase.getDriver().get("https://invenauto.tech/index.php");
	}

	@Then("^I click sign in button$")
	public void i_click_sign_in_button() throws Throwable {
		TestBase.getDriver().findElement(By.xpath("//*[@id=\"header\"]//div/a[@class='login']")).click();
	}

	@When("^I enter valid email and click Create an account button$")
	public void i_enter_valid_email_and_click_Create_an_account_button() throws Throwable {
		TestBase.getDriver().findElement(By.id("email_create"))
				.sendKeys("quintrix2022" + System.currentTimeMillis() + "@gmail.com");
		TestBase.getDriver().findElement(By.id("SubmitCreate")).click();
	}

	@Then("^I sign up with valid details and click Registrer button$")
	public void i_sign_up_with_valid_details_and_click_Registrer_button() throws Throwable {
		TestBase.getDriver().findElement(By.id("customer_firstname")).sendKeys("admin");
		TestBase.getDriver().findElement(By.id("customer_lastname")).sendKeys("admin");
		TestBase.getDriver().findElement(By.id("passwd")).sendKeys(System.currentTimeMillis() + "");
		TestBase.getDriver().findElement(By.xpath("//*[@id=\"days\"]")).click();
		TestBase.getDriver().findElement(By.xpath("//*[@id=\"months\"]")).click();
		TestBase.getDriver().findElement(By.xpath("//*[@id=\"years\"]")).click();
		TestBase.getDriver().findElement(By.id("submitAccount")).click();
	}

	@And("^I should see the successful sign up message$")
	public void i_should_see_the_successful_sign_up_message() throws Throwable {
		String messageString = TestBase.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText();
		Assert.assertEquals(messageString, "Your account has been created.");
	}

	@After
	public void cleanUp() {
		if (TestBase.getDriver() != null) {
			TestBase.getDriver().quit();
		}
	}
}
