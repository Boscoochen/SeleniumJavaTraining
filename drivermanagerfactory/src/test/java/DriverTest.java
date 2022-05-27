import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;
public class DriverTest extends TestBase{
	@Test
	public void canLaunchEdgeDriver() {
		assertNotNull(this.getEdgeDriverManager().getDriver(),"the edgedriver should be launch in the super class.");
	}
	
	@Test
	public void canLaunchChromeDriver() {
		assertNotNull(this.getChromeDriverManager().getDriver(),"the chromedriver should be launch in the super class.");
	}
}
