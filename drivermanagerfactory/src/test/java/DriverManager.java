import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager extends DriverManagerFactory {
	private WebDriver driver;

	protected void SetOptions() {
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public abstract void createDriver();

	public WebDriver getDriver() {
		return this.driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loadWebsite(String webSite) {
		this.driver.get(webSite);
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

	public abstract void quitDriver();
}
