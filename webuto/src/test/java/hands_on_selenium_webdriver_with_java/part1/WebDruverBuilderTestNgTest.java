package hands_on_selenium_webdriver_with_java.part1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDruverBuilderTestNgTest {
	WebDriver driver;
	@BeforeClass
	void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeMethod
	void setup() {
//		driver = RemoteWebDriver.builder().oneOf(new ChromeOptions()).build();
		driver = RemoteWebDriver.builder().oneOf(new SafariOptions()).addAlternative(new ChromeOptions()).build();
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}
	
	
	@Test
	public void test() {
	}
}
