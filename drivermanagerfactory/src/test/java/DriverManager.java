import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager extends DriverManagerFactory {
	private WebDriver driver;

	protected void SetOptions() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public abstract Object createDriver();

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void load(String webSite) {
		driver.get(webSite);
	}

	public abstract void quitDriver();
}
