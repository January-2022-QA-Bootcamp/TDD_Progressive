package amazon.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MusicPage {

	public MusicPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="a-autoid-0-announce")
	public WebElement tryOutElement;
}
