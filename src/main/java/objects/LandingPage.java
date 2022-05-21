package objects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonActions;
import utils.ReadConfigFile;
import utils.ReadTxtFile;

public class LandingPage {

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//p[contains(text(),'Auto')])[1]")
	WebElement autoElement;
	@FindBy(tagName = "h1")
	WebElement titlElement;
	
	//WebElement autoElement = BaseClass.driver.findElement(By.xpath("(//p[contains(text(),'Auto')])[1]"));
	
	private void clickAuto(CommonActions commonActions) {
		commonActions.click(autoElement);
	}
	
	private void checkTitle(CommonActions commonActions) {
		String actualTitle = commonActions.getText(titlElement);
		String expected = "";
		
		String filePath = ReadConfigFile.getInstance().getTitleFilePath();
		ReadTxtFile readTxtFile = new ReadTxtFile(filePath);
		
		List<String> titles = readTxtFile.getListData();
		for(String title:titles) {
			if(title.equalsIgnoreCase(actualTitle)) {
				expected = title;
			}
		}
		commonActions.textVerification(actualTitle, expected);
	}
	
	public void landingPageSteps(CommonActions commonActions) {
		clickAuto(commonActions);
		checkTitle(commonActions);
	}
}
