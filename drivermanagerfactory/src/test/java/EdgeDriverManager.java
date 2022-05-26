import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager{

	@Override
	public WebDriver createDriver() {
		String driverPath = super.getDriverPath("edge");
		File file = new File(driverPath);
		String absolutePath = file.getAbsolutePath();
		System.setProperty("webdriver.edge.driver", absolutePath);
		driver = new EdgeDriver();
		SetOptions();
		return driver;
	}

	@Override
	public void quitDriver() {
		driver.quit();
	}
}
