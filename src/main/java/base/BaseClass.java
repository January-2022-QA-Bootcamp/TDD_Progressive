package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import commons.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.LandingPage;
import objects.StartPersonalDetailsPage;
import objects.VehicleDetailsPage;
import objects.ZipCodePage;
import reporting.ExtentManager;
import reporting.ExtentTestManger;
import utils.ReadConfigFile;

public class BaseClass {

	public static WebDriver driver;
	private ExtentReports extent;
	
	protected LandingPage landingPage;
	protected CommonActions commonActions;
	protected ZipCodePage zipCodePage;
	protected StartPersonalDetailsPage startPersonalDetailsPage;
	protected VehicleDetailsPage vehicleDetailsPage;
		
  	@BeforeSuite
	public void reportingInitiating() {
		extent = ExtentManager.getInstance();
	}
  	
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
	
	@BeforeMethod
	public void startReport(Method method) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManger.startTest(method.getName());
		ExtentTestManger.getTest().assignCategory(className);
	}
	
	@AfterMethod
	public void afterEachTestMethod(ITestResult result) {
		for(String groups : result.getMethod().getGroups()) {
			ExtentTestManger.getTest().assignCategory(groups);
		}
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManger.getTest().log(Status.PASS, "Test Passed");
		}else if(result.getStatus() == ITestResult.SKIP) {
			ExtentTestManger.getTest().log(Status.SKIP, "Test Skipped");
		}else if(result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManger.getTest().log(Status.FAIL, "Test Failed \n" + result.getThrowable());
			commonActions.getScreenShot();
		}
	}
	
	@AfterMethod
	public void cleaningUp() {
		driver.quit();
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	
	private void initClasses() {
		commonActions = new CommonActions();
		landingPage = new LandingPage(driver);
		zipCodePage = new ZipCodePage(driver);
		startPersonalDetailsPage = new StartPersonalDetailsPage(driver);
		vehicleDetailsPage = new VehicleDetailsPage(driver);
	}
	
	
}
