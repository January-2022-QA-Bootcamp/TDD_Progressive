package progresive.qa.test.auto;

import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import dataProvider.AutoData;

public class AutoTestDataProviderClass extends BaseClass{

	@DataProvider(name = "autoData")
	public Iterator<AutoData> autoData(){
		ArrayList<AutoData> list = new ArrayList<AutoData>();
		AutoData jeepData = new AutoData("11418", "Adam", 'J', "Obama","III", "11/04/1980",
				"12312 Liberty Avenue", "2B", "Jamaica", true, "2022", "JEEP", "CHEROKEE", "SUV (4CYL 4X2)", "4TNC", false, "3", "E","5",false, true);
		AutoData bmwData = new AutoData("11418", "Jenny", 'H', "Doe","II", "11/04/1987",
				"12312 Liberty Avenue", "2B", "Jamaica", true, "2022", "BMW", "230", "", "4TNC", false, "3", "E","5",false, false);
		list.add(jeepData);
		list.add(bmwData);
		return list.iterator();
	}
	
	@Test(enabled = true, priority = 1, groups = {"externalData, auto"}, dataProvider = "autoData")
	public void autoTestWithDataProviderClass(AutoData autoData) {
		landingPage.landingPageSteps(commonActions);
		zipCodePage.zipCodePageSteps(commonActions, autoData);
		startPersonalDetailsPage.startPersonalDetailsPageSteps(commonActions, autoData);
		vehicleDetailsPage.vehicleDetailsPageSteps(commonActions, autoData);
	}
}
