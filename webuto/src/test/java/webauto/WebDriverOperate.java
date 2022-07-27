package webauto;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverOperate {
	private static ChromeDriver chromeDriver;
	public static void main(String[] args) throws InterruptedException {
		openChrome();
//		System.out.println("当前的url为： " + chromeDriver.getCurrentUrl());
//		System.out.println("当前的标题为： " + chromeDriver.getTitle());
//		System.out.println("当前页面的源代码：" + chromeDriver.getPageSource());
//		chromeDriver.quit();
		
//		chromeDriver.close();
		chromeDriver.findElement(By.id("kw")).sendKeys("腾讯课堂");
		chromeDriver.findElement(By.id("su")).click();
		System.out.println("新窗口打开前的句柄：" + chromeDriver.getWindowHandle());
		System.out.println("新窗口打开前的所有句柄：" + chromeDriver.getWindowHandles());
		Thread.sleep(3000);
		chromeDriver.findElement(By.xpath("//*//a[@target='_blank']/div[@class='label-wrap_3RqUW']")).click();
		Thread.sleep(3000);
		System.out.println("新窗口打开后的句柄：" + chromeDriver.getWindowHandle());
		System.out.println("新窗口打开后的所有句柄：" + chromeDriver.getWindowHandles());
		
//		Options options = chromeDriver.manage();
//		Dimension dimension =  options.window().getSize();
//		System.out.println("窗口的高度：" + dimension.getHeight());
//		System.out.println("窗口的宽度：" + dimension.getWidth());
//		System.out.println(options.window().getPosition().x);
//		System.out.println(options.window().getPosition().y);
		
		Navigation navigation = chromeDriver.navigate();
		navigation.to("https://www.jd.com");
		navigation.refresh();
		navigation.back();
		navigation.forward();
	}
	
	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.baidu.com");
	}

}
