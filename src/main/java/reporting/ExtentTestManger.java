package reporting;

import java.util.HashMap;
import java.util.Map;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManger {

	public static Map<Integer, ExtentTest> extentMap = new HashMap<Integer, ExtentTest>();
	private static ExtentReports extent = ExtentManager.getInstance();
	
	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest test = extent.createTest(testName, desc);
		extentMap.put((int)(long) Thread.currentThread().getId(), test);
		return test;
	}
	
	public static synchronized ExtentTest getTest() {
		return extentMap.get((int)(long)Thread.currentThread().getId());
	}
	
	public static synchronized ExtentTest startTest(String testName) {
		return startTest(testName,"");
	}
}
