import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import util.Setting;

public class DriverTest {
	private DriverManagerFactory driverManagerFactory;
	private String browserType;

	@Test
	public void getDriverTest() throws IOException {
		browserType = Setting.readPropertiesFile("browserType").toLowerCase();
		String url = Setting.readPropertiesFile("Url").toLowerCase();

		if (browserType.equals("chrome")) {
			driverManagerFactory = new DriverManagerFactory().getManaDriver(browserType);
			((ChromeDriverManager) driverManagerFactory).createDriver().load(url);
		} else if (browserType.equals("edge")) {
			driverManagerFactory = new DriverManagerFactory().getManaDriver(browserType);
			((EdgeDriverManager) driverManagerFactory).createDriver().load(url);
		}
	}

	@AfterTest
	public void quitDriver() {
		if (browserType.equals("chrome")) {
			((ChromeDriverManager) driverManagerFactory).quitDriver();
		} else if (browserType.equals("edge")) {
			((EdgeDriverManager) driverManagerFactory).quitDriver();
		}
	}
}
