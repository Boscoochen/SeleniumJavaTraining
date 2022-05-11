package elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.hyperlinkpage;

public class HyperLink extends hyperlinkpage{
	@FindBy(id="unauthorized")
	private WebElement linkElement;
	
	@FindBy(id="linkResponse")
	private WebElement resultText;
	
	public HyperLink(WebDriver driver) {
		super(driver);
	}

	public HyperLink clickOnLink(String linkName) {
		getControlExtensionFactory().getHyperLink(linkElement).selectLink(linkName);
		return this;
	}
	
	public String getLinkResultValue() {
		return getControlExtensionFactory().getHyperLink(resultText).getValue();
	}
}
