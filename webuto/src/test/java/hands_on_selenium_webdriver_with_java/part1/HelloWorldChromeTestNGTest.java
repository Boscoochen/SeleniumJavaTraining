package hands_on_selenium_webdriver_with_java.part1;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloWorldChromeTestNGTest {
	static final Logger log = getLogger(lookup().lookupClass());
	
	private WebDriver driver;
	
	@BeforeClass
	void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeMethod
	void setup() {
		driver = new ChromeDriver();
	}
	
	@Test
	void test() {
		String sutUrl = "http://bonigarcia.dev/selenium-webdriver-java/";
		driver.get(sutUrl);
		String title = driver.getTitle();
		System.out.println(log);
		log.debug("The title of {} is {}", sutUrl, title);
		assertEquals(title, "Hands-On Selenium WebDriver with Java");
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}
}
