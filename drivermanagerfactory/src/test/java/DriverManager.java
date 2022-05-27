import org.openqa.selenium.WebDriver;

public abstract class DriverManager extends DriverManagerFactory {
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
