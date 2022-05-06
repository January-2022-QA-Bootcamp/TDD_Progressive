package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.CommonActions;

public class ZipCodePage {

	public ZipCodePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//*[@name='ZipCode'])[1]")
	WebElement zipCodeInputElement;
	@FindBy(xpath = "(//input[@name='qsButton'])[1]")
	WebElement getQuoteBtnElement;
	
	public void inputZipCode(CommonActions commonActions, String value) {
		commonActions.inputText(zipCodeInputElement, value);
	}
	
	public void clickQuoteBtn(CommonActions commonActions) {
		commonActions.click(getQuoteBtnElement);
	}
}
