package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonActions;

public class StartPersonalDetailsPage {

	public StartPersonalDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="NameAndAddressEdit_embedded_questions_list_FirstName")
	WebElement firstNameInputElement;
	@FindBy(id="NameAndAddressEdit_embedded_questions_list_MiddleInitial")
	WebElement middleNameInputElement;
	@FindBy(id="NameAndAddressEdit_embedded_questions_list_LastName")
	WebElement lastNameInputElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_Suffix")
	WebElement suffixElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_DateOfBirth")
	WebElement dOBElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_MailingAddress")
	WebElement streetAddressElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_ApartmentUnit")
	WebElement aptNoElement;
	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_City")
	WebElement cityElement;
	@FindBy(tagName = "checkbox-input")
	WebElement checkboxElement;
	@FindBy(className = "blue")
	WebElement startMyQuotElement;
	//@FindBy(xpath = "(//div[contains(.,'Required to continue')])[4]")
	//WebElement reuiredErrorMsgElement;
	By reuiredErrorMsgBy = By.xpath("(//div[contains(.,'Required to continue')])[4]");
	
	public void inputFirstName(CommonActions commonActions, String firstName) {
		commonActions.inputText(firstNameInputElement, firstName);
	}
	
	public void inputMiddleName(CommonActions commonActions, char middleName) {
		commonActions.inputText(middleNameInputElement, middleName);
	}
	
	public void inputLastName(CommonActions commonActions, String lastName) {
		commonActions.inputText(lastNameInputElement, lastName);
	}
	
	public void selectSuffix(CommonActions commonActions, String suffix) {
		commonActions.selectByValue(suffixElement, suffix);
	}
	
	public void inputDOB(CommonActions commonActions, String dobString) {
		commonActions.inputText(dOBElement, dobString);
	}
	
	public void inputAddress(CommonActions commonActions, String address) {
		//commonActions.sleep(3);
		//commonActions.click(streetAddressElement);
		commonActions.inputText(streetAddressElement, address);
		//commonActions.inputUsingJSXforIdLocator(streetAddressElement.getAttribute("id"), address);
	}
	
	public void inputAptNo(CommonActions commonActions, String aptNo) {
		commonActions.inputText(aptNoElement, aptNo);
	}
	
	public void inputCity(CommonActions commonActions, String cityName) {
		commonActions.inputText(cityElement, cityName);
	}
	
	public void checkPOBoxorMilitary(CommonActions commonActions, boolean isPOBox) {
		boolean statusOfElement = commonActions.isSelected(checkboxElement);
		if(!statusOfElement && isPOBox) {
			commonActions.click(checkboxElement);
		}else if(statusOfElement){
			commonActions.logEventAndFail("Element is selected");
			/*
				commonActions.logEvent("Element is selected");
				Assert.fail();
				Using these two liners from common actions, so in case other steps need to resuse it
				Purpose of common actions class is to resuse all events again for all test steps 
			 */
		}
	}
	
	public void clickStartMyQuote(CommonActions commonActions) {
		commonActions.click(startMyQuotElement);
	}
	
	public void fixError(CommonActions commonActions, String address) {
		boolean isErrorPresent = commonActions.isPresent(reuiredErrorMsgBy);
		if(isErrorPresent && commonActions.getUrl().equalsIgnoreCase("https://autoinsurance1.progressivedirect.com/0/UQA/Quote/NameAndAddressEdit")) {
			inputAddress(commonActions, address);
			clickStartMyQuote(commonActions);
		}
	}
}
