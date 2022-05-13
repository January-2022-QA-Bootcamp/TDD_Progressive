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
	By requiredErrorMsgAddressBy = By.xpath("(//div[contains(.,'Required to continue')])[4]");
	By requiredErrorMsgCityBy = By.xpath("(//div[contains(.,'Required to continue')])[5]");
	
	private void inputFirstName(CommonActions commonActions, String firstName) {
		commonActions.inputText(firstNameInputElement, firstName);
	}
	
	private void inputMiddleName(CommonActions commonActions, char middleName) {
		commonActions.inputText(middleNameInputElement, middleName);
	}
	
	private void inputLastName(CommonActions commonActions, String lastName) {
		commonActions.inputText(lastNameInputElement, lastName);
	}
	
	private void selectSuffix(CommonActions commonActions, String suffix) {
		commonActions.selectByValue(suffixElement, suffix);
	}
	
	private void inputDOB(CommonActions commonActions, String dobString) {
		commonActions.inputText(dOBElement, dobString);
	}
	
	private void inputAddress(CommonActions commonActions, String address) {
		//commonActions.sleep(3);
		//commonActions.click(streetAddressElement);
		commonActions.inputText(streetAddressElement, address);
		//commonActions.inputUsingJSXforIdLocator(streetAddressElement.getAttribute("id"), address);
	}
	
	private void inputAptNo(CommonActions commonActions, String aptNo) {
		commonActions.inputText(aptNoElement, aptNo);
	}
	
	private void inputCity(CommonActions commonActions, String cityName) {
		commonActions.inputText(cityElement, cityName);
	}
	
	private void checkPOBoxorMilitary(CommonActions commonActions, boolean isPOBox) {
		boolean statusOfElement = commonActions.isSelected(checkboxElement);
		if(!statusOfElement && isPOBox) {
			commonActions.click(checkboxElement);
		}else if(statusOfElement){
			commonActions.logEventAndFail("Element is selected");
			/*
				commonActions.logEvent("Element is selected");
				Assert.fail();
				Using these two liners from common actions, so in case other steps need to reuse it
				Purpose of common actions class is to resuse all events again for all test steps 
			 */
		}
	}
	
	private void clickStartMyQuote(CommonActions commonActions) {
		commonActions.click(startMyQuotElement);
	}
	
	private void fixError(CommonActions commonActions, String address, String city, String aptNo) {
		boolean isErrorPresent = commonActions.isPresent(requiredErrorMsgAddressBy);
		if(isErrorPresent && commonActions.getUrl().equalsIgnoreCase("https://autoinsurance1.progressivedirect.com/0/UQA/Quote/NameAndAddressEdit")) {
			inputAddress(commonActions, address);
			inputAptNo(commonActions, aptNo);
		}
		
		boolean isCityErrorPresent = commonActions.isPresent(requiredErrorMsgCityBy);
		if(isCityErrorPresent) {
			inputCity(commonActions, city);
		}
		
		if(commonActions.getUrl().equalsIgnoreCase("https://autoinsurance1.progressivedirect.com/0/UQA/Quote/NameAndAddressEdit")) {
			clickStartMyQuote(commonActions);
		}
	}
	
	public void startPersonalDetailsPageSteps(CommonActions commonActions, String firstName, char middleName, String lastName, String suffix, String dob, String address,
			String aptNo, String city, boolean isPOBox) {
		
		inputFirstName(commonActions, firstName);
		inputMiddleName(commonActions, middleName);
		inputLastName(commonActions, lastName);
		selectSuffix(commonActions, suffix);
		inputDOB(commonActions, dob);
		inputAddress(commonActions, address);
		inputAptNo(commonActions, aptNo);
		inputCity(commonActions, city);
		checkPOBoxorMilitary(commonActions, isPOBox);
		clickStartMyQuote(commonActions);
		fixError(commonActions, address, city, aptNo);
	}
}
