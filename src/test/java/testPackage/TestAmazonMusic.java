package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class TestAmazonMusic extends BaseClass{

	@Test
	public void aTestMethod() {
		mainPage.musicTabElement.click();
		musicPage.tryOutElement.click();
		String titleElement = signInPage.titleElement.getText();
		System.out.println(titleElement);
		String url = driver.getCurrentUrl();
		System.out.println("Current URL : " + url);
		String modifiedUrl = url.substring(0, url.indexOf("?"));
		System.out.println(modifiedUrl);
		Assert.assertEquals(modifiedUrl, "https://www.amazon.com/ap/signin");
	}
}
