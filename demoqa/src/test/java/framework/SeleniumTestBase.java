package framework;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class SeleniumTestBase {
	private WebDriver driver;
	@BeforeTest
	public void LanuchWebDriver() {
		String path = "src/test/resources/chromedriver";
		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
		System.setProperty("webdriver.chrome.driver", absolutePath);
		this.driver = new ChromeDriver();
		setOptions();
	}
	
	protected WebDriver getDriver() {
		return this.driver;
	}
	
	private void setOptions() {
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void cleanUp() {
		if (this.driver != null) {
			this.driver.quit();
		}
	}
}
