import java.io.File;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
	private static final String DRIVER_FILE_PATH = "src/test/resources/chromedriver";

	@Override
	public void createDriver() {
		File file = new File(DRIVER_FILE_PATH);
		String absolutePath = file.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", absolutePath);
		super.setDriver(new ChromeDriver());
		SetOptions();
	}
}
