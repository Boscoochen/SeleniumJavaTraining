package hands_on_selenium_webdriver_with_java.part2.browseragnosticfeatures;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.slf4j.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BrowserAgnosticFeatures {
	WebDriver driver;
	
	private static final Logger log = LoggerFactory.getLogger(BrowserAgnosticFeatures.class);
    
	@BeforeMethod
	void setup() {
		driver = WebDriverManager.chromedriver().create();
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}
	
	@Test
	void testScrollBy() throws InterruptedException {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String script = "window.scrollBy(0, 1000);";
		js.executeScript(script);
	}
	
	@Test
	void testScrollIntoView() throws InterruptedException {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement lastElement = driver.findElement(By.cssSelector("p:last-child"));
		String script = "arguments[0].scrollIntoView();";
		js.executeScript(script, lastElement);
		Thread.sleep(10000);
	}
	
	@Test
	void testInfiniteScroll() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By pLocator = By.tagName("p");
		List<WebElement> paragraphs = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pLocator, 0));
		int initParagraphNumber = paragraphs.size();
		WebElement lastParagraph = driver.findElement(By.xpath(String.format("//p[%d]", initParagraphNumber)));
		String script = "arguments[0].scrollIntoView()";
		js.executeScript(script, lastParagraph);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pLocator, initParagraphNumber));
	}
	
	@Test
	void testColorPicker() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement colorPicker = driver.findElement(By.name("my-colors"));
		String initColor = colorPicker.getAttribute("value");
		
		Color red = new Color(255, 0, 0, 1);
		String script = String.format("arguments[0].setAttribute('value', '%s');", red.asHex());
		js.executeScript(script, colorPicker);
		
		String finalColor = colorPicker.getAttribute("value");
		assertThat(finalColor).isNotEqualTo(initColor);
		assertThat(Color.fromString(finalColor)).isEqualTo(red);
	}
	
	@Test
	void testPinnedScripts() throws InterruptedException {
		String initPage = "https://bonigarcia.dev/selenium-webdriver-java/";
		driver.get(initPage);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		ScriptKey lineKey = js.pin("return document.getElementsByTagName('a')[2];");
		ScriptKey firstArgKey = js.pin("return arguments[0];");
		
		Set<ScriptKey> pinnedScripts = js.getPinnedScripts();
		assertThat(pinnedScripts).hasSize(2);
		
		WebElement formLink = (WebElement) js.executeScript(lineKey);
		formLink.click();
		assertThat(driver.getCurrentUrl()).isNotEqualTo(initPage);
		
		String message = "Hello World!";
		String executeScript = (String) js.executeScript(firstArgKey, message);
		assertThat(executeScript).isEqualTo(message);
		
		js.unpin(lineKey);
		assertThat(js.getPinnedScripts()).hasSize(1);
	}

	@Test
	void testAsyncScript() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Duration pause = Duration.ofSeconds(2);
		String script = "const callback = arguments[arguments.length - 1];"
				+ "window.setTimeout(callback, " + pause.toMillis() + ");";
		
		System.out.println(script);
		long initMillis = System.currentTimeMillis();
		js.executeAsyncScript(script);
		Duration elapse = Duration.ofMillis(System.currentTimeMillis() - initMillis);
		assertThat(elapse).isGreaterThanOrEqualTo(pause);
	}
	
	@Test
	void testPageLoadTimeout() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1));
		
		assertThatThrownBy(() -> driver
				.get("https://bonigarcia.dev/selenium-webdriver-java/"))
					.isInstanceOf(TimeoutException.class);
	}
	
	@Test
	void testScriptTimeout() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3));
		
		assertThatThrownBy(() -> {
			long waitMillis = Duration.ofSeconds(5).toMillis();
			String script = "const callback = arguments[arguments.length - 1];"
					+ "window.setTimeout(callback, " + waitMillis + ");";
			js.executeAsyncScript(script);
		}).isInstanceOf(ScriptTimeoutException.class);
	}
	
	@Test
	void testScreeshotPng() throws IOException {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		
		Path destination = Paths.get("screenshot.png");
		Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
		
		assertThat(destination).exists();
	}
	
	@Test
	void testScreenshotBase64() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		if (log.isDebugEnabled()) {
			log.debug("Screenshot in base64 "
					+ "(you can copy and paste it into a browser navigation bar to watch it)\n"
					+ "data:image/png;base64,{}", screenshot);
		} else {
			System.out.println("log is not working");
		}
		
		assertThat(screenshot).isNotEmpty();
	}
	
	@Test
	void testWebElementScreenshot() throws IOException {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		
		WebElement form = driver.findElement(By.tagName("form"));
		File screenshot = form.getScreenshotAs(OutputType.FILE);
		Path destination = Paths.get("webelement-screen.png");
		Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
		assertThat(destination).exists();
	}
	
	@Test
	void testWindow() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		
		Window window = driver.manage().window();
		
		Point initialPosition = window.getPosition();
		Dimension initialSize = window.getSize();
		
		window.maximize();
		
		Point maximizedPosition = window.getPosition();
		Dimension maximizeSize = window.getSize();
		
		assertThat(initialPosition).isNotEqualTo(maximizedPosition);
		assertThat(initialSize).isNotEqualTo(maximizeSize);
	}
	
	@Test
	void testHistory() {
		String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
		String firstPage = baseUrl + "navigation1.html";
		String secondPage = baseUrl + "navigation2.html";
		String thirdPage = baseUrl + "navigation3.html";
		
		driver.get(firstPage);
		
		driver.navigate().to(secondPage);
		driver.navigate().to(thirdPage);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		assertThat(driver.getCurrentUrl()).isEqualTo(thirdPage);
	}
	
	@Test
	void testShadowDom() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
		WebElement content = driver.findElement(By.id("content"));
		SearchContext shadowRoot = content.getShadowRoot();
		WebElement textElement = shadowRoot.findElement(By.cssSelector("p"));
		assertThat(textElement.getText()).contains("Hello Shadow DOM");
	}
	
	@Test
	void testReadCookies() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
		Options options = driver.manage();
		Set<Cookie> cookies = options.getCookies();
		assertThat(cookies).hasSize(2);
		
		Cookie username = options.getCookieNamed("username");
		System.out.println(username);
		assertThat(username.getValue()).isEqualTo("John Doe");
		assertThat(username.getPath()).isEqualTo("/");
		
		driver.findElement(By.id("refresh-cookies")).click();
	}
	
	@Test
	void testAddCookies() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
		
		Options options = driver.manage();
		Cookie newCookie = new Cookie("new-cookie-key", "new-cookie-value");
		options.addCookie(newCookie);
		String readValue = options.getCookieNamed(newCookie.getName()).getValue();
		assertThat(newCookie.getValue()).isEqualTo(readValue);
		driver.findElement(By.id("refresh-cookies")).click();
	}
	
	@Test
	void testEditCookie() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
		Options options = driver.manage();
		Cookie username = options.getCookieNamed("username");
		Cookie editCookie = new Cookie(username.getName(), "new-value");
		options.addCookie(editCookie);
		
		Cookie readCookie = options.getCookieNamed(username.getName());
		assertThat(editCookie).isEqualTo(readCookie);
		
		driver.findElement(By.id("refresh-cookies")).click();
	}
	
	@Test
	void testDeleteCookies() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
		
		Options options = driver.manage();
		Set<Cookie> cookies = options.getCookies();
		Cookie username = options.getCookieNamed("username");
		options.deleteCookie(username);
		
		assertThat(options.getCookies()).hasSize(cookies.size() - 1);
		driver.findElement(By.id("refresh-cookies")).click();
	}
	
	@Test
	void test() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		Select select = new Select(driver.findElement(By.name("my-select")));
		String optionLabel = "Three";
		select.selectByVisibleText(optionLabel);
		
		assertThat(select.getFirstSelectedOption().getText()).isEqualTo(optionLabel);
	}
	
	@Test
	void testDatalist() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement datalist = driver.findElement(By.name("my-datalist"));
		datalist.click();
		
		WebElement option = driver.findElement(By.xpath("//datalist/option[2]"));
		String optionValue = option.getAttribute("value");
		datalist.sendKeys(optionValue);
		
		assertThat(optionValue).isEqualTo("New York");
	}
	
	@Test
	void testNewTab() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		String initHandle = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		assertThat(driver.getWindowHandles().size()).isEqualTo(2);
		
		driver.switchTo().window(initHandle);
		driver.close();
		assertThat(driver.getWindowHandles().size()).isEqualTo(1);
	}
	
	@Test
	void testNewWindow() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		String initHandle = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		assertThat(driver.getWindowHandles().size()).isEqualTo(2);
		
		driver.switchTo().window(initHandle);
		driver.close();
		assertThat(driver.getWindowHandles().size()).isEqualTo(1);
	}
}
