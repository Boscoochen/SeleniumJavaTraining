package webauto;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementOperate {
	private static ChromeDriver chromeDriver;
	public static void main(String[] args) throws InterruptedException {
//		openChrome();
//		chromeDriver.findElement(By.id("kw")).sendKeys("123456");
//		Thread.sleep(3000);
//		chromeDriver.findElement(By.id("kw")).clear();
//		WebElement webElement = chromeDriver.findElement(By.id("kw"));
//		System.out.println("得到元素的标签名" + webElement.getTagName());
//		System.out.println("得到元素的maxlength名" + webElement.getAttribute("maxlength"));
//		WebElement webElement2 = chromeDriver.findElement(By.xpath("//a[text()='hao123']"));
//		System.out.println("得到元素的文本值" + webElement2.getText());
//		System.out.println("元素是否显示" + webElement2.isDisplayed());
	
		int temp;
		boolean isPrime=true;
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter any number:");
		//capture the input in an integer
		int num=scan.nextInt();
	        scan.close();
		for(int i=2;i<=num/2;i++)
		{
	           temp=num%i;
		   if(temp==0)
		   {
		      isPrime=false;
		      break;
		   }
		}
		//If isPrime is true then the number is prime else not
		if(isPrime)
		   System.out.println(num + " is a Prime Number");
		else
		   System.out.println(num + " is not a Prime Number");
	}
	
	public static void openChrome() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.baidu.com");
	}
}
