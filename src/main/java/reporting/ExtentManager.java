package reporting;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;
	
	public synchronized static ExtentReports getInstance() {
		if(extent == null) {
			try {
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hh.mm");
				String format = dateFormat.format(date);
				extent = new ExtentReports();
				ExtentSparkReporter spark = new ExtentSparkReporter("./test-output/extentReports/extentreport_"+format+".html");
				spark.config().setReportName("Progressive Automation");
				extent.attachReporter(spark);
				extent.setSystemInfo("Team", "QE Avengers");
				extent.setSystemInfo("Environment", "QA");
				extent.setSystemInfo("OS", System.getProperty("os.name"));
				extent.setSystemInfo("Tester", System.getProperty("user.name"));
				System.out.println("Reporting Started...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return extent;
	}
}
