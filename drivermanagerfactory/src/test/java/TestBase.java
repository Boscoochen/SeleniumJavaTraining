import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class TestBase {
	protected WebDriver driver;

	protected void SetOptions() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	protected String getDriverPath(String browserName) {
		String path = null;
		String osName = osName();
		if (osName.equals("mac os x")) {
			if (browserName.toLowerCase().equals("chrome")) {
				path = "src/test/resources/chromedriver";
			} else if (browserName.toLowerCase().equals("edge")) {
				path = "src/test/resources/msedgedriver";
			}
		} else if (osName.equals("windows 11")) {
			if (browserName.toLowerCase().equals("chrome")) {
				path = "src/test/resources/chromedriver.exe";
			} else if (browserName.toLowerCase().equals("edge")) {
				path = "src/test/resources/msedgedriver.exe";
			}
		}
		return path;
	}

	protected String osName() {
		return System.getProperty("os.name").toLowerCase();
	}
}
