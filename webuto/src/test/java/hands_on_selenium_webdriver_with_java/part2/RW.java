package hands_on_selenium_webdriver_with_java.part2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static io.github.bonigarcia.wdm.WebDriverManager.isOnline;
import static org.assertj.core.api.Assumptions.assumeThat;
public class RW {
	WebDriver driver;
	@BeforeMethod
	void setup() throws MalformedURLException {
		URL seleniumServerUrl = new URL("https://localhost:4444/");
		assumeThat(isOnline(seleniumServerUrl)).isTrue();
		
		ChromeOptions options = new ChromeOptions();
		driver = new RemoteWebDriver(seleniumServerUrl, options);
	}
	
	@Test
	void testRemote() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		assertThat(driver.getTitle()).contains("Selenium WebDriver");
	}
}
