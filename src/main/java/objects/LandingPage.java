package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonActions;

public class LandingPage {

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//p[contains(text(),'Auto')])[1]")
	WebElement autoElement;
	
	//WebElement autoElement = BaseClass.driver.findElement(By.xpath("(//p[contains(text(),'Auto')])[1]"));
	
	private void clickAuto(CommonActions commonActions) {
		commonActions.click(autoElement);
	}
	
	public void landingPageSteps(CommonActions commonActions) {
		clickAuto(commonActions);
	}
}
