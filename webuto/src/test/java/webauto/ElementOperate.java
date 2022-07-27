package webauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementOperate {
	private static ChromeDriver chromeDriver;
	public static void main(String[] args) throws InterruptedException {
		openChrome();
//		chromeDriver.findElement(By.id("kw")).sendKeys("123456");
//		Thread.sleep(3000);
//		chromeDriver.findElement(By.id("kw")).clear();
		WebElement webElement = chromeDriver.findElement(By.id("kw"));
		System.out.println("得到元素的标签名" + webElement.getTagName());
		System.out.println("得到元素的maxlength名" + webElement.getAttribute("maxlength"));
		WebElement webElement2 = chromeDriver.findElement(By.xpath("//a[text()='hao123']"));
		System.out.println("得到元素的文本值" + webElement2.getText());
		System.out.println("元素是否显示" + webElement2.isDisplayed());

	}
	
	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.baidu.com");
	}

}
