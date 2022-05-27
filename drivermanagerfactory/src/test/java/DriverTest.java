import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import util.Setting;

public class DriverTest extends TestBase {
	private ChromeDriverManager chromeDriverManager;
	private EdgeDriverManager edgeDriverManager;
	private String browserType;
	private String url;

	@Test
	public void getDriverTest() throws IOException {
		browserType = Setting.readPropertiesFile("browserType").toLowerCase();
		url = Setting.readPropertiesFile("Url").toLowerCase();

		if (browserType.equals("chrome")) {
			chromeDriverManager = (ChromeDriverManager) new DriverManagerFactory().getManaDriver(browserType);
			chromeDriverManager.createDriver().load(url);
		} else if (browserType.equals("edge")) {
			edgeDriverManager = (EdgeDriverManager) new DriverManagerFactory().getManaDriver(browserType);
			edgeDriverManager.createDriver().load(url);
		}
	}

	@AfterTest
	public void quitDriver() {
		if (browserType.equals("chrome")) {
			chromeDriverManager.quitDriver();
		} else if (browserType.equals("edge")) {
			edgeDriverManager.quitDriver();
		}
	}
}
