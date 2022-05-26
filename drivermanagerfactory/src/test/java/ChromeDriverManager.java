import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
public class ChromeDriverManager extends DriverManager{
	@Override
	public WebDriver createDriver() {
		String driverPath = super.getDriverPath("chrome");
		File file = new File(driverPath);
		String absolutePath = file.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", absolutePath);
		driver = new ChromeDriver();
		SetOptions();
		return driver;
	}

	@Override
	public void quitDriver() {
		driver.quit();
	}
}
