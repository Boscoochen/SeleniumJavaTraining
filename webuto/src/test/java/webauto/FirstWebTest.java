package webauto;

import org.openqa.selenium.chrome.ChromeDriver;

public class FirstWebTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.baidu.com");
	}
}
