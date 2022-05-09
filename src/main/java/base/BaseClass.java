package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import commons.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.LandingPage;
import objects.StartPersonalDetailsPage;
import objects.ZipCodePage;

public class BaseClass {

	public static WebDriver driver;
	protected LandingPage landingPage;
	protected CommonActions commonActions;
	protected ZipCodePage zipCodePage;
	protected StartPersonalDetailsPage startPersonalDetailsPage;
	
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.progressive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		initClasses();
	}
	
	@AfterMethod
	public void cleaningUp() {
		//driver.quit();
	}
	
	private void initClasses() {
		commonActions = new CommonActions();
		landingPage = new LandingPage(driver);
		zipCodePage = new ZipCodePage(driver);
		startPersonalDetailsPage = new StartPersonalDetailsPage(driver);
	}
	
}
