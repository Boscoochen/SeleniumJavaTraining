package foundation;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class SeleniumTestBase {
	private WebDriver driver;

	@BeforeTest
	public void LaunchWebDriver() {
		String driverPath = getDriverPath();
		File file = new File(driverPath);
		String absolutePath = file.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", absolutePath);
		this.driver = new ChromeDriver();

		SetOptions();
	}

	@AfterTest
	public void cleanUp() {
		if (this.getDriver() != null) {
			this.getDriver().quit();
		}
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

	private void SetOptions() {
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
	
	private String getDriverPath() {
		String path = null;
		String osName = osName();
		if (osName.equals("mac os x")) {
			path = "src/test/resources/chromedriver";
		} else if (osName.equals("windows 11")) {
			path = "src/test/resources/chromedriver.exe";
		}
		return path;
	}

	private String osName() {
		return System.getProperty("os.name").toLowerCase();
	}
}
