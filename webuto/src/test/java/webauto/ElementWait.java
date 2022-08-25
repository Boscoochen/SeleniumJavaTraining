package webauto;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementWait {
	private static ChromeDriver chromeDriver;
	public static void main(String[] args) throws InterruptedException {
		openChrome();
//		chromeDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		chromeDriver.get("http://www.baidu.com");
		chromeDriver.findElement(By.id("kw")).sendKeys("腾讯课程");
		chromeDriver.findElement(By.id("su")).click();
		//Thread.sleep(3000);
		WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='-综合性在线终身学习平台']")));
		chromeDriver.findElement(By.xpath("//a[text()='-综合性在线终身学习平台']")).click();
	}
	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		chromeDriver = new ChromeDriver();
	}
}

