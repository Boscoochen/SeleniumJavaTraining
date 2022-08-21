package hands_on_selenium_webdriver_with_java.part1;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hands_on_selenium_webdriver_with_java.part3.robustpageobject.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	
	@Test
	void testByCssSelectorBasic() {
		driver.get("http://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement hidden = driver.findElement(By.cssSelector("input[type=hidden"));
		assertThat(hidden.isDisplayed()).isFalse();
	}
	
	@Test
	void testByCssSelectorAdvanced() {
		driver.get("http://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]:checked"));
		assertThat(checkbox1.getAttribute("id")).isEqualTo("my-check-1");
		
		WebElement checkbox2 = driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
		assertThat(checkbox2.getAttribute("id")).isEqualTo("my-check-2");
		assertThat(checkbox2.isSelected()).isFalse();
	}
	
	@Test
	void testByXPathBasic() {
		driver.get("http://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement hidden = driver.findElement(By.xpath("//input[@type='hidden']"));
		assertThat(hidden.isDisplayed()).isFalse();
	}
	
	@Test
	void testByXpathAdvance() {
		driver.get("http://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement radio1 = driver.findElement(By.xpath("//*[@type='radio' and @checked]"));
		assertThat(radio1.getAttribute("id")).isEqualTo("my-radio-1");
		assertThat(radio1.isSelected()).isTrue();
		
		WebElement radio2 = driver.findElement(By.xpath("//*[@type='radio' and not(@checked)]"));
		assertThat(radio2.getAttribute("id")).isEqualTo("my-radio-2");
		assertThat(radio2.isSelected()).isFalse();
	}
	
	@Test
	void testByIdOrName() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement fileElement = driver.findElement(new ByIdOrName("my-file"));
		assertThat(fileElement.getAttribute("id")).isBlank();
		assertThat(fileElement.getAttribute("name")).isNotBlank();
	}
	
	@Test
	void testByChained() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		List<WebElement> rowsInForm = driver.findElements(new ByChained(By.tagName("form"), By.className("row")));
		assertThat(rowsInForm.size()).isEqualTo(1);
	}
	
	@Test
	void testByAll() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		List<WebElement> rowsInForm = driver.findElements(new ByAll(By.tagName("form"), By.className("row")));
		assertThat(rowsInForm.size()).isEqualTo(5);
	}
	
	@Test
	void testRelativeLocators() {
		driver.get("http://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement link = driver.findElement(By.linkText("Return to index"));
		RelativeBy relativeBy = RelativeLocator.with(By.tagName("input"));
		WebElement readOnly = driver.findElement(relativeBy.above(link));
		assertThat(readOnly.getAttribute("name")).isEqualTo("my-readonly");
	}
	
	@Test
	void testDatePicker() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		
		LocalDate today = LocalDate.now();
		int currentYear = today.getYear();
		int currentDay = today.getDayOfMonth();
		
		WebElement datePicker = driver.findElement(By.name("my-date"));
		datePicker.click();
		
		WebElement monthElement = driver.findElement(By.xpath(String.format("//th[contains(text(),'%d')]", currentYear)));
		monthElement.click();
		
		WebElement arrowLeft = driver.findElement(RelativeLocator.with(By.tagName("th")).toRightOf(monthElement));
		arrowLeft.click();
		
		WebElement monthPastYear = driver.findElement(RelativeLocator.with(By.cssSelector("span[class$=focused]")).below(arrowLeft));
		monthPastYear.click();
		
		WebElement dayElement = driver.findElement(By.xpath(String.format("//td[@class='day' and contains(text(),'%d')]", currentDay)));
		dayElement.click();
		
		String oneYearBack = datePicker.getAttribute("value");
		
		LocalDate previousYear = today.minusYears(1);
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String expectedDate = previousYear.format(dateFormat);
		assertThat(oneYearBack).isEqualTo(expectedDate);
	}
	
	@Test
	void testSendKeys() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement inputText = driver.findElement(By.name("my-text"));
		String textValue = "Hello World!";
		inputText.sendKeys(textValue);
		assertThat(inputText.getAttribute("value")).isEqualTo(textValue);
		
		inputText.clear();
		assertThat(inputText.getAttribute("value")).isEmpty();
	}
}
