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

	public void quitDriver() {
		if(this.driver != null) {
			getDriver().quit();
		}
	}
}
