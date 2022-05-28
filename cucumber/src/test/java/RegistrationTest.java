import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
public class RegistrationTest {
	TestBase testBase;
	public RegistrationTest() {
		testBase = new TestBase();
	}
	@Given("^I am currently on the \"([^\"]*)\" page$")
	public void i_am_currently_on_the_page(String arg1) throws Throwable {
		testBase.LaunchWebDriver();
		testBase.getDriver().get("https://invenauto.tech/index.php");
	}

	@When("^I click sign in button$")
	public void i_click_sign_in_button() throws Throwable {
		testBase.getDriver().findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
	}

	@Then("^I enter valid email and click \"([^\"]*)\" button$")
	public void i_enter_valid_email_and_click_button(String arg1) throws Throwable {
		testBase.getDriver().findElement(By.id("email_create")).sendKeys("quintrix2022" + System.currentTimeMillis() + "@gmail.com");
		testBase.getDriver().findElement(By.id("SubmitCreate")).click();
	    Thread.sleep(5000);
	}

	@When("^I sign up with valid details and click \"([^\"]*)\" button$")
	public void i_sign_up_with_valid_details_and_click_button(String arg1) throws Throwable {
		testBase.getDriver().findElement(By.id("customer_firstname")).sendKeys("admin");
		testBase.getDriver().findElement(By.id("customer_lastname")).sendKeys("admin");
		testBase.getDriver().findElement(By.id("passwd")).sendKeys(System.currentTimeMillis()+"");
		testBase.getDriver().findElement(By.xpath("//*[@id=\"days\"]")).click();
		testBase.getDriver().findElement(By.xpath("//*[@id=\"months\"]")).click();
		testBase.getDriver().findElement(By.xpath("//*[@id=\"years\"]")).click();
		testBase.getDriver().findElement(By.id("submitAccount")).click();
	}

	@And("^I should see the successful sign up message$")
	public void i_should_see_the_successful_sign_up_message() throws Throwable {
	    String messageString = testBase.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText();
	    System.out.println(messageString);
	    Assert.assertEquals(messageString, "Your account has been created.");
	}
	
	@After
	public void cleanUp() {
		if (testBase.getDriver()!= null) {
			testBase.getDriver().quit();
		}
	}
}
