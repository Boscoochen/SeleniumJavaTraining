package foundation;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import util.Setting;

public abstract class SeleniumTestBase {
	private ChromeDriverManager chromeDriverManager;
	private EdgeDriverManager edgeDriverManager;
	private String browserType;
	private Setting setting = new Setting();

	@BeforeTest
	public void setupApplication() throws IOException {
		browserType = setting.readPropertiesFile("browserType").toLowerCase();

		if (browserType.equals("chrome")) {
			this.chromeDriverManager = (ChromeDriverManager) DriverManagerFactory.getManaDriver(browserType);
			this.chromeDriverManager.createDriver();
		} else if (browserType.equals("edge")) {
			this.edgeDriverManager = (EdgeDriverManager) DriverManagerFactory.getManaDriver(browserType);
			this.edgeDriverManager.createDriver();
		}
	}

	@AfterTest
	public void closeApplication() {
		if (browserType.equals("chrome")) {
			this.chromeDriverManager.quitDriver();
		} else if (browserType.equals("edge")) {
			this.edgeDriverManager.quitDriver();
		}
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

	public ChromeDriverManager getChromeDriverManager() {
		return this.chromeDriverManager;
	}

	public EdgeDriverManager getEdgeDriverManager() {
		return this.edgeDriverManager;
	}
}
