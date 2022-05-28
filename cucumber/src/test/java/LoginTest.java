import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginTest {
	TestBase testBase;
	public LoginTest() {
		testBase = new TestBase();
	}
	@Given("^I am current on the \"([^\"]*)\" page$")
	public void i_am_current_on_the_page(String arg1) throws Throwable {
		testBase.LaunchWebDriver();
		testBase.getDriver().get("https://invenauto.tech/index.php");
	}

	@When("^I click on sign in button$")
	public void i_click_on_sign_in_button() throws Throwable {
		testBase.getDriver().findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
	}

	@Then("^I sign in with valid email and password$")
	public void i_sign_in_with_valid_email_and_password() throws Throwable {
		testBase.getDriver().findElement(By.id("email")).sendKeys("admin123@gmail.com");
		testBase.getDriver().findElement(By.id("passwd")).sendKeys("1234567");
		testBase.getDriver().findElement(By.id("SubmitLogin")).click();
	}

	@And("^I should see the MY ACCOUNT title$")
	public void i_should_see_the_MY_ACCOUNT_title() throws Throwable {
	    String title = testBase.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
	    Assert.assertEquals(title, "MY ACCOUNT");
	}
	@After
	public void cleanUp() {
		if (testBase.getDriver()!= null) {
			testBase.getDriver().quit();
		}
	}
}
