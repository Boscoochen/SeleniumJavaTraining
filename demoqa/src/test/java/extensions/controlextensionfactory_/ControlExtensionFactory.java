package extensions.controlextensionfactory_;
import org.openqa.selenium.WebElement;
import extensions.HyperLinkControlExtension;
import extensions.RadioButtonExtension;
import extensions.selectMenuControlExtension;
import extensions.sliderControlExtension;

public class ControlExtensionFactory {
	public RadioButtonExtension getRadioButton(WebElement element) {
		return new RadioButtonExtension(element);
	}
	
	public HyperLinkControlExtension getHyperLink(WebElement element) {
		return new HyperLinkControlExtension(element);
	}
	
	public sliderControlExtension getSlider(WebElement element) {
		return new sliderControlExtension(element);
	}
	
	public selectMenuControlExtension getSelectMenu(WebElement element) {
		return new selectMenuControlExtension(element);
	}
}
