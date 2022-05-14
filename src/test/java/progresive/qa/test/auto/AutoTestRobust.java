package progresive.qa.test.auto;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;

public class AutoTestRobust extends BaseClass{
	
	@Parameters({"zipvalue", "firstname"})
	@Test(enabled = true, groups = {"auto","bmw"})
	public void bmwTest(String zipValue, String firstName) {
		landingPage.landingPageSteps(commonActions);
		zipCodePage.zipCodePageSteps(commonActions, zipValue);
		startPersonalDetailsPage.startPersonalDetailsPageSteps(commonActions, firstName, 'H', "Doe","II", "11/04/1987",
				"12312 Liberty Avenue", "2B", "Jamaica", true);
		vehicleDetailsPage.vehicleDetailsPageSteps(commonActions, "2022", "BMW", "230", "", "4TNC", false, "3", "E","5",false, false);
	}

	@Test(enabled = true, priority = 1, groups = {"auto","jeep"})
	public void jeepTest() {
		landingPage.landingPageSteps(commonActions);
		zipCodePage.zipCodePageSteps(commonActions, "11418");
		startPersonalDetailsPage.startPersonalDetailsPageSteps(commonActions, "John", 'H', "Doe","II", "11/04/1987",
				"12312 Liberty Avenue", "2B", "Jamaica", true);
		vehicleDetailsPage.vehicleDetailsPageSteps(commonActions, "2022", "JEEP", "CHEROKEE", "SUV (4CYL 4X2)", "4TNC", false, "3", "E","5",false, true);
	}
	
	@Test(enabled = true, dependsOnMethods = "jeepTest", ignoreMissingDependencies = true, groups = {"jeep"})
	public void dependsOnMethod() {
		
	}
	
	@Test(dependsOnGroups = {"bmw"}, ignoreMissingDependencies = true, alwaysRun = true, enabled = false)
	public void dependsOnGroups() {
		
	}
}
