package progresive.qa.test.auto;

import org.testng.annotations.Test;

import base.BaseClass;

public class AutoTest extends BaseClass{

	@Test
	public void autoTest() {
		landingPage.clickAuto(commonActions);
		zipCodePage.inputZipCode(commonActions,"11419");
		zipCodePage.clickQuoteBtn(commonActions);
		startPage.inputFirstName(commonActions, "John");
		startPage.inputMiddleName(commonActions, 'H');
		startPage.inputLastName(commonActions, "Doe");
	}
}
