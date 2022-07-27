package webauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SpeicalElement {
	private static ChromeDriver chromeDriver;
	public static void main(String[] args) throws InterruptedException {
		openChrome();
//		chromeDriver.get("https://www.baidu.com");
//		chromeDriver.findElement(By.id("s-usersetting-top")).click();
//		chromeDriver.findElement(By.xpath("//span[text() = '高级搜索']")).click();
//		Thread.sleep(2000);
//		WebElement webElement = chromeDriver.findElement(By.id("adv-setting-gpc"));
//		Select select = new Select(webElement);
//		select.selectByIndex(1);
//		Thread.sleep(2000);
//		select.selectByVisibleText("最近一月");
		chromeDriver.get("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");
		WebElement sourceElement = chromeDriver.findElement(By.id("treeDemo_2_span"));
		WebElement targetElement = chromeDriver.findElement(By.id("treeDemo_3_span"));
		Actions actions = new Actions(chromeDriver);
		actions.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
	}
	
	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		chromeDriver = new ChromeDriver();
	}
}
