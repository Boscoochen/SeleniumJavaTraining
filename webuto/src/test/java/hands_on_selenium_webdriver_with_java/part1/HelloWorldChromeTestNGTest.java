package hands_on_selenium_webdriver_with_java.part1;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.*;
import org.slf4j.simple.SimpleLogger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloWorldChromeTestNGTest {
	
	
	
	private WebDriver driver;
	private Logger log;
	
	@BeforeClass
	void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeMethod
	void setup() {
		System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");
		log = LoggerFactory.getLogger(HelloWorldChromeTestNGTest.class);
		driver = new ChromeDriver();
	}
	
	@Test
	void test() {
		log.trace("hoo");
		String sutUrl = "http://bonigarcia.dev/selenium-webdriver-java/";
		driver.get(sutUrl);
		String title = driver.getTitle();
		log.info("hello");
		log.debug("The title of {} is {}", sutUrl, title);
		assertEquals(title, "Hands-On Selenium WebDriver with Java");
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}
}
