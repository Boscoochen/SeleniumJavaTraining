package foundation;

import java.io.File;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
	@Override
	public void createDriver() {
		String driverPath = super.getDriverPath("edge");
		File file = new File(driverPath);
		String absolutePath = file.getAbsolutePath();
		System.setProperty("webdriver.edge.driver", absolutePath);
		super.setDriver(new EdgeDriver());
		SetOptions();
	}
}