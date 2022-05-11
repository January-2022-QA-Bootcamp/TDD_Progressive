package progresive.qa.test.auto;

import org.testng.annotations.Test;
import base.BaseClass;

public class AutoTest extends BaseClass{

	@Test(enabled = true)
	public void autoTestJeep() {
		landingPage.clickAuto(commonActions);
		zipCodePage.inputZipCode(commonActions,"11419");
		zipCodePage.clickQuoteBtn(commonActions);
		startPersonalDetailsPage.inputFirstName(commonActions, "John");
		startPersonalDetailsPage.inputMiddleName(commonActions, 'H');
		startPersonalDetailsPage.inputLastName(commonActions, "Doe");
		startPersonalDetailsPage.selectSuffix(commonActions, "III");
		startPersonalDetailsPage.inputDOB(commonActions, "06/07/1977");
		startPersonalDetailsPage.inputAddress(commonActions, "12312 Liberty Avenue");
		startPersonalDetailsPage.inputAptNo(commonActions, "2B");
		startPersonalDetailsPage.inputCity(commonActions, "Jamaica");
		startPersonalDetailsPage.checkPOBoxorMilitary(commonActions, true);
		startPersonalDetailsPage.clickStartMyQuote(commonActions);
		startPersonalDetailsPage.fixError(commonActions, "12312 Liberty Avenue", "Jamaica");
		vehicleDetailsPage.selectVehicleYear(commonActions, "2022");
		vehicleDetailsPage.selectVehicleMake(commonActions, "JEEP");
		vehicleDetailsPage.selectVehicleModel(commonActions, "CHEROKEE");
		vehicleDetailsPage.selectVehicleBodyType(commonActions, "SUV (4CYL 4X2)");
		vehicleDetailsPage.selectVehiclePrimaryUse(commonActions, "4TNC");
		vehicleDetailsPage.checkRideShare(commonActions, false);
		vehicleDetailsPage.selectVehicleOwnOrLease(commonActions, "3");
		vehicleDetailsPage.selectVehicleOwnedDuration(commonActions, "E");
		vehicleDetailsPage.selectVehicleAlarmType(commonActions, "5");
		vehicleDetailsPage.clickDoneBtn(commonActions);
		vehicleDetailsPage.clickContinueBtn(commonActions);
	}
	
	@Test(enabled = false)
	public void autoTestBmw() {
		landingPage.clickAuto(commonActions);
		zipCodePage.inputZipCode(commonActions,"11419");
		zipCodePage.clickQuoteBtn(commonActions);
		startPersonalDetailsPage.inputFirstName(commonActions, "John");
		startPersonalDetailsPage.inputMiddleName(commonActions, 'H');
		startPersonalDetailsPage.inputLastName(commonActions, "Doe");
		startPersonalDetailsPage.selectSuffix(commonActions, "III");
		startPersonalDetailsPage.inputDOB(commonActions, "06/07/1977");
		startPersonalDetailsPage.inputAddress(commonActions, "12312 Liberty Avenue");
		startPersonalDetailsPage.inputAptNo(commonActions, "2B");
		startPersonalDetailsPage.inputCity(commonActions, "Jamaica");
		startPersonalDetailsPage.checkPOBoxorMilitary(commonActions, true);
		startPersonalDetailsPage.clickStartMyQuote(commonActions);
		startPersonalDetailsPage.fixError(commonActions, "12312 Liberty Avenue", "Jamaica");
	}
}
