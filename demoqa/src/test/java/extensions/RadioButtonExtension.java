package extensions;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import framework.ControlExtensionBase;

public class RadioButtonExtension extends ControlExtensionBase {
	public RadioButtonExtension(WebElement element) {
		super(element);
		this.wrappedElement = element;
	}

	public void selectButton(String label, WebDriver driver) {
		this.wrappedElement.click();
		if(label.equals("Impressive") || label.equals("Yes")) {
			String verifyText = driver.findElement(By.xpath("//*[@id=\"app\"]//div/p")).getText();
			System.out.println(verifyText);
			if(!("You have selected " + this.getValue()).equals(verifyText)) {
				throw new RuntimeException("the label button '" + this.getValue() + "' not clicked");
			}
		}else if(label.equals("No")) {
			//No label button was selected, but not sure how to display You have select "You have selected Impressive" text
			if(!this.getValue().equals(label)) {
				System.out.println("No label button need to be clicked");
			}
		}
	}

	public WebElement findButton(String label, List<WebElement> elements, WebDriver driver) {
		if(!(label.equals("No") || label.equals("Yes") || label.equals("Impressive"))) {
			throw new RuntimeException("the label + '" + label + "' could not found");
		}
		
		for (WebElement webElement : elements) {
			if(label.equals(webElement.getText())) {
				this.wrappedElement = webElement;
			}
		}

		//enable No button
		if(label.equals("No")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("document.getElementById(\"noRadio\").disabled=false;");
		}
		return this.wrappedElement;
	}
}
