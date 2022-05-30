import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import util.Setting;

public abstract class TestBase {
	private ChromeDriverManager chromeDriverManager;
	private EdgeDriverManager edgeDriverManager;
	private String browserType;
	
	@BeforeTest
	public void setupApplication() throws IOException {
		browserType = Setting.readPropertiesFile("browserType").toLowerCase();
		String url = Setting.readPropertiesFile("url").toLowerCase();

		if (browserType.equals("chrome")) {
			this.chromeDriverManager = (ChromeDriverManager) DriverManagerFactory.getManaDriver(browserType);
			this.chromeDriverManager.createDriver();
			this.chromeDriverManager.loadWebsite(url);
		} else if (browserType.equals("edge")) {
			this.edgeDriverManager = (EdgeDriverManager) DriverManagerFactory.getManaDriver(browserType);
			this.edgeDriverManager.createDriver();
			this.edgeDriverManager.loadWebsite(url);
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
