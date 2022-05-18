package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import commons.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.LandingPage;
import objects.StartPersonalDetailsPage;
import objects.VehicleDetailsPage;
import objects.ZipCodePage;
import reporting.JavaLog;
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
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browser) {
		settingUpDriver(browser);
		driver.get(ReadConfigFile.getInstance().getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ReadConfigFile.getInstance().getPageLoadTime()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReadConfigFile.getInstance().getImplicitlyWaitTime()));
		initClasses();
	}
	
	private WebDriver settingUpDriver(String driverName) {
		JavaLog.log(System.getProperty("os.name"));
		if(driverName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(driverName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(driverName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
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
