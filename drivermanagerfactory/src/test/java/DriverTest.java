import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;
public class DriverTest extends TestBase{
	/**
	 * Change browserType=edge in config.properties before test
	 */
	@Test
	public void canLaunchEdgeDriver() {
		assertNotNull(this.getEdgeDriverManager().getDriver(),"the webdriver should be launch in the super class.");
	}
	
	/**
	 * Change browserType=chrome in config.properties before test
	 */
	@Test
	public void canLaunchChromeDriver() {
		assertNotNull(this.getChromeDriverManager().getDriver(),"the chromedriver should be launch in the super class.");
	}
}
