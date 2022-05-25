package progresive.qa.test.auto;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import reporting.ExtentTestManger;
import utils.ExcelUtils;
import utils.ReadConfigFile;

public class AutoTestArrayDataProvider extends BaseClass{

	@DataProvider(name = "autoData")
	public Object[][] dataObjects(){
		String filePath = ReadConfigFile.getInstance().getExcelPath();
		String sheetName = ReadConfigFile.getInstance().getSheetName();
		ExcelUtils excelUtils = new ExcelUtils(filePath, sheetName);
		System.out.println(excelUtils.dataTable().length);
		return excelUtils.dataTable();
	}
	
	@Test(dataProvider = "autoData", groups = {"excel"})
	public void autoTest(String zip, String firstName, String middleName, String lastName, String suffix, String dob, String address, String apt, String city, String pobox,
			String vYear, String vMake, String vModel, String body, String primaryUse, String rideShare, String owneOrLease, String owneDuration, String alarmnType, String enabled, String dayLightLamp) {
		System.out.println(ExtentTestManger.extentMap.size());
		landingPage.landingPageSteps(commonActions);
		zipCodePage.zipCodePageSteps(commonActions, zip);
		startPersonalDetailsPage.startPersonalDetailsPageSteps(commonActions, firstName, middleName.charAt(0), lastName,suffix, dob,
				address, apt, city, Boolean.parseBoolean(pobox));
		vehicleDetailsPage.vehicleDetailsPageSteps(commonActions, vYear, vMake, vModel, body, primaryUse, Boolean.parseBoolean(rideShare), owneOrLease, owneDuration,alarmnType, Boolean.parseBoolean(enabled), Boolean.parseBoolean(dayLightLamp));
	}
}
