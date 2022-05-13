package progresive.qa.test.auto;

import org.testng.annotations.Test;

import base.BaseClass;

public class AutoTestRobust extends BaseClass{
	
	@Test(enabled = true, groups = {"auto","regression", "smoke"})
	public void bmwTest() {
		landingPage.landingPageSteps(commonActions);
		zipCodePage.zipCodePageSteps(commonActions, "11418");
		startPersonalDetailsPage.startPersonalDetailsPageSteps(commonActions, "John", 'H', "Doe","II", "11/04/1987",
				"12312 Liberty Avenue", "2B", "Jamaica", true);
		vehicleDetailsPage.vehicleDetailsPageSteps(commonActions, "2022", "BMW", "230", "", "4TNC", false, "3", "E","5",false, false);
	}

	@Test(enabled = true, priority = 1, groups = {"auto", "regression"})
	public void jeepTest() {
		landingPage.landingPageSteps(commonActions);
		zipCodePage.zipCodePageSteps(commonActions, "11418");
		startPersonalDetailsPage.startPersonalDetailsPageSteps(commonActions, "John", 'H', "Doe","II", "11/04/1987",
				"12312 Liberty Avenue", "2B", "Jamaica", true);
		vehicleDetailsPage.vehicleDetailsPageSteps(commonActions, "2022", "JEEP", "CHEROKEE", "SUV (4CYL 4X2)", "4TNC", false, "3", "E","5",false, true);
	}
}
