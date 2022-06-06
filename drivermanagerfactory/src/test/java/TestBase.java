import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import util.Setting;

public abstract class TestBase {
	private DriverManager manager;
	private String browserType;

	@BeforeTest
	public void setupApplication() throws IOException {
		browserType = Setting.readPropertiesFile("browserType").toLowerCase();
		manager = DriverManagerFactory.getManaDriver(browserType);
		manager.createDriver();
	}

	@AfterTest
	public void closeApplication() {
		if (this.manager.getDriver() != null) {
			this.manager.quitDriver();
		}
	}

	public DriverManager getDriverManager() {
		return this.manager;
	}

	protected String osName() {
		return System.getProperty("os.name").toLowerCase();
	}
}
