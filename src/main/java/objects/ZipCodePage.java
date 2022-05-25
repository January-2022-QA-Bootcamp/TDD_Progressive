package objects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.CommonActions;
import dataProvider.AutoData;

public class ZipCodePage {

	public ZipCodePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//*[@name='ZipCode'])[1]")
	WebElement zipCodeInputElement;
	@FindBy(xpath = "(//input[@name='qsButton'])[1]")
	WebElement getQuoteBtnElement;
	@FindBy(id = "zipCode_overlay_subproducts")
	WebElement altZipCodeElement;
	@FindBy(id = "qsButton_overlay_subproducts")
	WebElement altGetQuoteBtnElement;
	
	
	private void inputZipCode(CommonActions commonActions, String value) {
		if(whichUrl(commonActions).equalsIgnoreCase("https://www.progressive.com/#s")) {
			commonActions.inputText(altZipCodeElement, value);
		}else {
			commonActions.inputText(zipCodeInputElement, value);
		}
	}
	
	private void clickQuoteBtn(CommonActions commonActions) {
		if(whichUrl(commonActions).equalsIgnoreCase("https://www.progressive.com/#s")) {
			commonActions.click(altGetQuoteBtnElement);
		}else {
			commonActions.click(getQuoteBtnElement);
		}
	}
	
	private String whichUrl(CommonActions commonActions) {
		return commonActions.getUrl();
	}
	
	public void zipCodePageSteps(CommonActions commonActions, String zip) {
		inputZipCode(commonActions, zip);
		clickQuoteBtn(commonActions);
	}
	
	public void zipCodePageSteps(CommonActions commonActions, AutoData autoData) {
		inputZipCode(commonActions, autoData.getZipCode());
		clickQuoteBtn(commonActions);
	}
	
	public void zipCodePageSteps(CommonActions commonActions, Map<String, String>inputMap) {
		inputZipCode(commonActions, inputMap.get("Zip"));
		clickQuoteBtn(commonActions);
	}
}
