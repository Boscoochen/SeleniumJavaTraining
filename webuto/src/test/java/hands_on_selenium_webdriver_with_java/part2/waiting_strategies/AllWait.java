package hands_on_selenium_webdriver_with_java.part2.waiting_strategies;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllWait {
	WebDriver chromeDriver;
	@BeforeTest
	public void setUpChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		chromeDriver = new ChromeDriver();
	}
	
	@Test
	public void testImplicaitWait() {
		chromeDriver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement landscapElement = chromeDriver.findElement(By.id("landscape"));
		assertTrue(landscapElement.getAttribute("src").contains("landscape.png"));
	}
	
	@Test
	public void testExplicitWait() {
		chromeDriver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
		WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
		WebElement landscapElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
		assertTrue(landscapElement.getAttribute("src").contains("landscape"));
	}
	
	@Test
	public void testSlowCalculator() {
		chromeDriver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
		
		// 1 + 3
		chromeDriver.findElement(By.xpath("//span[text()='1']")).click();
		chromeDriver.findElement(By.xpath("//span[text()='+']")).click();
		chromeDriver.findElement(By.xpath("//span[text()='3']")).click();
		chromeDriver.findElement(By.xpath("//span[text()='=']")).click();
		
		// ... should be 4, wait for it
		WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
		wait.until(ExpectedConditions.textToBe(By.className("screen"), "4"));
	}
	
	@Test
	public void testFluentWait() {
		chromeDriver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
		Wait<WebDriver> wait = new FluentWait<>(chromeDriver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		WebElement landscapeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
		
		assertTrue(landscapeElement.getAttribute("src").contains("landscape"));
	}
	
	@AfterTest
	public void quitDriver() {
		if (chromeDriver != null) {
			chromeDriver.quit();
		}
	}
}
