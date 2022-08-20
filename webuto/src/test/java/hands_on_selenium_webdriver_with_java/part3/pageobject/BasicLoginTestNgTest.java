package hands_on_selenium_webdriver_with_java.part3.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.assertj.core.api.Assertions.assertThat;
public class BasicLoginTestNgTest {
	WebDriver driver;
	BasicLoginPage login;
	
	@BeforeMethod
	void setup() {
		driver = WebDriverManager.chromedriver().create();
		login = new BasicLoginPage(driver);
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}
	
	@Test
	public void testBasicLoginSuccess() {
		login.with("user", "user");
		assertThat(login.successBoxPresent()).isTrue();
	}
	
	@Test
	public void testBasicLoginFailure() {
		login.with("bad-user", "bad-password");
		assertThat(login.successBoxPresent()).isFalse();
	}
}
