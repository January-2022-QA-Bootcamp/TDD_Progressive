package progresive.qa.test.auto;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import utils.ExcelUtils;

public class AutoTestExcelDataProvider extends BaseClass{

	@DataProvider(name = "autoData")
	public Object[][] dataObjects(){
		ExcelUtils excelUtils = new ExcelUtils("./src/test/resources/UserData.xlsx", "Sheet1");
		return excelUtils.dataTable();
	}
	
	@Test(dataProvider = "autoData")
	public void autoTest(String zip, String firstName, String middleName, String lastName, String suffix, String dob, String address, String apt, String city, String pobox,
			String vYear, String vMake, String vModel, String body, String primaryUse, String rideShare, String owneOrLease, String owneDuration, String alarmnType, String enabled, String dayLightLamp) {
		landingPage.landingPageSteps(commonActions);
		zipCodePage.zipCodePageSteps(commonActions, zip);
		startPersonalDetailsPage.startPersonalDetailsPageSteps(commonActions, firstName, middleName.charAt(0), lastName,suffix, dob,
				address, apt, city, Boolean.parseBoolean(pobox));
		vehicleDetailsPage.vehicleDetailsPageSteps(commonActions, vYear, vMake, vModel, body, primaryUse, Boolean.parseBoolean(rideShare), owneOrLease, owneDuration,alarmnType, Boolean.parseBoolean(enabled), Boolean.parseBoolean(dayLightLamp));
	}
}
