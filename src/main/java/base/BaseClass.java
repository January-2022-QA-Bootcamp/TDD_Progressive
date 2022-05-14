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
import objects.VehicleDetailsPage;
import objects.ZipCodePage;
import utils.ReadConfigFile;

public class BaseClass {

	public static WebDriver driver;
	protected LandingPage landingPage;
	protected CommonActions commonActions;
	protected ZipCodePage zipCodePage;
	protected StartPersonalDetailsPage startPersonalDetailsPage;
	protected VehicleDetailsPage vehicleDetailsPage;
	
	/*	
  	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Running our Framework");
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("This is before Test Annotation");
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("Before Class");
	}
	*/
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(ReadConfigFile.getInstance().getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ReadConfigFile.getInstance().getPageLoadTime()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReadConfigFile.getInstance().getImplicitlyWaitTime()));
		initClasses();
	}
	
	@AfterMethod
	public void cleaningUp() {
		driver.quit();
	}
	
	/*
	@AfterClass
	public void afterClass() {
		Reporter.log("After Class");
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("After test");
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("Closing Framework execution");
	}
	*/
	private void initClasses() {
		commonActions = new CommonActions();
		landingPage = new LandingPage(driver);
		zipCodePage = new ZipCodePage(driver);
		startPersonalDetailsPage = new StartPersonalDetailsPage(driver);
		vehicleDetailsPage = new VehicleDetailsPage(driver);
	}
	
}
