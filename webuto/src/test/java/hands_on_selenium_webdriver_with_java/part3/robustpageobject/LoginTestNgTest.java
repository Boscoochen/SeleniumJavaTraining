package hands_on_selenium_webdriver_with_java.part3.robustpageobject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTestNgTest {
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	void setup() {
		driver = WebDriverManager.chromedriver().create();
		login = new LoginPage(driver);
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}
	
	@Test
	void testLoginSuccess() {
		login.with("user", "user");
		assertThat(login.successBoxPresent()).isTrue();
	}
	
	@Test
	void testLoginFailure() {
		login.with("bad-user", "bad-password");
		assertThat(login.successBoxPresent()).isFalse();
	}
}
