package elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import extensions.HyperLinkControlExtension;
import framework.PageObjectBase;

public class HyperLink extends PageObjectBase{
	@FindBy(id="unauthorized")
	private WebElement linkElement;
	
	@FindBy(id="linkResponse")
	private WebElement resultText;
	
	public HyperLink(WebDriver driver) {
		super(driver);
	}

	public HyperLink clickOnLink() {
		new HyperLinkControlExtension(linkElement).selectLink();
		return this;
	}
	
	public String getLinkResultValue() {
		return new HyperLinkControlExtension(resultText).getValue();
	}
}
