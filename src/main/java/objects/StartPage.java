package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonActions;

public class StartPage {

	public StartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="NameAndAddressEdit_embedded_questions_list_FirstName")
	WebElement firstNameInputElement;
	@FindBy(id="NameAndAddressEdit_embedded_questions_list_MiddleInitial")
	WebElement middleNameInputElement;
	@FindBy(id="NameAndAddressEdit_embedded_questions_list_LastName")
	WebElement lastNameInputElement;
	
	
	public void inputFirstName(CommonActions commonActions, String firstName) {
		commonActions.inputText(firstNameInputElement, firstName);
	}
	
	public void inputMiddleName(CommonActions commonActions, char middleName) {
		commonActions.inputText(middleNameInputElement, middleName);
	}
	
	public void inputLastName(CommonActions commonActions, String lastName) {
		commonActions.inputText(lastNameInputElement, lastName);
	}
}
