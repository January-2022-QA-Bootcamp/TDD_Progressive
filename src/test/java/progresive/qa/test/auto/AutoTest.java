package progresive.qa.test.auto;

import org.testng.annotations.Test;
import base.BaseClass;

public class AutoTest extends BaseClass{

	@Test
	public void autoTest() {
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
		startPersonalDetailsPage.fixError(commonActions, "12312 Liberty Avenue");
	}
}
