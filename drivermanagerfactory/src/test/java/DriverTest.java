import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DriverTest extends TestBase{
	ChromeDriverManager chromeDriverManager;
	EdgeDriverManager edgeDriverManager;
	@Test
	public void getChromeDriverTest() {
		chromeDriverManager = (ChromeDriverManager) new DriverManagerFactory().getManaDriver("chrome");
		chromeDriverManager.createDriver().get("https://fanyi.baidu.com/");
	}
	
	@Test
	public void getEdgeDriverTest() {
		edgeDriverManager = (EdgeDriverManager) new DriverManagerFactory().getManaDriver("edge");
		edgeDriverManager.createDriver().get("https://fanyi.baidu.com/");
	}
	
	@AfterTest
	public void quitDriver() {
		chromeDriverManager.quitDriver();
		edgeDriverManager.quitDriver();
	}
}
