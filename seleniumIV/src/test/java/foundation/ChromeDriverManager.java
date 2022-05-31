package foundation;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager{
	@Override
	public void createDriver() {
		String driverPath = super.getDriverPath("chrome");
		File file = new File(driverPath);
		String absolutePath = file.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", absolutePath);
		super.setDriver(new ChromeDriver());
		SetOptions();
	}
}
