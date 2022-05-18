package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonActions;
import dataProvider.AutoData;

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

	private void selectVehicleYear(CommonActions commonActions, String year) {
		commonActions.selectByValue(yearSelectionElement, year);
	}

	private void selectVehicleMake(CommonActions commonActions, String make) {
		commonActions.selectByValue(makeSelectionElement, make);
	}

	private void selectVehicleModel(CommonActions commonActions, String model) {
		commonActions.selectByValue(modelSelectionElement, model);
	}

	private void selectVehicleBodyType(CommonActions commonActions, String bodyType) {
		if (bodyType != null && bodyType.length() > 1) {
			commonActions.selectByValue(bodyTypeSelectionElement, bodyType);
		}
	}

	private void selectVehiclePrimaryUse(CommonActions commonActions, String primaryUse) {
		commonActions.selectByValue(primaryUseElement, primaryUse);
	}

	private void checkRideShare(CommonActions commonActions, boolean isVehicleUseForRideShare) {
		boolean status = commonActions.isSelected(rideShareCheckElement);
		if (!status && isVehicleUseForRideShare) {
			commonActions.click(rideShareCheckElement);
		} else if (status) {
			commonActions.logEventAndFail("Deafult status of " + rideShareCheckElement + " : is selected");
		}
	}

	private void selectVehicleOwnOrLease(CommonActions commonActions, String ownOrLease) {
		commonActions.selectByValue(ownOrLeasElement, ownOrLease);
	}

	private void selectVehicleOwnedDuration(CommonActions commonActions, String duration) {
		commonActions.selectByValue(ownedVehicleDurationElement, duration);
	}

	private void selectVehicleAlarmType(CommonActions commonActions, String alarmType) {
		commonActions.selectByValue(securityAlarmElement, alarmType);
	}

	private void checkVehicleDaytimeLamp(CommonActions commonActions, boolean isPresent, boolean isDayTimeLamp) {
		if (isPresent) {
			boolean status = commonActions.isSelected(dayTimeLampYElement);
			if (status && isDayTimeLamp) {
				// commonActions.click(dayTimeLampYElement);
			} else if (status && !isDayTimeLamp) {
				commonActions.click(dayTimeLampNElement);
			} else {
				commonActions.logEventAndFail("Daytime Lamp is not in selected status");
			}
		}
	}

	private void clickDoneBtn(CommonActions commonActions) {
		commonActions.click(doneBtnElement);
	}

	private void clickContinueBtn(CommonActions commonActions) {
		commonActions.click(continueBtnElement);
	}

	public void vehicleDetailsPageSteps(CommonActions commonActions, String vehicleYear, String vehicleMake,
			String vehicleModel, String bodyType, String primaryUse, boolean isRideShare, String ownOrLease,
			String ownedDuration, String alarmType, boolean isEnable, boolean isDayLightLamp) {

		selectVehicleYear(commonActions, vehicleYear);
		selectVehicleMake(commonActions, vehicleMake);
		selectVehicleModel(commonActions, vehicleModel);
		selectVehicleBodyType(commonActions, bodyType);
		selectVehiclePrimaryUse(commonActions, primaryUse);
		checkRideShare(commonActions, isRideShare);
		selectVehicleOwnOrLease(commonActions, ownOrLease);
		selectVehicleOwnedDuration(commonActions, ownedDuration);
		selectVehicleAlarmType(commonActions, alarmType);
		checkVehicleDaytimeLamp(commonActions, isEnable, isDayLightLamp);
		clickDoneBtn(commonActions);
		clickContinueBtn(commonActions);
	}
	
	public void vehicleDetailsPageSteps(CommonActions commonActions, AutoData autoData) {

		selectVehicleYear(commonActions, autoData.getvYear());
		selectVehicleMake(commonActions, autoData.getvMake());
		selectVehicleModel(commonActions, autoData.getvModel());
		selectVehicleBodyType(commonActions, autoData.getBodyType());
		selectVehiclePrimaryUse(commonActions, autoData.getPrimaryUse());
		checkRideShare(commonActions, autoData.isRideShare());
		selectVehicleOwnOrLease(commonActions, autoData.getOwnOrLease());
		selectVehicleOwnedDuration(commonActions, autoData.getOwnedDuration());
		selectVehicleAlarmType(commonActions, autoData.getAlarmType());
		checkVehicleDaytimeLamp(commonActions, autoData.isEnable(), autoData.isDayTimeLamp());
		clickDoneBtn(commonActions);
		clickContinueBtn(commonActions);
	}
}
