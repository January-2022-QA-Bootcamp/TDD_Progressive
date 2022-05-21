package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;
	
	public synchronized static ExtentReports getInstance() {
		if(extent == null) {
			try {
				extent = new ExtentReports();
				ExtentSparkReporter spark = new ExtentSparkReporter("./test-output/Spark.html");
				spark.config().setReportName("Progressive Automation");
				extent.attachReporter(spark);
				extent.setSystemInfo("Team", "QE Avengers");
				extent.setSystemInfo("Environment", "QA");
				extent.setSystemInfo("OS", System.getProperty("os.name"));
				System.out.println("Reporting Started...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return extent;
	}
}
