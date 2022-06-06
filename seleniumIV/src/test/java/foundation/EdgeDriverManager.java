package foundation;

import java.io.File;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
	private static final String DRIVER_FILE_PATH = "src/test/resources/msedgedriver";

	@Override
	public void createDriver() {
		File file = new File(DRIVER_FILE_PATH);
		String absolutePath = file.getAbsolutePath();
		System.setProperty("webdriver.edge.driver", absolutePath);
		super.setDriver(new EdgeDriver());
		SetOptions();
	}
}
