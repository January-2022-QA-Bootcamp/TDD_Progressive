package amazon.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h1")
	public WebElement titleElement;
}
