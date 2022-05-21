package reporting;

import java.util.logging.Logger;
import org.testng.Reporter;
import com.aventstack.extentreports.Status;

public class JavaLog {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void log(final String msg) {
		LOGGER.info(msg);
		Reporter.log(msg + "<br>");
		ExtentTestManger.getTest().log(Status.INFO, msg);
	}
}
