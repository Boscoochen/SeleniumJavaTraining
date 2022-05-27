public class DriverManagerFactory extends TestBase {
	public DriverManager getManaDriver(String browserType) {
		if (browserType.toLowerCase().equals("chrome")) {
			return new ChromeDriverManager();
		} else if (browserType.toLowerCase().equals("edge")) {
			return new EdgeDriverManager();
		} else {
			return null;
		}
	}
}
