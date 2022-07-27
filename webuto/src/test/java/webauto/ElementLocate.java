package webauto;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementLocate {
	private static ChromeDriver chromeDriver;
	public static void main(String[] args) {
		openChrome();
//		chromeDriver.findElement(By.id("kw")).sendKeys("腾讯课堂");
//		chromeDriver.findElement(By.name("wd")).sendKeys("腾讯课堂");
//		chromeDriver.findElement(By.tagName("input")).sendKeys("腾讯课堂");
//		chromeDriver.findElement(By.className("s_ipt")).sendKeys("腾讯课堂");
//		chromeDriver.findElement(By.className("s_btn")).click();
//		chromeDriver.findElement(By.linkText("新闻")).click();
//		chromeDriver.findElement(By.partialLinkText("闻")).click();
//		chromeDriver.findElement(By.cssSelector("input"));
//		chromeDriver.findElement(By.cssSelector("#kw")).sendKeys("腾讯课堂");
//		chromeDriver.findElement(By.cssSelector(".s_ipt")).sendKeys("腾讯课堂");
		chromeDriver.findElement(By.cssSelector("input[maxlength='255'][autocomplete='off']")).sendKeys("腾讯课堂");
		chromeDriver.findElement(By.cssSelector(".bg.s_btn")).click();
//		chromeDriver.quit();
	}
	
	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.baidu.com");
	}
}
