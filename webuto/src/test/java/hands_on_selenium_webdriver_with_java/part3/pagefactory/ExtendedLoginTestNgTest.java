package hands_on_selenium_webdriver_with_java.part3.pagefactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ExtendedLoginTestNgTest {
	FactoryLoginPage login;
	
	@BeforeMethod
	void setup() {
		login = new FactoryLoginPage("chrome");
	}
	
	@AfterMethod
	void teardown() {
		login.quit();
	}
	
	@Test
	void testLoginSuccess() {
		login.with("user", "user");
		assertThat(login.successBoxPresent()).isTrue();
	}
	
	@Test
	void testLoginFailure() {
		login.with("bad-user", "bad-user");
		assertThat(login.successBoxPresent()).isFalse();
	}
}
