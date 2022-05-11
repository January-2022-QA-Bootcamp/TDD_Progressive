package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonActions;

public class VehicleDetailsPage {

	public VehicleDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "VehiclesNew_embedded_questions_list_Year")
	WebElement yearSelectionElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_Make")
	WebElement makeSelectionElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_Model")
	WebElement modelSelectionElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_BodyStyle")
	WebElement bodyTypeSelectionElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_VehicleUse")
	WebElement primaryUseElement;
	@FindBy(tagName = "checkbox-input")
	WebElement rideShareCheckElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_OwnOrLease")
	WebElement ownOrLeasElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_LengthOfOwnership")
	WebElement ownedVehicleDurationElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_AntitheftDevice")
	WebElement securityAlarmElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_DayTimeRunningLights_N")
	WebElement dayTimeLampNElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_DayTimeRunningLights_Y")
	WebElement dayTimeLampYElement;
	@FindBy(xpath = "//button[text()='Done']")
	WebElement doneBtnElement;
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueBtnElement;
	
	public void selectVehicleYear(CommonActions commonActions, String year) {
		commonActions.selectByValue(yearSelectionElement, year);
	}
	
	public void selectVehicleMake(CommonActions commonActions, String make) {
		commonActions.selectByValue(makeSelectionElement, make);
	}
	
	public void selectVehicleModel(CommonActions commonActions, String model) {
		commonActions.selectByValue(modelSelectionElement, model);
	}
	
	public void selectVehicleBodyType(CommonActions commonActions, String bodyType) {
		if(bodyType!=null) {
			commonActions.selectByValue(bodyTypeSelectionElement, bodyType);
		}
	}
	
	public void selectVehiclePrimaryUse(CommonActions commonActions, String primaryUse) {
		commonActions.selectByValue(primaryUseElement, primaryUse);
	}
	
	public void checkRideShare(CommonActions commonActions, boolean isVehicleUseForRideShare) {
		boolean status = commonActions.isSelected(rideShareCheckElement);
		if(!status && isVehicleUseForRideShare) {
			commonActions.click(rideShareCheckElement);
		}else if(status) {
			commonActions.logEventAndFail("Deafult status of "+ rideShareCheckElement + " : is selected");
		}
	}
	
	public void selectVehicleOwnOrLease(CommonActions commonActions, String ownOrLease) {
		commonActions.selectByValue(ownOrLeasElement, ownOrLease);
	}
	
	public void selectVehicleOwnedDuration(CommonActions commonActions, String duration) {
		commonActions.selectByValue(ownedVehicleDurationElement, duration);
	}
	
	public void selectVehicleAlarmType(CommonActions commonActions, String alarmType) {
		commonActions.selectByValue(securityAlarmElement, alarmType);
	}
	
	public void checkVehicleDaytimeLamp(CommonActions commonActions, boolean isDayTimeLamp) {
		boolean status = commonActions.isSelected(dayTimeLampYElement);
		if(status && isDayTimeLamp) {
		//	commonActions.click(dayTimeLampYElement);
		}else if(status && !isDayTimeLamp){
			commonActions.click(dayTimeLampNElement);
		}else {
			commonActions.logEventAndFail("Daytime Lamp is not in selected status");
		}
	}
	
	public void clickDoneBtn(CommonActions commonActions) {
		commonActions.click(doneBtnElement);
	}
	
	public void clickContinueBtn(CommonActions commonActions) {
		commonActions.click(continueBtnElement);
	}
}
