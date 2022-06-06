import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

public class DriverTest extends TestBase {
	@Test
	public void canLaunchDriver() {
		assertNotNull(this.getDriverManager().getDriver(), "the webdriver should be launch in the super class.");
	}
}
