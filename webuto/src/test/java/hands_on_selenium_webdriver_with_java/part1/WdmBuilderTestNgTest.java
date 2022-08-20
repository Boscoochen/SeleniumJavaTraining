package hands_on_selenium_webdriver_with_java.part1;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WdmBuilderTestNgTest {
	WebDriver driver;
	@BeforeMethod
	void setup() {
		driver = WebDriverManager.chromedriver().create();
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}
	
	@Test
	public void testBasicMethods() {
		String sutUrlString = "https://bonigarcia.dev/selenium-webdriver-java/";
		driver.get(sutUrlString);
		
		assertThat(driver.getTitle()).isEqualTo("Hands-On Selenium WebDriver with Java");
		assertThat(driver.getCurrentUrl()).isEqualTo(sutUrlString);
		assertThat(driver.getPageSource()).containsIgnoringCase("</html>");
	}
	
	@Test
	void testSessionId() {
		driver.get("http://bonigarcia.dev/selenium-webdriver-java/");
		SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
		assertThat(sessionId).isNotNull();
 	}
	
	@Test
	void testByTagName() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement textareaElement = driver.findElement(By.tagName("textarea"));
		assertThat(textareaElement.getDomAttribute("rows")).isEqualTo("3");
	}
	
	@Test
	void testByHtmlAttributes() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		
		// By name
		WebElement textByName = driver.findElement(By.name("my-text"));
		assertThat(textByName.isEnabled()).isTrue();
		
		// By id
		WebElement textById = driver.findElement(By.id("my-text-id"));
		assertThat(textById.getAttribute("type")).isEqualTo("text");
		assertThat(textById.getDomAttribute("type")).isEqualTo("text");
		assertThat(textById.getDomProperty("type")).isEqualTo("text");
		
		assertThat(textById.getAttribute("myprop")).isEqualTo("myvalue");
		assertThat(textById.getDomAttribute("myprop")).isEqualTo("myvalue");
		assertThat(textById.getDomProperty("myprop")).isNull();
		
		// By class name
		List<WebElement> byClassName = driver.findElements(By.className("form-control"));
		assertThat(byClassName.size()).isPositive();
		assertThat(byClassName.get(0).getAttribute("name")).isEqualTo("my-text");
	}
	
	@Test
	void testByLinkedText() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement linkByText = driver.findElement(By.linkText("Return to index"));
		assertThat(linkByText.getTagName()).isEqualTo("a");
		assertThat(linkByText.getCssValue("cursor")).isEqualTo("pointer");
		
		WebElement linkByPartialText = driver.findElement(By.partialLinkText("index"));
		assertThat(linkByPartialText.getLocation()).isEqualTo(linkByText.getLocation());
		assertThat(linkByPartialText.getRect()).isEqualTo(linkByText.getRect());
	}
}
