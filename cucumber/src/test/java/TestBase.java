import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	private static WebDriver driver;

	public static void LaunchWebDriver() {
		String driverPath = getDriverPath();
		File file = new File(driverPath);
		String absolutePath = file.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", absolutePath);
		driver = new ChromeDriver();
		SetOptions();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	private static void SetOptions() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	private static String getDriverPath() {
		String path = null;
		String osName = osName();
		if (osName.equals("mac os x")) {
			path = "src/test/resources/chromedriver";
		} else if (osName.equals("windows 11")) {
			path = "src/test/resources/chromedriver.exe";
		}
		return path;
	}

	private static String osName() {
		return System.getProperty("os.name").toLowerCase();
	}
}
