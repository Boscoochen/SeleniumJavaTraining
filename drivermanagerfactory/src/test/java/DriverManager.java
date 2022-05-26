import org.openqa.selenium.WebDriver;

public abstract class DriverManager extends DriverManagerFactory{
	
	
	public abstract WebDriver createDriver();
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract void quitDriver();
}
